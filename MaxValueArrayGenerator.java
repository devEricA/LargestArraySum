
import java.util.*;
import java.math.*;
import java.io.*;

public class MaxValueArrayGenerator {
    
    public static void main (String [] args) throws IOException{

        //Generating the file where we will store the integers
        File fileForArrayOfMaxSize = new File("IntegersForHugeArray.txt");
        fileForArrayOfMaxSize.createNewFile();
        
        //Loading the file with randomly generated integers
        FileWriter loader = new FileWriter(fileForArrayOfMaxSize);

        Random random = new Random();
        loader.write("");
        for(int x = 0; x<Integer.MAX_VALUE; x++)
        {
            //Formula for generating integers is (max - min) + min;
            //In this case our range is -9999999 to 9999999 
            loader.append(random.nextInt(9999999 +  9999999) - 9999999 + "\n");
        }
        //Closing the file
        loader.flush();
        loader.close();



    }

}
