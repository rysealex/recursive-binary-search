/*
 * random access binary file recursive binary search
 * This program demonstrates the recursiv
 * binary search method applied to random access binary file.
 * 
 * Project 2 cs111 
 */

// imports 
import java.util.Scanner; 
import java.io.*;

/**
 * Alex Ryse 
 *  
 * I pledge that I have neither given nor received help from anyone other than
 * the instructor or TAs for all program components included here.
 *
 */
public class RandomAccessBinaryFileRecursiveBinarySearch 
{
    public static void main(String[] args) 
            throws FileNotFoundException, IOException 
    {
        // The value to search for
        short searchValue = 0;
        
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a value to search for: "); // prompts user to input search value
        searchValue = keyboard.nextShort();
        
        // creates file object for "BinFileShort"
        File file = new File("BinFileShort");
         
        // open for reading RandomAccessFile file 
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        
        // creates BinaryRecursiveSearch object to call recursive binary search method
        BinaryRecursiveSearch bRS = new BinaryRecursiveSearch();        
        
        // invokes the binary search
        long result = bRS.binarySearch(randomAccessFile, 0, 4999, searchValue, 0);
        
        // checks if result was found or not.
        // if result does not equal sentinel value, result was found.
        if (result != -1) // does not equal sentinel value -1
        {
           // prints the result of the found search value
           result = result / 2; // result is divided by 2 because long is double the size of short
           System.out.println(searchValue + " was found at element " + result);
        }
        else // does equal the sentinel value -1
        {
           // prints that the search value could not be found
           System.out.println(searchValue + " was not found.");
        }
    }
}
