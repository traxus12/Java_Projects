import java.util.*;
/*
 * Guide to java Datatypes
 */
public class DataTypes{
	public static void main(String[] args){
		//primitive data types

		//whole number data types
		byte a = 1;
		short b = 2;
		int c = 3;
		long d = 4;

		//floating point number types
		float e = 5;
		double f = 6;

		//other primitives
		boolean g = true;
		char h = 'a';
		
		//from these primitives, other data types can be generated
		int[] integerArrayA = new int[5];
		int[] integerArrayB = new int[]{1,2,3,4,5};
		int[] integerArrayC = {1,2,3,4,5,6,7};
		String testString = "this is a test string";

		Stack<String> stack = new Stack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("hello");
		System.out.println(Arrays.toString(stack.toArray()));
		System.out.println(a+b+c+d+e+f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(integerArrayA);
		System.out.println(integerArrayB);
		System.out.println(integerArrayC);
		System.out.println(testString);


	}
}
