package XMini;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Interpreter {
	public static ArrayList<String> variables = new ArrayList<String>();
	public static ArrayList<String> values = new ArrayList<String>();
	
	public static void Interpreter(String text){
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(text.getBytes(Charset.forName("utf8"))), Charset.forName("utf8"))); 
		//System.out.println("**************Interpreter******************");
		
		Scanner scanner = new Scanner(text);
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  //System.out.println(line);
		  StatementProcess(line);
		  
		}
		scanner.close();
		
		
	}
	
	public static void StatementProcess(String statement) {
		String[] tokens=statement.split("\\s+");
		
		//System.out.println("The length of the str is "+strarray.length);
		
		Map<String, String> map = new HashMap<String, String>();
//		ArrayList<String> variables = new ArrayList<String>();
//		ArrayList<String> values = new ArrayList<String>();
		
		String regex1 = "[0-9]*";  // match the num
		String regex2="[A-Za-z]*";   // match the alphabet
		
		// text
		if(tokens[0].equals("text")) {
			String text_str=statement.replace("text ","");
			if(text_str.contains("\"")) {
				String[] text_quote=statement.split("\"");
				//System.out.println(text_quote.length);
				text_str=text_quote[1];
			}
			text_str=LiteralsProcess(text_str); 
			
			System.out.print(text_str);
			
		}
		// output
		else if(tokens[0].equals("output")) {
			Stack<Object> stack = new Stack<Object>();
			boolean temp = false;
			int fuhao = 0;
			int number = 0;
			for (int i = tokens.length - 1; i > 0; i--) {
				try {
					if (tokens[i].matches(regex1)) {
						stack.push(Integer.parseInt(tokens[i]));
						//stack.push(tokens[i]);
						number++;
					}
					else if(tokens[i].matches(regex2)) {
						int retval=variables.indexOf(tokens[i]);
						
						stack.push(Integer.parseInt(values.get(retval)));
						number++;
					}
					else {
						fuhao++;
						int result;
						if(tokens[i].equals("~") || tokens[i].equals("!")) {
							int a = (int) stack.pop();
							result = compute(a, 0, tokens[i]);
							
						}
						else {
							int a = (int) stack.pop();
							int b = (int) stack.pop();
							result = compute(a, b, tokens[i]);
						}
//						int a = (int) stack.pop();
//						int b = (int) stack.pop();
//						int result = compute(a, b, tokens[i]);
						stack.push(result);
					}
				} catch (Exception e) {
					temp = true;
				}
			}
			if (temp || stack.empty()) {   //|| !(number - 1 == fuhao) 
				System.out.print("ERROR");
			} else {
				int ans = (int) stack.pop();
				System.out.print(ans);
			}

		}
		// var
		else if(tokens[0].equals("var")) {
			Stack<Object> stack = new Stack<Object>();
			boolean temp = false;
			int fuhao = 0;
			int number = 0;
			for (int i = tokens.length - 1; i > 1; i--) {
				try {
					if (tokens[i].matches(regex1)) {
						stack.push(Integer.parseInt(tokens[i]));
						number++;
					} 
					else if(tokens[i].matches(regex2)) {
						int retval=variables.indexOf(tokens[i]);
						
						stack.push(Integer.parseInt(values.get(retval)));
						number++;
					}
					else {
						fuhao++;
						int a = (int) stack.pop();
						int b = (int) stack.pop();
						int result = compute(a, b, tokens[i]);
						stack.push(result);
					}
				} catch (Exception e) {
					temp = true;
				}
			}
			if (temp || !(number - 1 == fuhao) || stack.empty()) {
				System.out.print("ERROR");
			} else {
				int ans = (int) stack.pop();
				//System.out.print(ans);
				
				String value = String.valueOf(ans);
				int retval=variables.indexOf(tokens[1]);
				if(variables.contains(tokens[1])) {
					//System.out.println(retval);
					System.out.print("variable <"+tokens[1]+"> incorrectly re-initialized");
					// change value?????
					values.set(retval, value);
					
				}
				else { 
					variables.add(tokens[1]);
					values.add(value);
					
				}
				
			}
					
		}
		// set
		else if(tokens[0].equals("set")) {
			Stack<Object> stack = new Stack<Object>();
			boolean temp = false;
			int fuhao = 0;
			int number = 0;
			for (int i = tokens.length - 1; i > 1; i--) {
				try {
					if (tokens[i].matches(regex1)) {
						stack.push(Integer.parseInt(tokens[i]));
						number++;
					} else if(tokens[i].matches(regex2)) {
						int retval=variables.indexOf(tokens[i]);
						
						stack.push(Integer.parseInt(values.get(retval)));
						number++;
					}else {
						fuhao++;
						int a = (int) stack.pop();
						int b = (int) stack.pop();
						int result = compute(a, b, tokens[i]);
						stack.push(result);
					}
				} catch (Exception e) {
					temp = true;
				}
			}
			if (temp  || stack.empty()) {
				System.out.print("ERROR");
			} else {
				int ans = (int) stack.pop();
				//System.out.println(ans);
				String value = String.valueOf(ans);
				
				int retval=variables.indexOf(tokens[1]);
				
				if(variables.contains(tokens[1])) {
					//System.out.println(retval);
					values.set(retval, value);
					//System.out.print(values.get(retval));
				}
				else {
					System.out.println("variable <"+tokens[1]+"> not declared");
					//System.out.println(retval);
					variables.add(tokens[1]);
					values.add(value);
					//System.out.print(value);
				}
					
			}
			
			
		}
			
		//System.out.println();
	}
	
	public static int compute(int a, int b, String f) {
		switch (f) {
		case "*":
			return a * b;
		case "/":
			return a / b;
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "%":
			return a%b;
		case "&&":
			return ((Integer)a != 0 && (Integer)b != 0)? 1 : 0;
		case "||":
			return ((Integer)a != 0 || (Integer)b != 0)? 1 : 0;
		case ">":
			return ((Integer)a > (Integer)b)? 1 : 0;
		case "<":
			return ((Integer)a < (Integer)b)? 1 : 0;
		case "==":
			return a==b? 1 : 0;
		case "!=":
			return a!=b? 1:0;
		case "<=":
			return ((Integer)a <= (Integer)b)? 1 : 0;
		case ">=":
			return ((Integer)a >= (Integer)b)? 1 : 0;
		case "!":
			return a==0?1:0;
		case "~":
			return 0-a;
			
		}
		return 0;
	}
	
	public static String LiteralsProcess(String text) {
		String[][] escapeTable=new String[][] {
			{"\\n","\\t","\\b","\\r","\\f","\\'","\\\"","\\\\"},
			{"\n","\t","\b","\r","\f","\'","\"","\\"}
		};
		String res=text;
		
		for(int i=0;i<8;i++) {
			res=res.replace(escapeTable[0][i], escapeTable[1][i]);
		}
		
		return res;
			
	}


}
