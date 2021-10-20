
import java.util.*;
import java.io.*;

public class LargeArraySum {
    
    public static List<Integer> largestArraySum(List<Integer> myArray, int bottomPos, int topPos)
    {
        if(bottomPos <= topPos)
        {
            int middle = bottomPos + (topPos - bottomPos)/2;
            if(myArray.get(middle) < 0)
            {
                myArray.remove(myArray.get(middle));
            }
            largestArraySum(myArray, bottomPos, middle - 1);
            largestArraySum(myArray, middle, topPos);
        }
        return myArray;
    }

    public static void main(String [] args) throws IOException
    {
        List<Integer> testarr = new ArrayList<Integer>();
        Collections.addAll(testarr,1, 100, -50000, 200, 3000, 9001, -64, -700, 32000); 
        List<Integer> testarrwithAllNegatives = new ArrayList<Integer>();
        Collections.addAll(testarrwithAllNegatives, -1, -2, -3, -4, -5, -6, -7);
        List<Integer> testarrwithInitalNegatives = new ArrayList<Integer>();
        Collections.addAll(testarrwithInitalNegatives, -1, -4, -7, 3, 4, 5);
        List<Integer> biggestArray = new ArrayList<Integer>();
        Scanner file = new Scanner(new File("IntegersForHugeArray.txt"));
        for(int x=0; x<biggestArray.size(); x++)
        {
            biggestArray.add(file.nextInt());
        }


        System.out.println(largestArraySum(testarr, 0, testarr.size()-1).toString());
        System.out.println(largestArraySum(testarrwithAllNegatives, 0, testarrwithAllNegatives.size()-1).toString());
        System.out.println(largestArraySum(testarrwithInitalNegatives, 0, testarrwithInitalNegatives.size()-1).toString());
        System.out.println(largestArraySum(biggestArray, 0, biggestArray.size()-1).toString());
    }
}
