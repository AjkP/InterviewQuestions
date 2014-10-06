
/*
 * Given an array[0, n-1], each number of the array is positive int. 
 * Your task is adding the operators,"+","*", "(",")" (add, multiply, parenthesis) to maximize the result. 
 * The position in the array is Fixed. For example, "2,1,1,2", you can get (2+1)*(2+1)=9. 
 * Follow up, if the number may be negative , how to solve it ?
 */

package iqLib.stringLib;

public class AddParenthesesAndOperations
{
   public static String getMaxExpression(int[] givenNumbers)
   {
      int totalNumbers = givenNumbers.length;
      int sequenceOfOnes = 0;
      StringBuffer sb = new StringBuffer('1');

      for (int i = 0; i < totalNumbers - 1; ++i)
      {
         if (givenNumbers[i] == 1)
         {
            if (sequenceOfOnes == 0)
            {
               sb.append("*(1");
               ++sequenceOfOnes;
            }
            else if (sequenceOfOnes == 1)
            {
               sb.append("+1");
               ++sequenceOfOnes;
            }
            else if (sequenceOfOnes == 2)
            {
               sb.append("+1)");
               sequenceOfOnes = 0;
            }
         }
         else
         {
            if (sequenceOfOnes == 0)
            {
               sb.append('*').append(Integer.toString(givenNumbers[i]));
            }
            else
            {
               sb.append('+').append(Integer.toString(givenNumbers[i])).append(')');
               sequenceOfOnes=0;
            }
         }
      }
      
      return sb.substring(2);
   }
   
   public static String getMaxExpressionWithNegatives(int[] givenNumbers)
   {
      int totalNumbers = givenNumbers.length;
      int sequenceOfOnes = 0;
      StringBuffer sb = new StringBuffer('1');

      for (int i = 0; i < totalNumbers - 1; ++i)
      {
         if (givenNumbers[i] == 1)
         {
            if (sequenceOfOnes == 0)
            {
               sb.append("*(1");
               ++sequenceOfOnes;
            }
            else if (sequenceOfOnes == 1)
            {
               sb.append("+1");
               ++sequenceOfOnes;
            }
            else if (sequenceOfOnes == 2)
            {
               sb.append("+1)");
               sequenceOfOnes = 0;
            }
         }
         else
         {
            if (sequenceOfOnes == 0)
            {
               sb.append('*').append(Integer.toString(givenNumbers[i]));
            }
            else
            {
               sb.append('+').append(Integer.toString(givenNumbers[i])).append(')');
               sequenceOfOnes=0;
            }
         }
      }
      
      // find number of negative numbers
      // if number even do nothing
      // if number odd then find the smallest 
      
      return sb.substring(2);
   }
}