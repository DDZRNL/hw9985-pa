import java.nio.file.Files;
import java.io.File;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.signature.SignatureVisitor;
import org.objectweb.asm.signature.SignatureReader;
import org.objectweb.asm.signature.SignatureWriter;
import org.objectweb.asm.Type;

import java.io.FileNotFoundException;
import java.io.PrintStream;

class MVisitor extends MethodVisitor {

    private String methodName;

    public MVisitor(MethodVisitor mv, String methodName) {
        super(Opcodes.ASM5, mv);
        this.methodName = methodName;
    }

    @Override
    public void visitCode() {
        // 0: getstatic     #3 // Field java/lang/System.out:Ljava/io/PrintStream;
        // 3: ldc           #4 // String mmm
        // 5: invokevirtual #5 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
		
		// PrintStream out=new PrintStream("111.txt");
		// System.setOut(out);

        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn(methodName);
		//System.out.println(methodName);
		//println
        visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

        super.visitCode();
		
		//out.close();

    }
		
}

public class TraceVisitor extends ClassVisitor {

    public TraceVisitor(ClassWriter cw) {
        super(Opcodes.ASM5, cw);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        // System.out.println("Signature: "+signature);
		MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (!name.equals("<init>")) {
            mv = new MVisitor(mv, name);
			System.out.println("Method-Name:"+name);
			System.out.println("Signature:"+name+":"+signature);
			
        }
        return mv;
    }

    public static void main(String[] args) throws Exception {
        String input = args[0];
        String output = args[1];
		
		// PrintStream out=new PrintStream("111.txt");
		// System.setOut(out);

        // 1. load .class file that we want to modify
        byte[] code = Files.readAllBytes(new File(input).toPath());
        ClassReader cr = new ClassReader(code);
		
		//System.out.println("Class Name: "+cr.getClassName());
        ClassWriter cw = new ClassWriter(cr, 0);

        // 2. modify the IR
        TraceVisitor tv = new TraceVisitor(cw);
        cr.accept(tv, 0);

        // 3. output to a file
        byte[] newCode = cw.toByteArray();
        Files.write(new File(output).toPath(), newCode);
		
		//out.close();
    }
}
