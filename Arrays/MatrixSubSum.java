/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How To Find The Sum Of Numbers In A Rectangular Region In A Matrix
 */

package iqLib.arrayLib;

import java.awt.Point;

public class MatrixSubSum
{
   public static int FindMatrixSubSumStandard(int[][] nMatrix, Point nTopLeft, Point nBottomRight)
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