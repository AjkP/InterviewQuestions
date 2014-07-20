/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How To Convert a Roman Number to an Integer.
 * 
 */

package iqLib.stringLib;

public class RomanToInteger
{
   public static int ConvertRomanToInteger(String romanNumber)
   {
      if ((romanNumber == null) || (romanNumber.length() == 0))
      {
         return -1;
      }

      char[] romanNumerals = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
      int lastSeenNumeralIdx = 0;
      char thisNumeral;
      int retNumber = 0;
      int isOddNumeral = 0;
      
      for (int i = romanNumber.length() - 1; i >= 0; --i)
      {
         for (int j = 0; j < romanNumerals.length; --j)
         {
            thisNumeral = romanNumber.charAt(i);
            if (thisNumeral == romanNumerals[j])
            {
               if ((j % 2) == 1)
               {
                  isOddNumeral = 1;
               }
               else
               {
                  isOddNumeral = 0;
               }

               if (lastSeenNumeralIdx <= j)
               {
                  retNumber += valueOfNumeral(thisNumeral);
               }
               // 
               else if (lastSeenNumeralIdx == j - (1 + isOddNumeral))
               {
                  retNumber -= valueOfNumeral(thisNumeral);
               }
               else
               {
                  return -1;
               }
            }
         }
      }
      
      return retNumber;
   }
   
   public static int valueOfNumeral(char romanNumeral)
   {
      int retNumber = 1;

      if ((romanNumeral % 2) == 1)
      {
         retNumber *= 5;
      }
      
      return retNumber * powerOfPositive(10, romanNumeral/2);
   }
   
   public static int powerOfPositive(int num, int poweredTo)
   {
      int retNumber = 1;

      for (int i = 0; i < poweredTo; ++i)
      {
         retNumber *= num;
      }
      
      return retNumber;
   }
}