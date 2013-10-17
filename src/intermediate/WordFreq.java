package intermediate;
import java.io.*;
import java.util.*;

//Frequency Counting of Words / Top N words in a document.
//Given N terms, your task is to find the k most frequent terms from given N terms.
//Input format
//First line of input contains N, denoting the number of terms to add.
//In each of the next N lines, each contains a term.
//Next line contains k, most frequent terms.
//Output format
//Print the k most frequent terms in descending order of their frequency. If two terms have same frequency print them in lexicographical order.
//
//Sample input
//14
//Fee
//Fi
//Fo
//Fum
//Fee
//Fo
//Fee
//Fee
//Fo
//Fi
//Fi
//Fo
//Fum
//Fee
//3
//
//Sample output
//Fee
//Fo
//Fi

public class WordFreq 
{
	public String termArray[];
	public int freqArray[];
	public Hashtable<String, Integer> table;
	public int n;
	public int k;
	
	public WordFreq()
	{
		termArray = null;
		freqArray = null;
		table = null;
		n = 0;
		k = 0;
	}
	
	public static void quicksort(String terms[], int freqs[], int left, int right)
	{
		if (left == right)
			return;
		
		int loopLeft = left;
		int loopRight = right;
		int pivotIndex;
		int mid = (left + right) / 2;
		
		while(true)
		{
			pivotIndex = partition(terms, freqs, loopLeft, loopRight, mid);
			if (pivotIndex == mid)
				break;
			else if (mid < pivotIndex)
				loopRight = pivotIndex - 1;
			else
				loopLeft = pivotIndex + 1;
		}
		
		if (left < pivotIndex)
			quicksort(terms, freqs, left, pivotIndex - 1);
		if (right > pivotIndex)
			quicksort(terms, freqs, pivotIndex + 1, right);
	}
	
	public static int partition(String terms[], int freqs[], int left, int right, int pivotIndex)
	{
		int pivotValue = freqs[pivotIndex];
		String pivotTerm = terms[pivotIndex];
		swap(terms, freqs, pivotIndex, right);
		int storeIndex = left;
		for (int i = left; i < right; i++)
			if (freqs[i] < pivotValue || (freqs[i] == pivotValue && terms[i].compareTo(pivotTerm) > 0))
			{
				swap(terms, freqs, i, storeIndex);
				storeIndex++;
			}

		swap(terms, freqs, storeIndex, right);
		
		return storeIndex;
	}
	
	public static void swap(String terms[], int freqs[], int first, int second)
	{
		int tempFreq = freqs[first];
		freqs[first] = freqs[second];
		freqs[second] = tempFreq;
		String tempTerm = terms[first];
		terms[first] = terms[second];
		terms[second] = tempTerm;
	}
	
	public static void main(String args[]) throws Exception
	{
		WordFreq solution = new WordFreq();
		solution.table = new Hashtable<String, Integer>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//System.out.println("Input the number of terms to add.");
		solution.n = Integer.parseInt(in.readLine());
		
		//System.out.println("Input your terms.");
		for (int i = 0; i < solution.n; i++)
		{
			String term = in.readLine();
			if (!solution.table.containsKey(term))
				solution.table.put(term, 1);
			else
				solution.table.put(term, solution.table.get(term) + 1);
		}
		
		Enumeration<String> termEnum = solution.table.keys();
		Enumeration<Integer> freqEnum = solution.table.elements();
		
		solution.termArray = new String[solution.table.size()];
		solution.freqArray = new int[solution.table.size()];
		
		int i = 0;
		while (termEnum.hasMoreElements() && freqEnum.hasMoreElements())
		{
			solution.termArray[i] = termEnum.nextElement();
			solution.freqArray[i] = freqEnum.nextElement();
			i++;
		}
		
		quicksort(solution.termArray, solution.freqArray, 0, solution.table.size() - 1);
		//System.out.println("Input how many terms to print");
		solution.k = Integer.parseInt(in.readLine());
		
		for (i = solution.termArray.length - 1; i > solution.termArray.length - solution.k - 1; i--)
			System.out.println(solution.termArray[i]);
	}
}
