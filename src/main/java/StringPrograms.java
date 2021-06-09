
public class StringPrograms {

//	Reverse string using String builder
	public static void reverseStringUsingSB() {
		String name = "ajay";
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb = sb.reverse();
		System.out.println("Reversed string is:"+sb);
	}
	
//	Reverse string using charTo Array
	public static void reverseStringUsingArray() {
		String name = "ajay thakur";
		char[] nameArray = name.toCharArray();
		System.out.println(nameArray);
		System.out.println(nameArray.length);
		for(int i = nameArray.length-1;i>=0; i--) {
			System.out.println(nameArray[i]);
		}
	}
	
	
	//Swap number using third variable
	public static void swapNumberUsingThirdVariable() {
		int a=10;
		int b=20;
		int temp;
		temp=a;   //temp=10
		a=b; //a=20, b=20
		b=temp; //b=10
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	
//	Swap number without using third variable
	public static void swapWithoutThirdVariable() {
		int a=10;
		int b=20;
		
		a = a+b; //a=30
		b = a-b; //b = 10
		a = a-b; //a=20
		System.out.println("a="+a);
		System.out.println("b="+b);
		
	}
	
	//Find duplicate characters in a string
	public static void duplicateCharInString() {
		String name = new String("aajjjay");
		int count=0;
		char[] nameArray = name.toCharArray();
		for (int i=0; i<nameArray.length; i++) {
			for (int j=0; j<name.length(); j++) {
				if(nameArray[i] == nameArray[j]) {
					System.out.println("Duplicate are: "+nameArray[j]);
					count++;
					break;
				}
			}
			
		}
	}
	
	public static void testEquals() {
		String name1 = new String("ajay");
		String name2 = new String ("ajay");
		System.out.println(name1.equals(name2));
		System.out.println(name1==name2);
	}
	

	public static void main(String[] args) {
		reverseStringUsingSB();
		reverseStringUsingArray();
		swapNumberUsingThirdVariable();
		swapWithoutThirdVariable();
		duplicateCharInString();
		testEquals();
	}

}
