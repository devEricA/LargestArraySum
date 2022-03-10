# LargestArraySum
A lab that is about finding a sub array that contains the largest possible sum within an array of integers.

# Problem
Given an array of integers, find and return a sub array that contains the largest possible sum.

# Test Cases
1. [1, 100, -50000, 200, 3000, 9001, -64, -700, 32000]
2. [-1, -2, -3, -4, -5, -6, -7]
3. [-1, -4, -7, 3, 4, 5]
4. An array of 10 million randomly generated integers 

# Expected Output for Test Cases
1. [1, 100, 200, 3000, 9001, 32000]
2. [-1]
3. [3, 4, 5]

# Explanation Behind Approach
A key componet behind this lab is that all negative numbers within a integer list will drag down the sum. Thus, an array with the largest possible sum should not have any negative numbers. In cases where the list contains only negative numbers, we simply keep the "smallest" negative integer. 

This is a lab where I could draw up linear search and be done with it. However, the efficiency of that algorithm falls off as the cases get bigger. Thus, to further test myself, I included the case of 10 million random integers. 

The first idea was to use a binary search style method to go through the list and remove the negatives (Lines 17-36 of LargeArraySum.java). That failed because of the fact that whenever the search traverses through the upper half, the original length of the list is used, even if the lower half traversal removes numbers. Attempts to subtract 1 from the list length whenever a removal was made failed because the call stack already saved the original length, making alterations to that length impossible. 

A scour through the internet revealed the use of [Java streams](https://www.geeksforgeeks.org/stream-in-java/). Streams were chosen because of the fact that they are built in, and thus, had plenty of time to be optimized by many developers.

# Results
Suprisingly, the linear method out performed the stream method for the 10 million case. When I compiled the program, the following output was noted:
```
Stream algorithm took 189 ms
Linear algorithm took 31 ms
```
This is likely due to the fact that I didn't take a closer look at the runtimes of the streams utilized within the streaming algorithm. Thus, it's time for me to return to the drawing board. 

_Results may vary to some slight degree on your end due to computer specifications_

# Try it Yourself
To see the results of this lab, simply compile and run LargeArraySum.java using an IDE of your choice. 

Optionally, you can compile MaxValueArrayGenerator.java in order to generate a new case of 10 million integers.

| :warning: NOTE |
|:-------------------------|
| If you see a WARNING message in the output after creating the new case, open an issue and attach your version of the IntegersForHugeArray.txt file so I can address it!| 

# Additional Notes
Compiled in a Linux Mint environment via CLI commands <code>javac LargeArraySum.java</code> and <code>java LargeArraySum</code>. 

Developed in Visual Studio Code using openjdk 17.0.2 2022-01-18
