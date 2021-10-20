
import java.util.*;

public class LargeArraySum {
    
    public static List<Integer> largestArraySum(int [] myArray)
    {
        List<Integer> subArr = new ArrayList<Integer>();   

        return subArr;
    }

    public static void main(String [] args)
    {
        int [] testarr = {1, 100, -50000, 200, 3000, 9001, -64, -700, 32000};
        int [] testarrwithAllNegatives = {-1, -2, -3, -4, -5, -6, -7};
        int [] testarrwithInitalNegatives = {-1, -4, -7, 3, 4, 5}
        System.out.println(largestArraySum(testarr).toString());
        System.out.println(largestArraySum(testarrwithAllNegatives).toString());
    }
}
