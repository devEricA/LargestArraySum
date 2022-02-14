/*
    This file is responsible
    for generating the case of 10 million integers. 
*/


//Imports needed
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
        for(int x = 0; x<10000000; x++)
        {
            //Generating the integers between -9999999 and 9999999
            loader.append(random.nextInt(9999999 +  9999999) - 9999999 + "\n");
        }
        //Closing the file
        loader.flush();
        loader.close();

    }

}
