package google;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
	Set<String> seen;
	StringBuilder ans;
	
	public static void main(String args[]) {
		Solution1 s1 = new Solution1();
		System.out.print(s1.crackSafe(2, 2));
	}

	public String crackSafe(int n, int k) {
		if (n == 1 && k == 1)
			return "0";
		seen = new HashSet();
		ans = new StringBuilder();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n - 1; ++i)
			sb.append("0");
		String start = sb.toString();
		int count =1;
		dfs(start, k,count);
		ans.append(start);
		return new String(ans);
	}

	public void dfs(String node, int k,int count) {
		for (int x = 0; x < k; ++x) {
			String nei = node + x;
			System.out.println(nei);
			if (!seen.contains(nei)) {
				seen.add(nei);
				dfs(nei.substring(1), k,count+1);
				ans.append(x);
				System.out.println("prev function returned"+ ans);
			}
		}
	}
}
