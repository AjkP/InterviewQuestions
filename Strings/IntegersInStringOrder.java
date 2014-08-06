/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How to Print N Integers in String Order
 * 
 */

package iqLib.stringLib;

public class IntegersInStringOrder
{
   public static void PrintIntegersInStringOrder(int N)
   {
      if (N < 1)
      {
         return;
      }
      
      for (int i = 1; i < 10; ++i)
      {
         PrintIntegersInStringOrderInRecursion("" + i, N);
      }
   }
   
   public static void PrintIntegersInStringOrderInRecursion(String currNum, int N)
   {
      if (Integer.parseInt(currNum) > N)
      {
         return;
      }
      
      System.out.println(currNum);
      
      for (int i = 0; i < 10; ++i)
      {
         PrintIntegersInStringOrderInRecursion(currNum + i, N);
      }
   }
}