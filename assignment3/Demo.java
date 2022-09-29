
public class Demo {
    public int fff = 55;
	
	public static int add(int a, int b){
		return a+b;
	}
	
    public static void main(String... args) {
        int a = 55;
        int b = 66;
        int c = a + b;
        System.out.println(c);
		System.out.println(add(a,b));
        System.out.println(new Demo().fff);
		
    }
}

