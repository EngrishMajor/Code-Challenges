package easy;

//Write a function that converts an int into its alpha-numeric equivalent represented as a null terminated string.
//The function should accept an int as input and return a string as output. 
//For instance, calling the function with an int value of 324 would return a null terminated string containing "324". 
//Ensure that your function checks for appropriate boundary conditions and edge cases. 
//Assume you cannot use any standard libraries (for example, no itoa or sprintf).

public class Atoi {
	
	public static String intParse(int input) {
		if (input == 0)
			return "0\0";
		
		String retVal = "";
		int copy;
		
		for (copy = input; copy != 0; copy /= 10) {
			int digit = Math.abs(copy % 10);
			retVal = String.valueOf(digit) + retVal;
		}
		
		if (input < 0)
			retVal = "-" + retVal;
		
		retVal += "\0";
		return retVal;
	}
	
	public static void main(String args[]) {
		System.out.println(intParse(1));
		System.out.println(intParse(8125));
		System.out.println(intParse(0));
		System.out.println(intParse(-519));
		System.out.println(intParse(-3));
	}
}
