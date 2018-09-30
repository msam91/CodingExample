package dp;

import java.util.ArrayList;
import java.util.List;

public class JumpToReach {

    public static void main(String args[]) {

        JumpToReach j = new JumpToReach();
        int a[] = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };
        j.jumpToReach(a);
    }

    private void jumpToReach(int[] a) {
        int jumpToReach[] = new int[a.length];
        int result[] = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            jumpToReach[i] = Integer.MAX_VALUE;
        }

        jumpToReach[0] = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= a[j] + j) {
                    if (jumpToReach[j] + 1 < jumpToReach[i]) {
                        jumpToReach[i] = jumpToReach[j] + 1;
                        result[i] = j;

                    }
                }
            }
        }

        System.out.print(jumpToReach[a.length - 1]);
        
        int last = a.length-1;
        List<Integer>track = new ArrayList<Integer>();
        
        while(last>0){
            track.add(a[last]);
            last =result[last];
        }
        
    }
}
