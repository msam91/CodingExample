package List;

public class Solution1 {
	private final String[] belowTen = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine" };
	private final String[] belowTwenty = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
			"Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	private final String[] belowHundred = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
			"Seventy", "Eighty", "Ninety" };
	
	public static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) {
		Solution1 s1 = new Solution1();
		s1.numberToWords(543);
		System.out.println(sb.toString());
	}

	public void numberToWords(int num) {
		helper(num);
	}

	private String helper(int num) {
		if (num < 10)
		 return belowTen[num];
		else if (num < 20)
		 return belowTwenty[num - 10];
		else if (num < 100)
			sb.append(belowHundred[num / 10]).append(" ").append(helper(num % 10));
		else if (num < 1000)
			sb.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
		else if (num < 1000000)
			sb.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
		else if (num < 1000000000)
			sb.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
		else
			sb.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
		
		return sb.toString().trim();
	}
}
