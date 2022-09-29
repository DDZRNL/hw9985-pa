
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

import gov.nasa.jpf.jvm.bytecode.IADD;
import gov.nasa.jpf.jvm.bytecode.ISUB;
import gov.nasa.jpf.jvm.bytecode.GETFIELD;

public class SetFieldListener extends ListenerAdapter {

	@Override
	public void executeInstruction(VM vm, ThreadInfo currentThread, Instruction instructionToExecute) {
		  //System.out.println(instructionToExecute);
		  MethodInfo mi = currentThread.getTopFrameMethodInfo();
		  if (mi != null && mi.getClassName().equals("Demo")) {
			  if (instructionToExecute instanceof GETFIELD) {
				  GETFIELD inst = (GETFIELD) instructionToExecute;
				  ElementInfo ei = inst.peekElementInfo(currentThread);
				  ei.setIntField("fff", ei.getIntField("fff") + 1);
			  }
		  }
	}
  
	// @Override
	// public void onMessageReceived(MessageReceivedEvent event)
	// {
		 // System.out.printf("[%s]: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
	// }
}
