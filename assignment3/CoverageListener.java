import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import gov.nasa.jpf.jvm.ClassFile;
import gov.nasa.jpf.report.Publisher;
import gov.nasa.jpf.report.PublisherExtension;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.search.SearchListener;
import gov.nasa.jpf.vm.ChoiceGenerator;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.VMListener;
import gov.nasa.jpf.ListenerAdapter;

import java.util.Set;
import java.util.TreeSet;

import java.util.Comparator;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import gov.nasa.jpf.vm.LocalVarInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.jvm.bytecode.IRETURN;
import gov.nasa.jpf.jvm.bytecode.FRETURN;


public class CoverageListener extends ListenerAdapter {

    private Set<String> lines = new TreeSet<>();
	
	private Set<String> methods = new TreeSet<>();
	private Set<String> argus = new TreeSet<>();
	private Set<String> rets = new TreeSet<>();
	
	private Map<String, Map> memo_method = new HashMap<>();
	private Map<String, String> memo = new HashMap<>();
	private Map<String, String> MethodRet = new HashMap<>();
	
	private String key="";
	private String val="";
	private String ReturnType="";
	private String temp="";
	
	//private IRETURN ireturn = new IRETURN();

    @Override
    public void executeInstruction(VM vm, ThreadInfo currentThread, Instruction instructionToExecute) {
        
		String l = instructionToExecute.getFileLocation();
		
        if (l != null && !l.startsWith("java/") && !l.startsWith("sun/") && !l.startsWith("gov/")) {
			//MethodInfo method=instructionToExecute.getMethodInfo();
			
            lines.add(l);
        }	
		
    }
	
	public void methodEntered(VM vm, ThreadInfo currentThread, MethodInfo enteredMethod){

		String l = enteredMethod.getFullName();
		StackFrame frame=currentThread.getTopFrame(); //getTopFrame(); //getModifiableTopFrame();   //getCallerStackFrame();
		
			
		if (l != null && !l.startsWith("java") && !l.startsWith("sun") && !l.startsWith("gov")) {
			//key="";
			temp="";
			String name=frame.getMethodName();
			methods.add(name);
			temp=temp+name;
			
			Instruction pc = currentThread.getPC();
			
			IRETURN ireturn = new IRETURN();
			
			Object[] arguValues=frame.getArgumentValues(currentThread);
			for(int i=0;i< arguValues.length;i++){
					//System.out.print("ArguValue: " +arguValues[i]+" ");
					if(i==0){
						temp+="(";
					}
					temp=temp+arguValues[i];
					if(i==arguValues.length-1){
						temp=temp+")";
					}else{
						temp=temp+", ";
					}
					
			}

			String filePath = "report2.txt";
			try{
				File file = new File(filePath);
				FileOutputStream fos = null;
				if(!file.exists()){
					file.createNewFile();
					fos = new FileOutputStream(file);
				}else{
					
					fos = new FileOutputStream(file,true);
				}
				OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");

			
				if(memo.containsKey(temp)){
					//System.out.println("Returning memoized return value for "+temp+":"+memo.get(temp)+".");  //  +memo.get(temp)
					out.write("Returning memoized return value for "+temp+":"+memo.get(temp)+".\r\n");
					//currentThread.skipInstruction();
					//StackFrame frame1 = currentThread.getModifiableTopFrame();
					ireturn.init(enteredMethod, pc.getInstructionIndex(), pc.getPosition());
					
					
					int ret1=Integer.valueOf(memo.get(temp)).intValue();
					double ret2=Double.parseDouble(memo.get(temp)); 
					
					
					frame.push(ret1);
					frame.setPC(ireturn);
			
				}
				else{
					key=temp;
					
					ReturnType=enteredMethod.getReturnTypeName();
					MethodRet.put(key, ReturnType);

					//System.out.println(temp+":returnValue is not memoizable.:" );
					//System.out.println("Memoizing "+temp+":");
					// out.write(temp+":returnValue is not memoizable.: \r\n");
					// out.write("Memoizing "+temp+":\r\n");
					
					// int argnum=enteredMethod.getNumberOfArguments() ;
					// System.out.println("The # of argus: "+argnum);
					
					//int res= frame.peek(); //stack.peek();   stack.getResult(); 
					//System.out.println("The result: "+res);
					
				}
				out.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		}	
		
	}

    //@Override
    public void searchFinished(Search search) {
		
		///////////////////////////
		String[] myArray = new String[lines.size()];
		String[] sArray = new String[lines.size()];
		String[] temArray=new String[2];
		Integer[] nums=new Integer[lines.size()];
		
		lines.toArray(myArray);
		temArray=myArray[0].split(":"); 
		String Filename= temArray[0];
		
		for(int i=0;i<lines.size();i++){

			temArray=myArray[i].split(":"); 
			nums[i]=Integer.valueOf(temArray[1]);
			
		}
		Arrays.sort(nums);
		
		try{
			File writename = new File("report.txt"); 
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			for(int i=0;i<lines.size();i++){

				sArray[i]=Filename+":"+nums[i].toString();
				//System.out.println(sArray[i]);
				out.write(sArray[i]+"\r\n");
			}
			out.flush(); 
			out.close(); 
		} catch (IOException e) {
        }
		
        //System.out.println(lines);
		
		///////////////////////////
		//System.out.println("\nMemoization: \n");
		
		String[] Array_method = new String[methods.size()];
		methods.toArray(Array_method);
		
		// for(int i=0;i<methods.size();i++){
			// System.out.println(Array_method[i]);
			
		// }
		
    }
	
	
	@Override
    public void methodExited(VM vm, ThreadInfo currentThread, MethodInfo exitedMethod){
		val="";
		String l = exitedMethod.getFullName();
		
		StackFrame frame=currentThread.getTopFrame(); //getTopFrame();  //getCallerStackFrame();  getModifiableTopFrame();

		if (l != null && !l.startsWith("java") && !l.startsWith("sun") && !l.startsWith("gov")) {
			int res= frame.peek();  //stack.getResult(); 
			//System.out.println("The result: "+res);
			val=val+res;
			//System.out.println("The val: "+val);
			// if(memo.containsKey(temp)){
				// System.out.println("Memoization: "+memo.get(temp));
				// currentThread.skipInstruction();
				// return ;
			// }

			if(!memo.containsKey(key)){
				String filePath = "report2.txt";
				try{
					File file = new File(filePath);
					FileOutputStream fos = null;
					if(!file.exists()){
						file.createNewFile();
						fos = new FileOutputStream(file);
					}else{
						
						fos = new FileOutputStream(file,true);
					}
					OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");

					// System.out.println(key+":"+val+ " is not memoizable." );
					// System.out.println("Memoizing "+key+":"+val+".");
					out.write(key+":"+val+ " is not memoizable."+"\r\n");
					out.write("Memoizing "+key+":"+val+".\r\n");
					out.close();

				}catch (Exception e) {
					e.printStackTrace();
				}
				memo.put(key, val);
			}
			
		}
		
	
		
    }
	
	public String memoCheck(){
		if(memo.containsKey(key)){
			return memo.get(key);
		}
		else{
			memo.put(key, val);
		}
		return val;
	}
	
}
