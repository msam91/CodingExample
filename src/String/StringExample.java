package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class StringExample {

    public static void main(String[] args) {
        String x = new String("ab");
        System.out.println(x);
        
        HashSet<String>b = new HashSet<String>();
        b.add("manas");
        change(x,b);
        
        String managerList = "";
        List<String> managerEmailList = new ArrayList<String>(Arrays.asList(managerList.split(",")));
        for (String managerEmail : managerEmailList) {
            System.out.println(",");
        }

    }
     
    public static void change(String x,HashSet<String>a) {
        x = "cd";
        a.add("SAMANT");
    }
}
