
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class CFT implements ClassFileTransformer {

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        // PrintStream out=new PrintStream("111.txt");
		// System.setOut(out);
		
		if (className != null && !className.startsWith("java") && !className.startsWith("sun") && !className.startsWith("jdk")){ 
		//if (className.equals("C")) {
			ClassReader cr = new ClassReader(classfileBuffer);
			System.out.println("Class-Name:"+className);
			ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);

			// 2. modify the IR
			TraceVisitor tv = new TraceVisitor(cw);
			cr.accept(tv, 0);

			// 3. return array of bytes
			return cw.toByteArray();
		}else {
            return null;
        }
		
		//out.close();
    }
}
