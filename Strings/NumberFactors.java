/* Write a program that takes an integer and prints out all ways to multiply smaller 
 * integers that equal the original number, without repeating sets of factors. 
 * In other words, if your output contains 4 * 3, you should not print out 3 * 4 again 
 * as that would be a repeating set. Note that this is not asking for prime factorization only.
 * Also, you can assume that the input integers are reasonable in size; correctness is more important than efficiency.

   i.e.
   12 * 1
   6 * 2
   4 * 3
   3 * 2 * 2
   
   PrintFactors(32)
   
   32 * 1
   16 * 2
   8 * 4
   8 * 2 * 2
   4 * 4 * 2
   4 * 2 * 2 * 2
   2 * 2 * 2 * 2 * 2
*/

package iqLib.stringLib;

public class NumberFactors
{
   public static void PrintFactors(int number)
   {
      printFactorsHelper("", number, number);
   }
   
   private static void printFactorsHelper(String currExpression, int dividend, int previousFactor)
   {
      for (int factor = dividend - 1; factor >= 2; --factor)
      {
         if (dividend % factor == 0 && factor <= previousFactor)
         {
            // found 2 factors
            int nextFactor = dividend / factor;
            
            // try printing only if secondfactor is smaller (i.e. descending order)
            if (nextFactor <= factor)
            {
               if (nextFactor <= previousFactor)
               {
                  System.out.println(currExpression + factor + " * " + nextFactor);
               }
            }
            
            printFactorsHelper(currExpression + factor + " * ", nextFactor, factor);
         }
      }
   }
}