/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How To Implement QuickSort in Java.
 */


package iqLib.sortLib;

public class QuickSort
{
   public static void Sort(int[] numbers)
   {
      quickSortHelper(numbers, 0, numbers.length);
   }
   private static void quickSortHelper(int[] numbers, int start, int end)
   {
      int index = partition(numbers, start, end);

      quickSortHelper(numbers, start, index);
      quickSortHelper(numbers, index + 1, end);
   }
   
   private static int partition(int[] numbers, int start, int end)
   {
      
      int i = start;
      int j = end - 1;
      int pivot = (start + end) / 2;
      
      while (i <= j)
      {
         while (numbers[i] < pivot)
         {
            ++i;
         }

         while (numbers[j] > pivot)
         {
            --j;
         }

         if (i <= j)
         {
            swap(numbers, i, j);
            ++i;
            --j;
         }
      }
      
      return i;
   }
   
   private static void swap(int[] numbers, int i, int j)
   {
      int temp = numbers[i];
      numbers[i] = numbers[j];
      numbers[j] = temp;
   }
}