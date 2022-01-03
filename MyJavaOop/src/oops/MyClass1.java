package oops;

public class MyClass1 extends MyClass{
	
	/*@Override
	public void test(){
		System.out.println("in myclass1");
		
	}*/
	
	public MyClass1(){
		System.out.println("in myclas1");
	}
	
	public static void main(String...args){
	
		MyClass1 obj = new MyClass1();
		obj.test();
	}
}
