/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How To Find The First Non-Repeated Character In A String
 * 
 */

package iqLib.stringLib;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatedChar
{
   public final static int MAX_CHAR_NUMBER = 256;

   public static int FindFirstNonRepeatedChar1(String fooBar)
   {
      char[] tempCharArray = fooBar.toCharArray();
      Arrays.sort(tempCharArray);
      
      if (fooBar.length() == 1)
      {
         return 0;
      }

      for (int i = 0; i < fooBar.length(); ++i)
      {
         int idx = Arrays.binarySearch(tempCharArray, fooBar.charAt(i));
         if ((idx == tempCharArray.length - 1) || tempCharArray[idx] != tempCharArray[idx+1])
         {
            return idx;
         }
      }
      
      // Non-dupe char not found
      return -1;
   }
   
   public static int FindFirstNonRepeatedChar2(String fooBar)
   {
      int[] cachedChars = new int[MAX_CHAR_NUMBER];
      
      // Initialize the array with 0s
      for (int i = 0; i < MAX_CHAR_NUMBER; ++i)
      {
         cachedChars[i] = 0;
      }
      
      int length = fooBar.length();
      
      // Fill the cache
      for (int i = 0; i < length; ++i)
      {
         cachedChars[fooBar.charAt(i)]++;
      }

      // Check for non dupes
      for (int i = 0; i < length; ++i)
      {
         if (cachedChars[fooBar.charAt(i)] == 1)
         {
            return i;
         }
      }
      
      // Non-dupe char not found
      return -1;
   }
   
   public static int FindFirstNonRepeatedChar3(String fooBar)
   {
      Map<Character, Boolean> cacheChars = new LinkedHashMap<Character, Boolean>();
      
      int length = fooBar.length();
      
      for (int i = 0; i < length; ++i)
      {
         Character currKey = new Character(fooBar.charAt(i));
         cacheChars.put(currKey, !cacheChars.containsKey(currKey));
      }
      
      for (Map.Entry<Character, Boolean> entry : cacheChars.entrySet())
      {
         if (entry.getValue())
         {
            return fooBar.indexOf(entry.getKey());
         }
      }
      
      return -1;
   }
}