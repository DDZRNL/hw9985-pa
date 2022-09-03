package XMini;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello world");
		
		Preprocess processor=new Preprocess();
		Interpreter interpreter=new Interpreter();
		
		String content=processor.ReadFile("src/tests/test2.xmini");  //"src/tests/test1.xmini"
		String text=processor.Filepreprocess(content);
		
		interpreter.Interpreter(text);
		
			
		
	}



}


