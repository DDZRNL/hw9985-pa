
import java.lang.instrument.Instrumentation;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class DemoAgent {

    private static Instrumentation sInstrumentation;

    public static void premain(String options, Instrumentation instrumentation) throws FileNotFoundException {
		PrintStream out=new PrintStream("temp.txt");
		System.setOut(out);
		
        sInstrumentation = instrumentation;
        instrumentation.addTransformer(new CFT());
		
		//out.close();
    }
}
