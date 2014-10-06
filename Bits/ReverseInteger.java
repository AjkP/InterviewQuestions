/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How To Reverse an Integer Number
 * i.e. 135 will return 531. -12 will return -21.
 */


package iqLib.bitLib;

public class ReverseInteger
{
   public static void main (String[] args)
   {
      System.out.println(getReversed(135));
      System.out.println(getReversed(-12));
      System.out.println(getReversed(0));
   }
   public static int getReversed(int number)
   {
      int reversed = 0;

      while (number != 0)
      {
         reversed *= 10;
         reversed += (number % 10);
         number /= 10;
      }

      if (number < 0)
      {
         reversed *= -1;
      }

      return reversed;
   }
}