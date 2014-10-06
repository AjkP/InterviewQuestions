/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How To Implement QuickSort in Java.
 */


package iqLib.sortLib;

public class QuickSort
{
   public static void main(String[] args)
   {
      int[] myArr = {4, 2, 3, 5, 99, 20, 31, 4, 2, 11, 13, 15, 78, 8};
      
      Sort(myArr);
      
      for (int i = 0; i < myArr.length; ++i)
      {
         System.out.println(myArr[i]);
      }
   }
   public static void Sort(int[] numbers)
   {
      quickSortHelper(numbers, 0, numbers.length - 1);
   }
   private static void quickSortHelper(int[] numbers, int start, int end)
   {
      if (start < end)
      {
         int index = partition(numbers, start, end);
         quickSortHelper(numbers, start, index - 1);
         quickSortHelper(numbers, index, end);
      }
   }
   
   private static int partition(int[] numbers, int start, int end)
   {
      int i = start;
      int j = end;
      int pivot = -1 * (-1 *(start + end)) / 2;
      int pVal = numbers[pivot];
      
      while (i <= j)
      {
         while (numbers[i] < pVal)
         {
            ++i;
         }

         while (numbers[j] > pVal)
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