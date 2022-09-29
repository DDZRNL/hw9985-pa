package XMini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocess {
	public static String Filepreprocess(String content) {
		//  first delete the comments after // and then process
		// meet the statement, put them in a new line.
		// delete the new line to make every statement are in the his own line
	
	String[] keys= {"text","output","var","set"};
	List<String> keylist = Arrays.asList(keys);
	StringBuilder builder = new StringBuilder();  
	String[] textarray=content.split("\\s+");
	
	//System.out.println("&&&&&&&&&&&&&Original text&&&&&&&&&&&&&&&&&&&&");
	
	int i=0;
	while(i<textarray.length) {
		ArrayList<String> temp = new ArrayList<String>();
		if(keylist.contains(textarray[i])) {
			//ArrayList<String> temp = new ArrayList<String>();
			temp.add(textarray[i]);
			i++;
			
			
			while(i<textarray.length && !keylist.contains(textarray[i])) {
				temp.add(textarray[i]);
				i++;
			}
			
			
			//i--;
			String str=String.join(" ", temp);
			builder.append(str+"\n");
			
			//System.out.println(str);
			
		}

	}
	

	String text=builder.toString();
	//System.out.println(text);
	
	return text;
	}
	public static String ReadFile(String filepath) {

		StringBuilder builder = new StringBuilder();  //all the text
		
		try {
            BufferedReader in = new BufferedReader(new FileReader(filepath));
//            System.out.println(in.read());
//            System.out.println("_____________________________________");
            
            String str;
            while ((str = in.readLine()) != null) {
            	if(str.contains("//")) {    //delete the comments.
            		int i = str.indexOf("//");
            		str = str.substring(0,i);
            	}
            	
            	builder.append(str+" ");
                //System.out.println(str);
            }
            //System.out.println(str);
        } catch (IOException e) {
        }
		
		//System.out.print("*********************************\n");
		String text=builder.toString();
		//System.out.println(text);
		
		return text;
	}
}
