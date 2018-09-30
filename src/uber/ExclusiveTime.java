package uber;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTime {

    public static void main(String args[]) {
        ExclusiveTime et = new ExclusiveTime();
        String a[] =
        { "0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6" };
        int result[] = et.exclusiveTime(2, Arrays.asList(a));
        for (int t : result) {
            System.out.print(t+",");
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int res[] = new int[n];
        Stack<int[]> s = new Stack<int[]>();

        for (String log : logs) {
            String logArray[] = log.split(":");
            int function = Integer.parseInt(logArray[0]);
            String state = logArray[1];
            int t = Integer.parseInt(logArray[2]);

            if (state.equals("start")) {
                s.push(new int[] { function, t });
            }
            else {
                int prevTime = t - s.pop()[1] + 1;
                res[function] += prevTime;
                if (!s.empty())
                    res[s.peek()[0]] -= prevTime;

            }
        }
        return res;

    }
}
