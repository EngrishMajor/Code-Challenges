package easy;
/*
 * Challenge #111
 */
public class StarDelete {
	public static String deleteStar(String input)
	{
		String result = input;
		while (result.contains("*"))
			result = result.substring(0, result.indexOf("*")) + result.substring(result.indexOf("*") + 1);
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(deleteStar("as*Qqwe**rh*Fds*"));
	}
}
