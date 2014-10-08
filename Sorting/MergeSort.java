/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How To Implement MergeSort in Java
 */


package iqLib.sortLib;

public class MergeSort
{
   private int[] numbers;
   private int[] tempMergeArray;
   private int length;
   
   public static void main(String[] args)
   {
      int[] numbers = {2, 5, 7, 2, 1, 77, 4, 55, 333, 2, 31, 51};
      
      MergeSort ms = new MergeSort();
      ms.mergeSort(numbers);
      
      for (int i = 0; i < numbers.length; ++i)
      {
         System.out.println(numbers[i]);
      }
   }
   
   public void mergeSort(int[] numbers)
   {
      this.numbers = numbers;
      length = numbers.length;
      tempMergeArray = new int[length];
      mergeSortHelper(0, length - 1);
   }
   
   public void mergeSortHelper(int start, int end)
   {
      if (start < end)
      {
         int mid = (start + end) / 2;
         
         mergeSortHelper(start, mid);
         mergeSortHelper(mid + 1, end);
         
         merge(start, mid, end);
      }
   }
   
   public void merge(int start, int mid, int end)
   {
      System.arraycopy(numbers, start, tempMergeArray, start, end-start+1);

      for (int i = start; i <= end; ++i)
      {
         tempMergeArray[i] = numbers[i];
      }

      int i = start;
      int j = mid + 1;
      int k = start;
      
      while (i <= mid && j <= end)
      {
         if (tempMergeArray[i] <= tempMergeArray[j])
         {
            numbers[k] = tempMergeArray[i];
            ++i;
         }
         else
         {
            numbers[k] = tempMergeArray[j];
            ++j;
         }

         ++k;
      }
      
      while (i <= mid)
      {
         numbers[k] = tempMergeArray[i];
         ++i;
         ++k;
      }
   }
}