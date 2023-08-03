/*
 The binarySearch method performs a binary search
 on a random access binary file of short values. 
 randomAccessFile file pointer to search.
 first - The first element in the search range.
 last - The last element in the search range.
 value - The value to search for.
 Return The subscript of the value if found, otherwise -1.
 */

// imports 
import java.io.*;

/**
 * Alex Ryse
 */
public class BinaryRecursiveSearch 
{
    public static long binarySearch(
            RandomAccessFile randomAccessFile, long first, long last,
            short value, int callNumber) throws IOException 
    {
        // Calculates the middle position of area being searched
        if (last >= first) // if last is greater than or equal to first
        {
           callNumber++; // increments callNumber each time method is called
           
           // prints number of times called
           System.out.println("Call binarySearch. Times called " + callNumber);
           
           long positionValue = (first + (last - first) / 2); // finds middle of search

           // converts long to a short
           positionValue = (2 * positionValue); // short is two bytes long

           // seeks the current position
           randomAccessFile.seek(positionValue);
        
           // reads the short at position
           short positionShort = randomAccessFile.readShort();

           // checks if callNumber is greater than or equal to the theoretical max log        
           if (callNumber > 12) // theoretical max log is 12
           {
              return -1;
           }
        
           // searches for the value.
           // calls either left half or right half of binarySearch.
           // checks if position is equal to search value.
           if (positionShort == value) // base case
           {
              return positionValue;
           }
           
           // checks if position is greater than search value.
           // can only be present in left half of binarySearch.
           else if (positionShort > value) // base case
           {
              return binarySearch(randomAccessFile, first, (positionValue - 1) / 2, value, callNumber);
           }
           
           // else the position can only be present in right half of binarySearch.
           else
           {
              return binarySearch(randomAccessFile, (positionValue + 1) / 2, last, value, callNumber);
           }
        }
        return -1; // returns -1 if search value not present
        
    }

}