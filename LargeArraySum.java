/*
    This file is responsible for conducting the lab
    where we find the array with the largest possible sum. 
*/

//Imports needed
import java.util.*;
import java.io.*;

public class LargeArraySum {

    //Method to get the array with the largest sum
    //taking in an input of an integer array, 
    //an integer to indicate the bottom position and the top position. 
    public static List<Integer> largestArraySum(List<Integer> myArray, int bottomPos, int topPos)
    {
        //Original binary search style method used to search the array.
        //Did not work because removals would alter the list size,
        //resulting in out of bounds errors in the top half of the search.  
        /*
        //If the two positions have not collided, continue with the array. 
        if(bottomPos <= topPos)
        {
            //Taking the middle position between the top and bottom
            int middle = bottomPos + (topPos - bottomPos)/2;

            //The array with the largest sum should not have any negatives.
            //Thus as a result, whenever we find a negative number, we remove it. 
            if(myArray.get(middle) < 0)
            {
                myArray.remove(myArray.get(middle));
            }
            largestArraySum(myArray, bottomPos, middle - 1);
            largestArraySum(myArray, middle + 1, topPos);
        }
        */ 

        //Methods making uses of streams and built in methods

        //Storing the contents of the arraylist into an array
        //This allows us to make use of streams. 
        Integer []myArrayAsIntArr = new Integer[myArray.size()];
        myArrayAsIntArr = myArray.toArray(myArrayAsIntArr);

        //Using the stream to check if all numbers of an arraylist are negative. 
        if(Arrays.stream(myArrayAsIntArr).allMatch(value -> value < 0))
        {
            //Return the array with the smallest negative value
            int smallestNegativeIndex = myArray.indexOf(Collections.max(myArray));
            return myArray.subList(smallestNegativeIndex, smallestNegativeIndex+1);
        }
        //If not all numbers are negative, simply remove the negative numbers. 
        else{
            //Removes all negative numbers 
            myArray.removeIf(value -> value < 0);
        }
        return myArray;
    }

    //Main function to conduct the test
    public static void main(String [] args) throws IOException
    {
        //1st three cases are small arrays of numbers. 
        List<Integer> testarr = new ArrayList<Integer>();
        Collections.addAll(testarr,1, 100, -50000, 200, 3000, 9001, -64, -700, 32000); 
        List<Integer> testarrwithAllNegatives = new ArrayList<Integer>();
        Collections.addAll(testarrwithAllNegatives, -1, -2, -3, -4, -5, -6, -7);
        List<Integer> testarrwithInitalNegatives = new ArrayList<Integer>();
        Collections.addAll(testarrwithInitalNegatives, -1, -4, -7, 3, 4, 5);

        //Last test case is a massive array of 10 million integers. 
        List<Integer> biggestArray = new ArrayList<Integer>();
        Scanner file = new Scanner(new File("IntegersForHugeArray.txt"));
        for(int x=0; x<10000000; x++)
        {
            biggestArray.add(file.nextInt());
        }

        //Closing the file
        file.close();

        //Printing out all of the cases independently. 
        System.out.println(largestArraySum(testarr, 0, testarr.size()-1).toString());
        System.out.println(largestArraySum(testarrwithAllNegatives, 0, testarrwithAllNegatives.size()-1).toString());
        System.out.println(largestArraySum(testarrwithInitalNegatives, 0, testarrwithInitalNegatives.size()-1).toString());
        System.out.println(largestArraySum(biggestArray, 0, biggestArray.size()-1).toString());

        
    }
}
