/*
 * @Author: Ajk Palikuqi
 * 
 * Given two words find the longest common sequence of characters between them
 */

package iqLib.arrayLib;

public class LongestCommonSequence
{
   public static int findLongestCommonSequence(String firstWord, String secondWord)
   {
      int cols = firstWord.length();
      int rows = secondWord.length();
      int[][] DP = new int[cols][rows];
      int longestSequence = 0;
      
      for (int i = 0; i < cols; ++i)
      {
         for (int j = 0; j < rows; ++j)
         {
            if (firstWord.charAt(i) == firstWord.charAt(j))
            {
               if (i == 0 || j == 0)
               {
                  DP[i][j] = 1;
               }
               else
               {
                  DP[i][j] = DP[i-1][j-1] + 1;
               }
               
               if (DP[i][j] > longestSequence)
               {
                  longestSequence = DP[i][j];
               }
            }
            else
            {
               DP[i][j] = 0;
            }
         }
      }
      
      return longestSequence;
   }
}