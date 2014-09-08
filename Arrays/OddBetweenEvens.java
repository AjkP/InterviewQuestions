/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How To Find the Only Item Occurring an Even Number of Times in an Array
 */


package iqLib.arrayLib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import iqLib.sortLib.QuickSort;

public class OddBetweenEvens
{
   public static int FindOddBetwenEvensBySorting(int[] numbers) throws Exception
   {
      int length = numbers.length;

      QuickSort.Sort(numbers);

      int currentNum = numbers[0];
      int currentNumOccurences = 1;
      
      for (int i = 1; i < length; ++i)
      {
         if (numbers[i] != currentNum)
         {
            if (currentNumOccurences % 2 == 1)
            {
               return currentNum;
            }

            currentNum = numbers[i];
         }
      }
      
      throw(new Exception());
   }
   
   public static int FindOddBetweenEvensByHashing(int[] numbers) throws Exception
   {
      
      //Make a HashMap - Integer -> Integer, which points each number to it's count.
      Map<Integer, Integer> numbersCount = new HashMap<Integer, Integer>();
      int length = numbers.length;
      
      for (int i = 0; i < length; ++i)
      {
         int currentCount = 0;
         
         if (numbersCount.containsKey(numbers[i]))
         {
            currentCount += numbersCount.get(numbers[i]);
         }
         
         numbersCount.put(new Integer(numbers[i]), new Integer(currentCount));
      }
      
      Iterator<Entry<Integer, Integer>> it = numbersCount.entrySet().iterator();
      int oddNumbersCount = 0;
      int oddNumber = 0;
      
      while(it.hasNext())
      {
         Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>)it.next();
         
         if (pair.getValue() % 2 == 1)
         {
            oddNumbersCount++;
            oddNumber = pair.getKey();
         }
      }
      
      if (oddNumbersCount == 1)
      {
         return oddNumber;
      }
      
      throw(new Exception());
   }
   
   public static int FindOddBetweenEvensGoodPerformance(int[] numbers)
   {
      int length = numbers.length;
      int result = 0;
      
      for (int i = 0; i < length; ++i)
      {
         result ^= numbers[i];
      }
      
      return result;
   }
}