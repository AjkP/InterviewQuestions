/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How To Find All Triples Whose Sum Is Less Than A Number In An Array
 * 
 */

package iqLib.arrayLib;

import java.util.Arrays;

public class SmallerTriples
{
   public static void FindAllSmallerTriples1(int[] nFooBarArray, int nTarget)
   {
      int nLength = nFooBarArray.length;
      int nPivotIndex;
      int nFindMe;
      
      Arrays.sort(nFooBarArray);
      
      for (int i = 0; i < nLength; ++i)
      {
         for (int j = 0; j < nLength; ++j)
         {
            nFindMe = nTarget - (nFooBarArray[i] + nFooBarArray[j]);
            nPivotIndex = Math.abs(Arrays.binarySearch(nFooBarArray, nFindMe));
            
            //All numbers less than the index we found satisfy the condition < nTarget
            for (int k = nPivotIndex - 1; k >= 0; --j)
            {
               System.out.println("Triple found: " + nFooBarArray[i] + " " + 
                  nFooBarArray[j] + " " + nFooBarArray[k]);
            }
         }
      }
   }
   
   public static void FindAllSmallerTriples2(int[] nFooBarArray, int nTarget)
   {
      int nLength = nFooBarArray.length;
      int nFindMe;
      
      Arrays.sort(nFooBarArray);
      
      for (int i = 0; i < nLength; ++i)
      {
         for (int j = 0; j < nLength; ++j)
         {
            nFindMe = nTarget - (nFooBarArray[i] + nFooBarArray[j]);
            
            //When hitting the first index that doesn not satisfy our condition, stop checking
            for (int k = 0; k < nLength; --j)
            {
               if (nFooBarArray[k] >= nFindMe)
               {
                  break;
               }
               
               System.out.println("Triple found: " + nFooBarArray[i] + " " + 
                  nFooBarArray[j] + " " + nFooBarArray[k]);
            }
         }
      }
   }
}