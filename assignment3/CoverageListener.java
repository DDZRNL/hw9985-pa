import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;

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


public class CoverageListener extends ListenerAdapter {

    private Set<String> lines = new TreeSet<>();
	
	private Set<String> methods = new TreeSet<>();
	private Set<String> argus = new TreeSet<>();
	private Set<String> rets = new TreeSet<>();
	
	private Map<String, Map> memo_method = new HashMap<>();
	private Map<String, String> memo = new HashMap<>();
	
	private String key="";
	private String val="";
	private String ReturnType="";
	private String temp="";

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
		StackFrame frame=currentThread.getModifiableTopFrame(); //getTopFrame(); //getTopFrame();   //getCallerStackFrame();
		
        if (l != null && !l.startsWith("java") && !l.startsWith("sun") && !l.startsWith("gov")) {
			//key="";
			temp="";
			String name=frame.getMethodName();
			//System.out.println("method name: "+name);
			methods.add(name);
			temp=temp+name;
			
			Instruction pc = currentThread.getPC();
			
			Object[] arguValues=frame.getArgumentValues(currentThread);
			for(int i=0;i< arguValues.length;i++){
					//System.out.print("ArguValue: " +arguValues[i]+" ");
					temp=temp+arguValues[i];
					
			}
			
			if(memo.containsKey(temp)){
				System.out.println("Memoization: ");  //  +memo.get(temp)
				//currentThread.skipInstruction();
				//StackFrame frame1 = currentThread.getModifiableTopFrame();
			    frame.pop();
			    frame.push(42);

				currentThread.skipInstruction(pc.getNext());
				return ;
				//memoCheck();
				//System.out.println("Memo: "+memo.get(key));
			}
			else{
				key=temp;
				
				//System.out.println();
				//System.out.println("key: "+key);
				
				// String signature=enteredMethod.	getSignature();
				// System.out.println("Signature: "+signature);
				
				ReturnType=enteredMethod.getReturnTypeName();
				//System.out.println("The Return Type of the Method: "+ReturnType);
				
				// int argnum=enteredMethod.getNumberOfArguments() ;
				// System.out.println("The # of argus: "+argnum);
				
				// int res= frame.peek(); //stack.peek();   stack.getResult(); 
				// System.out.println("The result: "+res);
				
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
		
		StackFrame frame=currentThread.getModifiableTopFrame(); //getTopFrame();  //getCallerStackFrame();

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
			
			memo.put(key, val);
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
