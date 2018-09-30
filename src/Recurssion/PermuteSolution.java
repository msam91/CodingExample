package Recurssion;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;

class PermuteSolution<T> {

    List<List<T>> lists = new ArrayList<>();

    public static void main(String args[]) {
        Integer[] a = { 1, 2, 3 };
        PermuteSolution<Integer> s = new PermuteSolution<Integer>();
        s.permute(a);

        String abc = "MAS";
        Character c[] = abc.chars().mapToObj(ch -> (char) ch).toArray(Character[]::new);
        PermuteSolution<Character> s1 = new PermuteSolution<Character>();
        s1.permute(c);
    }

    public List<List<T>> permute(T[] nums) {
        LinkedHashSet<T>tempList = new LinkedHashSet<T>();
        permute(nums, tempList);
        return lists;
    }

    private void permute(T[] nums, LinkedHashSet<T> tempList) {
        if (nums.length == tempList.size()) {
            print(tempList);
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!tempList.contains(nums[i])) {
                    tempList.add(nums[i]);
                    permute(nums, tempList);
                    tempList.remove(nums[i]);
                }
            }
        }

    }

    private void print(LinkedHashSet<T> temp) {
        for (T t : temp) {
            System.out.print(t);
        }
        System.out.println();
    }
}
