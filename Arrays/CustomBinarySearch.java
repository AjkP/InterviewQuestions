// Given a sorted array with potential duplicates (e.g. [0, 1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 10, 11, 12, 13, 14].
// Return begin & end indices for a number n. (6, 8) is the indices if n=6 in the example. Return (-1, -1) if not found.

// [1, 1, 1, 1 ,1 ,1 ,1, 1, 1,] 1 
// binary search find lowest index of n - log(n)
// binary search find largest index of n - log(n)

package iqLib.arrayLib;

public class CustomBinarySearch
{ 
  public static void main(String[] args)
  {
    int[] numbers = {0, 1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    int findMe = 6;
    
    int[] retVal = getStartEndIndices(numbers, findMe);
    
    System.out.println("" + retVal[0]);
    System.out.println("" + retVal[1]);
  }
  
  public enum BinarySearchIndex
  {
    START,
    END;
  }
  public static int[] getStartEndIndices(int[] numbers, int findMe)
  {
    int[] retVal = new int[2];
    retVal[0] = binarySearchStartEnd(numbers, findMe, BinarySearchIndex.START);
    retVal[1] = binarySearchStartEnd( numbers, findMe, BinarySearchIndex.END);
      
    return retVal;
  }
  
  private static int binarySearchStartEnd(int[] numbers, int findMe, BinarySearchIndex findStart)
  {
    int edgeIndex = Integer.MIN_VALUE;
    int low = 0;
    int high = numbers.length -1;
    int middle;
    
    while (high >= low)
    {
      middle = (high + low) / 2;
      
      if (numbers[middle] == findMe)
      {
        if (findStart == BinarySearchIndex.START)
        {
          high = middle - 1;
        }
        else if (findStart == BinarySearchIndex.END)
        {
          low = middle + 1;
        }
        
        edgeIndex = middle;
      }
      else if (numbers[middle] < findMe)
      {
        low = middle + 1;
      }
      else
      {
        high = middle - 1;
      }
    }
    
    if (edgeIndex != Integer.MIN_VALUE)
    {
      return edgeIndex;
    }

    return -1;
    // Complexity log(n)    
  }
}