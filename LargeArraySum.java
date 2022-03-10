/*
    This file is responsible for conducting the lab
    where we find the array with the largest possible sum. 
*/

//Imports needed
import java.util.*;
import java.io.*;

public class LargeArraySum {

    /*
        Method to get the array with the largest sum
        taking in an input of an integer array, 
        an integer to indicate the bottom position and the top position. 
    */
    
    public static List<Integer> largestArraySum(List<Integer> myArray)
    {
        /*
        Original binary search style method used to search the array.
        Did not work because removals would alter the list size,
        resulting in out of bounds errors in the top half of the search.

        // If the two positions have not collided, continue with the array. 
        if(bottomPos <= topPos)
        {
            // Taking the middle position between the top and bottom
            int middle = bottomPos + (topPos - bottomPos)/2;

            // The array with the largest sum should not have any negatives.
            // Thus as a result, whenever we find a negative number, we remove it. 
            if(myArray.get(middle) < 0)
            {
                myArray.remove(myArray.get(middle));
            }
            // Remaking calls to the method for the other halves
            // This method used to take in two additional integer parameters bottonPos and topPos
            largestArraySum(myArray, bottomPos, middle - 1);
            largestArraySum(myArray, middle + 1, topPos);
        }
        */ 

        // Methods making uses of streams and built in methods

        // Storing the contents of the arraylist into an array
        // This allows us to make use of streams. 
        Integer []myArrayAsIntArr = new Integer[myArray.size()];
        myArrayAsIntArr = myArray.toArray(myArrayAsIntArr);

        // Using the stream to check if all numbers of an arraylist are negative. 
        if(Arrays.stream(myArrayAsIntArr).allMatch(value -> value < 0))
        {
            // Return the array with the smallest negative value
            int smallestNegativeIndex = myArray.indexOf(Collections.max(myArray));
            return myArray.subList(smallestNegativeIndex, smallestNegativeIndex+1);
        }
        // If not all numbers are negative, simply remove the negative numbers. 
        else{
            // Removes all negative numbers 
            myArray.removeIf(value -> value < 0);
        }
        // Returning the list
        return myArray;
    }

    // Linear version of the algorithm
    public static List<Integer> linearLargestArraySum(List<Integer> myArray){

        // "Smallest" negative number for cases with all negative integers
        int smallestNegative = Integer.MIN_VALUE;

        // Flag for finding a positive
        boolean foundPositive = false;

        // For each integer in the array
        for(int x = 0; x<myArray.size(); x++)
        {
            // If I found a positive, set the foundPositive flag to true and restart the loop. 
            if(myArray.get(x) > 0 && !foundPositive)
            {
                foundPositive = true;
                x = 0;
            }
            else{
                // If a positive is found, remove the negative number
                if(foundPositive && myArray.get(x) < 0){
                    myArray.remove(x);
                }
                // Else, compare the current negative with the stored "smallest" negative
                // Set the current negative to the "smallest" negative if it's "smaller".
                else{
                    if(myArray.get(x) > smallestNegative){
                        smallestNegative = myArray.get(x);
                    }

                }
            }
        }

        // Returning the list if there's positive integers, the list with the "smallest" negative value if there's no positive integers
        if(foundPositive)
            return myArray;
        else    
            return myArray.subList(myArray.indexOf(smallestNegative), myArray.indexOf(smallestNegative)+1);

    }

    // Method to execute both algoriths
    public static void compareAlgs(List<Integer> myArray)
    {
        // Displaying the contents of the array prior to modification
        System.out.println("Current contents of the Array");
        System.out.println(myArray.toString());
        System.out.println();

        // Logging the start time of the stream method
        long streamAlgorithmTimeStart = System.currentTimeMillis();
        // Calling the stream method
        List<Integer> streamedArray = largestArraySum(myArray);
        // Logging the end time of the stream method
        long streamAlgorithmTimeEnd = System.currentTimeMillis();


        // Logging the start time of the linear method method
        long linearAlgorithmTimeStart = System.currentTimeMillis();
        // Calling the linear method
        List<Integer> linearedArray = linearLargestArraySum(myArray);
        // Logging the end time of the linear method
        long linearAlgorithmTimeEnd = System.currentTimeMillis();


        // Printing the result of the streamed array.
        System.out.println("Result of the streamed array");
        System.out.println(streamedArray.toString());

        // Comparing the results of both arrays and printing a message based on the outcome.
        if(streamedArray.equals(linearedArray)){
            System.out.println("Streamed result is identical to the linear result for this case.");
            System.out.println();
        }
        else{
            System.out.println("WARNING: Streamed result is NOT identical to the linear result!\nPlease double check both algorithms.");
            System.out.println();
        }

        // Printing the total execution time of the stream method
        System.out.println("Stream algorithm took " + (streamAlgorithmTimeEnd - streamAlgorithmTimeStart) + " ms");
        // Printing the total execution time of the linear method
         System.out.println("Linear algorithm took " + (linearAlgorithmTimeEnd - linearAlgorithmTimeStart) + " ms");
    }

    // Main function to conduct the test
    public static void main(String [] args) throws IOException
    {
        // 1st three test cases are small arrays of numbers. 
        List<Integer> testarr = new ArrayList<Integer>();
        Collections.addAll(testarr,1, 100, -50000, 200, 3000, 9001, -64, -700, 32000); 
        List<Integer> testarrwithAllNegatives = new ArrayList<Integer>();
        Collections.addAll(testarrwithAllNegatives, -1, -2, -3, -4, -5, -6, -7);
        List<Integer> testarrwithInitalNegatives = new ArrayList<Integer>();
        Collections.addAll(testarrwithInitalNegatives, -1, -4, -7, 3, 4, 5);

        // Last test case is a massive array of 10 million integers. 
        List<Integer> biggestArray = new ArrayList<Integer>();
        Scanner file = new Scanner(new File("IntegersForHugeArray.txt"));
        for(int x=0; x<10000000; x++)
        {
            biggestArray.add(file.nextInt());
        }

        // Closing the file used to read in the biggest array.
        file.close();

        // Running all of the cases independently. 
        compareAlgs(testarr);
        compareAlgs(testarrwithAllNegatives);
        compareAlgs(testarrwithInitalNegatives);
        compareAlgs(biggestArray);

        
    }
}
