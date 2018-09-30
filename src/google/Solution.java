package google;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

	double res = -1.0;
	Map<String, Map<String, Double>> g = new HashMap<>();

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		createGraph(equations, values);
		double[] result = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			String qSrc = queries[i][0];
			String qDest = queries[i][1];
			Set<String> visited = new HashSet<>();
			res = -1.0;
			dfs(qSrc, qDest, visited, 1.0);
			result[i] = res;
		}
		return result;
	}

	private void dfs(String src, String dest, Set<String> visited, double curVal) {
		if (res != -1.0)
			return;

		if (visited.contains(src))
			return;

		if (!g.containsKey(src))
			return;

		Map<String, Double> neighbours = g.get(src);

		if (neighbours.containsKey(dest)) {
			double dist = neighbours.get(dest);
			res = curVal * dist;
			return;
		}

		visited.add(src);
		for (String s : neighbours.keySet()) {
			dfs(s, dest, visited, curVal * neighbours.get(s));
		}
		visited.remove(src);
	}

	private void createGraph(String[][] equations, double[] values) {
		for (int i = 0; i < equations.length; i++) {
			String src = equations[i][0];
			String dest = equations[i][1];
			double distance = values[i];

			Map<String, Double> temp1 = null;
			Map<String, Double> temp2 = null;

			if (!g.containsKey(src)) {
				temp1 = new HashMap<>();
				g.put(src, temp1);
			} else {
				temp1 = g.get(src);
			}
			temp1.put(dest, values[i]);

			if (!g.containsKey(dest)) {
				temp2 = new HashMap<>();
				g.put(dest, temp2);
			} else {
				temp2 = g.get(dest);
			}
			temp2.put(src, 1 / values[i]);
		}
	}
}