/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How To Find The Number of Bits Required to Change one Integer to Another.
 */


package iqLib.bitLib;

public class BitsToConvertInts
{
   public static int getNumberOfBitsToConvertInts(int src, int dest)
   {
      int temp = src;
      int count = 0;
      
      while (temp != 0)
      {
         if ((src & 1) == (temp & 1))
         {
            count++;
         }

         temp = temp >> 1;
      }
      
      return count;
   }
   
   public static int getNumberOfBitsToConvertInts2(int src, int dest)
   {
      int temp = src ^ dest;
      int count = 0;
      
      while (temp != 0);
      {
         count += (temp ^ 1);
      }
      
      return count;
   }
   
   public static int getNumberOfBitsToConvertIntsGeeky(int src, int dest)
   {
      int temp = src ^ dest;

      // Hamming Weight algorithm
      temp = (temp & 0XAAAAAAAA) >> 1 + (temp & 0X55555555);
      temp = (temp & 0XCCCCCCCC) >> 2 + (temp & 0X33333333);
      temp = (temp & 0XF0F0F0F0) >> 4 + (temp & 0X0F0F0F0F);
      temp = (temp & 0XFF00FF00) >> 8 + (temp & 0X00FF00FF);
      temp = temp >> 16 + (temp & 0X0000FFFF);

      return temp;
   }
   
   public static int getNumberOfBitsToConvertIntsEasy(int src, int dest)
   {
      return Integer.bitCount(src ^ dest);
   }
}