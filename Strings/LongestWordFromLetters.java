/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How to Find the Longest Words Containing Given Characters in a List
 * 
 */


//Find the longest words in a given list of words that can be constructed from a given list of letters. 
//Your solution should take as its first argument the name of a plain text file that contains one word per line. 
//The remaining arguments define the list of legal letters. A letter may not appear in any single word more times than it appears in the list of letters (e.g., the input letters ‘a a b c k’ can make ‘back’ and ‘cab’ but not ‘abba’). 
//
//Here's an example of how it should work: 
//
//prompt> word-maker WORD.LST w g d a s x z c y t e i o b 
//['azotised', 'bawdiest', 'dystocia', 'geotaxis', 'iceboats', 'oxidates', 'oxyacids', 'sweatbox', 'tideways'] 




package iqLib.stringLib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestWordFromLetters
{
   private static double MAX_ALLOWED_FILESIZE_IN_MEMORY = 10*1024*1024; //10 MB

   public static void main(String[] args) throws FileNotFoundException, IOException
   {
      if (args.length < 1)
      {
         System.out.println("You need at least 1 argument to run this script!");
         return;
      }
      
      String filename = args[0];
      int charArgIndex = 1;
      Map<Character, Integer> possibleChars = new HashMap<Character, Integer>();
      
      while (args.length > charArgIndex)
      {
         if (args[charArgIndex].length() != 1)
         {
            System.out.println("All arguments following the filename need to be single characters!");
            return;
         }
         
         char currentChar = args[charArgIndex].charAt(0);
         int charOccurenceTimes = 1;
         
         if (possibleChars.containsKey(currentChar))
         {
            charOccurenceTimes = possibleChars.get(currentChar) + 1;
         }

         possibleChars.put(currentChar, charOccurenceTimes);
      }
      
      File wordsFile = new File(filename);
      double fileLengthInBytes = wordsFile.length();
      
      if (fileLengthInBytes < MAX_ALLOWED_FILESIZE_IN_MEMORY)
      {
         printLongestWordsFromMemory(wordsFile, possibleChars);
      }
      else
      {
         int longestWordSize = findLongestWordSize(wordsFile);
         printWordsFromStream(wordsFile, longestWordSize, possibleChars);
      }
   }
      
   private static void printLongestWordsFromMemory(File wordsFile, 
      Map<Character, Integer> possibleChars) throws FileNotFoundException, IOException
   {
      int longestWordLength = 0;
      ArrayList<String> longestWords = new ArrayList<String>();
      InputStreamReader sReader = new InputStreamReader(new FileInputStream(wordsFile));
      BufferedReader buffReader = new BufferedReader(sReader);
      String currentLine;

      while((currentLine = buffReader.readLine()) != null)
      {
         int lineLength = currentLine.length();

         if (lineLength >= longestWordLength)
         {
            if (lineLength > longestWordLength)
            {
               longestWords.clear();
               longestWordLength = lineLength;
            }

            longestWords.add(currentLine);
         }
      }

      for (String word : longestWords)
      {
         if(canWordBeConstructedFromChars(word, possibleChars))
         {
            System.out.println(word);
         }
      }
   }

   private static int findLongestWordSize(File wordsFile) throws FileNotFoundException, IOException
   {
      int longestWordLength = 0;
      InputStreamReader sReader = new InputStreamReader(new FileInputStream(wordsFile));
      BufferedReader buffReader = new BufferedReader(sReader);
      String currentLine;

      while((currentLine = buffReader.readLine()) != null)
      {
         int lineLength = currentLine.length();

         if (currentLine.length() > longestWordLength)
         {
            longestWordLength = lineLength;
         }
      }

      return longestWordLength;
   }

   private static void printWordsFromStream(File wordsFile, int wordsLength, 
      Map<Character, Integer> possibleChars) throws FileNotFoundException, IOException
   {
      InputStreamReader sReader = new InputStreamReader(new FileInputStream(wordsFile));
      BufferedReader buffReader = new BufferedReader(sReader);
      String currentLine;
      
      while((currentLine = buffReader.readLine()) != null)
      {
         if (currentLine.length() == wordsLength)
         {
            if(canWordBeConstructedFromChars(currentLine, possibleChars))
            {
               System.out.println(currentLine);
            }
         }
      }
   }

   private static boolean canWordBeConstructedFromChars(String word, Map<Character, Integer> possibleChars)
   {
      HashMap<Character, Integer> charsInWord = new HashMap<Character, Integer>();

      for (int i = word.length() - 1; i >= 0; --i)
      {
         char currentChar = word.charAt(0);
         int charOccurenceTimes = 1;

         if (charsInWord.containsKey(currentChar))
         {
            charOccurenceTimes = charsInWord.get(currentChar) + 1;
         }
         
         if (possibleChars.get(currentChar) > charOccurenceTimes)
         {
            return false;
         }

         charsInWord.put(currentChar, charOccurenceTimes);
      }

      return true;
   }
}