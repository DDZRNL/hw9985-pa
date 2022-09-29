
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

public class AddToSubListener extends ListenerAdapter {

    @Override
    public void executeInstruction(VM vm, ThreadInfo currentThread, Instruction instructionToExecute) {
        MethodInfo mi = currentThread.getTopFrameMethodInfo();
        if (instructionToExecute instanceof IADD
            && mi != null
            && mi.getClassName().equals("Demo")) {
            ISUB sub = new ISUB();
            sub.init(mi, instructionToExecute.getInstructionIndex(), instructionToExecute.getPosition());
            currentThread.setNextPC(sub);
        }
    }
}
