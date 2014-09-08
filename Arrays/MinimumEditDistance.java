/*
 * Given two words find the minimum number of steps required to convert one to the other.
 * 
 * "One step" is defined as: Adding, removing or replacing a character.
 */

package iqLib.arrayLib;

public class MinimumEditDistance
{
   public static int findMinimumEditDistance(String startWord, String endWord)
   {
      int startLength = startWord.length() + 1;
      int endLength = endWord.length() + 1;
      int[][] DP = new int[startLength][endLength];
      
      //Initialize the starting rows.
      for (int i = 0; i < startLength; ++i)
      {
         DP[i][0] = i;
      }
      
      for (int j = 0; j < endLength; ++j)
      {
         DP[0][j] = j;
      }
      
      for (int i = 1; i < startLength; ++i)
      {
         for (int j = 1; j < endLength; ++j)
         {
            int changed = 1;
            if (startWord.charAt(i) == endWord.charAt(j))
            {
               changed = 0;
            }
            
            DP[i][j] = Math.min(Math.min((DP[i-1][j]+1), (DP[i][j-1]+1)), DP[i-1][j-1]+changed);
         }
      }
      return DP[startLength-1][endLength-1];
   }
}