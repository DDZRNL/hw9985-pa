
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
		StackFrame stack=currentThread.getTopFrame();   //getCallerStackFrame();
		
        if (l != null && !l.startsWith("java") && !l.startsWith("sun") && !l.startsWith("gov")) {
			methods.add(l);
			LocalVarInfo[] Arguinfos=enteredMethod.getArgumentLocalVars();
			
			if(Arguinfos!=null){
				for(int i=0;i< enteredMethod.getArgumentsSize();i++){
					//System.out.println(Arguinfos[i].getName());
					
				}
			}
			String sig=enteredMethod.getSignature();
			//System.out.println(sig);
			
			int argnum=enteredMethod.getNumberOfArguments() ;
			System.out.println(argnum);
			
			
			int res= stack.getResult();
			System.out.println("The result: "+res);
			
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
		for(int i=0;i<lines.size();i++){

			sArray[i]=Filename+":"+nums[i].toString();
			System.out.println(sArray[i]);
		}
		
        //System.out.println(lines);
		
		///////////////////////////
		System.out.println("\nMemoization: \n");
		
		String[] Array_method = new String[methods.size()];
		methods.toArray(Array_method);
		
		for(int i=0;i<methods.size();i++){
			System.out.println(Array_method[i]);
			
		}
		
    }
	
	
	@Override
    public void methodExited(VM vm, ThreadInfo currentThread, MethodInfo exitedMethod){
		
		String l = exitedMethod.getFullName();
		
        // if (l != null && !l.startsWith("java/") && !l.startsWith("sun/") && !l.startsWith("gov/")) {
			
			// int ArgumentSize=exitedMethod.getNumberOfStackArguments();
			// String[] ArgumentTypeNames=exitedMethod.getArgumentTypeNames() ;
			// LocalVarInfo[] varinfo=exitedMethod.getArgumentLocalVars();
			// String[] varnames=exitedMethod.getLocalVariableNames();
			
			// //System.out.println(l);
        // }	
		
		
		// for(int i=0;i<varnames.length;i++){
			// System.out.println(varnames[i]); 
		// }
		
		//System.out.println(method.getName());
		
		//System.out.println(ArgumentSize);
		// for(int i=0;i<ArgumentSize;i++){
			// System.out.println(varinfo[i].getName()); 
		// }
		
		// for(int i=0;i<ArgumentTypeNames.length;i++){
			
			// System.out.println(ArgumentTypeNames[i]);
		// }
		
		// if(varinfo!=null){
			// for(int i=0;i<varinfo.length;i++){
				
				// System.out.println(varinfo[i].getName());
			// }
		// }
		
		
    }
}
