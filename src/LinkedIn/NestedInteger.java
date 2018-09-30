package LinkedIn;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    Integer i;
    List<NestedInteger> list;

    public NestedInteger(Integer i) {
        this.i = i;
        list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
        i = null;
    }

    public boolean isInteger() {
        // TODO Auto-generated method stub
        return i != null;
    }

    public Integer getInteger() {
        // TODO Auto-generated method stub
        if (i != null) {
            return i;
        }
        return null;
    }

    public List<NestedInteger> getList() {
        // TODO Auto-generated method stub
        if (list != null) {
            return list;
        }
        return null;
    }
    

    @Override
    public String toString() {
        return "NestedInteger [i=" + i + ", list=" + list + "]";
    }


    private static int maxDepth = 0;

    public static int getSum(List<NestedInteger> nList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nList) {
            if (ni.isInteger()) {
                sum += ni.i * maxDepth-depth;
            }
            else {
                sum += getSum(ni.getList(), depth + 1);
            }
        }
        return sum;
    }


    public static void getMaxDepth(List<NestedInteger> nList, int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
        }
        for (NestedInteger ni : nList) {
            if (!ni.isInteger()) {
                getMaxDepth(ni.getList(), depth + 1);
            }
        }
    }

    public static void main(String args[]) {

        List<NestedInteger> mainList = new ArrayList<NestedInteger>();
        NestedInteger ni1 = new NestedInteger(1);
        NestedInteger ni2 = new NestedInteger(1);
        List<NestedInteger> ones = new ArrayList<NestedInteger>();
        ones.add(ni1);
        ones.add(ni2);
        NestedInteger niOne = new NestedInteger(ones);

        NestedInteger ni3 = new NestedInteger(2);

        NestedInteger ni4 = new NestedInteger(1);
        NestedInteger ni5 = new NestedInteger(1);
        List<NestedInteger> twos = new ArrayList<NestedInteger>();
        NestedInteger niTwo = new NestedInteger(twos);
        twos.add(ni4);
        twos.add(ni5);

        mainList.add(niOne);
        mainList.add(ni3);
        mainList.add(niTwo);
        

        System.out.print(getSum(mainList, 1));

    }

}
