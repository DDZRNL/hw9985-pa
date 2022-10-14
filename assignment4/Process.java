import java.util.HashMap;
import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Process {
	private static HashMap<String, String> Method_Class = new HashMap<String, String>();
	private static HashMap<String, String> Method_Signature = new HashMap<String, String>();
	private static HashMap<String, Integer> Method_Count = new HashMap<String, Integer>();
	
    public static void main(String[] args) throws IOException{
		/* Read TXT file */
		String pathname = "temp.txt"; 
		File filename = new File(pathname); // read file
		InputStreamReader reader = new InputStreamReader(
				new FileInputStream(filename)); 
		BufferedReader br = new BufferedReader(reader);
		String line = "";
		//line = br.readLine();
		
		String ClassName="";
		
		while (line != null) {
			//System.out.println(line);
			String[] temp=line.split(":");
			if(line.startsWith("Class-Name")){
				ClassName=temp[1];
			}
			else if(line.startsWith("Method-Name")){
				
				if(!Method_Class.containsKey(temp[1])){
					Method_Class.put(temp[1],ClassName);
				}
			}
			else if(line.startsWith("Signature")){
				if(!Method_Signature.containsKey(temp[1])){
					Method_Signature.put(temp[1],temp[2]);
				}
			}
			else{
				if(!Method_Count.containsKey(line)){
					Method_Count.put(line,1);
				}
				else{
					int c=Method_Count.get(line);
					Method_Count.remove(line);
					Method_Count.put(line,c+1);
				}
			}
			line = br.readLine(); // read data line by line
		}
		
		/* 写入Txt文件 */
			File writename = new File("output.txt"); 
			writename.createNewFile(); // Create new file
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			for(String key : Method_Class.keySet()){
				
				//String value = map.get(key);
				//System.out.println(key+"  "+value);
				out.write(Method_Class.get(key)+"."+key+":"+Method_Signature.get(key)+" "+Method_Count.get(key));
				out.write("\r\n");
			}

			out.flush(); // push the catch into the file
			out.close(); // Close the file
		
		
    }
}


