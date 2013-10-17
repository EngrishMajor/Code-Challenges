package easy;

import java.io.*;

//Given a list of integers, your task is to write a program to output an integer-valued list of equal length such that the output element at index 'i' is the product of all input elements except for the input element at 'i'.
//In other words, let inputArray by an integer array of length 'n'. The solution,computed into outputArray, would be:
//for each j from 1 to n-2:
//outputArr[ j ] = inputArray[0] * inputArray[1] * inputArray[2] * ... * inputArray[j-1] * inputArray[j+1] * inputArray[j+2] *...* inputArray[n-1]
//for j = 0
//outputArray[0] = inputArray[1] * outputArray[2] * ... * outputArray[n-1]
//for j = n-1
//outputArray[n-1] = outputArray[0] * outputArray[1] * outputArray[2] * ... * outputArray[n-2]
//As an example, if inputArray = { 1, 2, 3, 4 }, then
//outputArray = { 2*3*4, 1*3*4, 1*2*4, 1*2*3 }.
//Your program should run in O(n) time and should be space efficient.
//Input format
//First line of input contains N , number of elements in list.
//Next N lines will each contain an element (a signed integer)
//Output format
//Print the output list of numbers.
//
//Sample input
//4
//5
//2
//2
//3
//
//Sample output
//12
//30
//30
//20
//
//You may assume that:
//The input array size will always have at least two elements in it, that is, n >= 2.
//The product of any subset of the input will never exceed the value of a 64 bit integer.
//The maximum length of input array is 1000.

public class ProductArray {
	int n; //number of elements in the array
	int inputArray[]; //array of inputs
	
	public ProductArray() {
		n = 0;
		inputArray = null;
	}
	
	public static void main(String args[]) throws Exception {
		ProductArray solution = new ProductArray();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		solution.n = Integer.parseInt(in.readLine());
		solution.inputArray = new int[solution.n];
		int product = 1;
		
		for (int i = 0; i < solution.n; i++) {
			int input = Integer.parseInt(in.readLine());
			solution.inputArray[i] = input;
			product *= solution.inputArray[i];
		}
		
		for (int i = 0; i < solution.n; i++) {
			solution.inputArray[i] = product / solution.inputArray[i];
			System.out.println(solution.inputArray[i]);
		}
	}
}
