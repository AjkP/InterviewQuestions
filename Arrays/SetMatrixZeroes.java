
/*
 * Given a mxn matrix, if an element is 0, set it's entire row and col to 0.
 * 
 * Follow up: Do this in place
 */

package iqLib.arrayLib;

public class SetMatrixZeroes
{
   public static void MorphMatrixWithZeroes(int[][] matrix) throws Exception
   {
      if (matrix == null || (matrix.length == 0) || (matrix[0].length == 0))
      {
         throw(new Exception());
      }
      
      int cols = matrix.length;
      int rows = matrix[0].length;
      boolean[] zeroCols = new boolean[cols];
      boolean[] zeroRows = new boolean[rows];
      
      for (int i = 0; i < cols; ++i)
      {
         for (int j = 0; j < rows; ++j)
         {
            if(matrix[i][j] == 0)
            {
               zeroCols[i] = true;
               zeroRows[j] = true;
            }
         }
      }
      
      for (int i = 0; i < cols; ++i)
      {
         for (int j = 0; j < rows; ++j)
         {
            if (zeroCols[i] || zeroCols[j])
            {
               matrix[i][j] = 0;
            }
         }
      }
   }
   
   public static void MorphMatrixWithZeroesInPlace(int[][] matrix) throws Exception
   {
      if (matrix == null || (matrix.length == 0) || matrix[0].length == 0)
      {
         throw(new Exception());
      }
      
      int cols = matrix.length;
      int rows = matrix[0].length;
      
      boolean firstColZero = false;
      boolean firstRowZero = false;
      
      // Check if we need to make first column zero
      for (int i = 0; i < cols; ++i)
      {
         if (matrix[i][0] == 0)
         {
            firstColZero = true;
            break;
         }
      }
      
   // Check if we need to make first row zero
      for (int j = 0; j < rows; ++j)
      {
         if (matrix[0][j] == 0)
         {
            firstRowZero = true;
            break;
         }
      }
      
      // Use first row and column to store info about others.
      for (int i = 1; i < cols; ++i)
      {
         for (int j = 1; j < rows; ++j)
         {
            if (matrix[i][j] == 0)
            {
               matrix[i][0] = 0;
               matrix[0][j] = 0;
            }
         }
      }
      
      for (int i = 0; i < cols; ++i)
      {
         for (int j = 0; j < rows; ++j)
         {
            if ((matrix[i][0] == 0) || (matrix[0][j] == 0))
            {
               matrix[i][j] = 0;
            }
         }
      }
      
      // Restore first column and row to zero if needed
      if (firstRowZero)
      {
         for (int i = 0; i < cols; ++i)
         {
            matrix[i][0] = 0;
         }
      }
      
      if (firstColZero)
      {
         for (int j = 0; j < rows; ++j)
         {
            matrix[0][j] = 0;
         }
      }
      
   }
}