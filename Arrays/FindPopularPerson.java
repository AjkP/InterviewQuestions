/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How to find the most popular person in a group of people.
 * 
 * Given a 2D array of people who follow one another, determine who is popular (followed by everyone, follows no one).
 * Example: If A[i][j] is true, then person i follows person j.
 */

package iqLib.arrayLib;

import java.util.ArrayList;

public class FindPopularPerson
{
   public static ArrayList<Integer> FindPopularPeople(int[][] followersMatrix)
   {
      ArrayList<Integer> popularPeople = new ArrayList<Integer>();
      int numberOfPeople = followersMatrix.length;
      
      for (int i = 0; i < numberOfPeople - 1; ++i)
      {
         boolean followsSomeone = false;
         boolean isPopularPerson = true;
         
         for (int j = 0; j < numberOfPeople; ++j)
         {
            if (followersMatrix[i][j] == 1)
            {
               followsSomeone = true;
               break;
            }
         }
         
         if (!followsSomeone)
         {
            for (int j = 0; j < numberOfPeople; ++j)
            {
               if (followersMatrix[j][i] == 0)
               {
                  isPopularPerson = false;
               }
            }
         }
         
         if (isPopularPerson)
         {
            popularPeople.add(i);
         }
      }
      
      return popularPeople;
   }
   
   public static int[][] ComputeMatrixSubSums(int[][] nMatrix)
   {
      int nRows = nMatrix.length;
      int nColumns = nMatrix[0].length;
      //Shows the computed sums of the rectangle from point 0,0 to here inclusive.
      int nComputedSums[][] = new int[nRows][nColumns];

      //Compute sums for the firt row and first column
      nComputedSums[0][0] = nMatrix[0][0];
      
      for (int j = 1; j < nColumns; ++j)
      {
         nComputedSums[0][j] = nComputedSums[0][j-1] + nMatrix[0][j];
      }
      
      for (int i = 1; i < nRows; ++i)
      {
         nComputedSums[i][0] = nComputedSums[i-1][0] +nMatrix[i][0];
      }
      //Compute sums for the rest
      for (int i = 1; i <  nRows; ++i)
      {
         for (int j = 1; j < nColumns; ++j)
         {
            nComputedSums[i][j] = nComputedSums[i][j-1] + nComputedSums[i-1][j] -
               nComputedSums[i-1][j-1] + nMatrix[i][j];
         }
      }

      return nComputedSums;
   }
   
   public static int FindMatrixSubSumByCache(int[][] nMatrix, Point nTopLeft, Point nBottomRight, int[][] computedSums)
   {
      int nSum = 0;

      for (int i = nTopLeft.x; i < nBottomRight.x; ++i)
      {
         for (int j = nTopLeft.y; j < nBottomRight.y; ++j)
         {
            nSum += nMatrix[i][j];
         }
      }

      return nSum;
   }
}