/* 

=========================


abac
a
db
dbbdbc
*/

package iqLib.stringLib;

public class ReplaceString
{
   public static void main(String[] args)
   {
      String orig = "abac";
      String find = "a";
      String replace = "db";
      System.out.println(replaceString(orig, find, replace));
   }
   public static String replaceString(String orig, String find, String repl)
   {
      StringBuilder sb = new StringBuilder();
      int origLength = orig.length();
      int findLength = find.length();
      boolean isMatch = false;
      
      for (int i = 0, j = 0; i < origLength; ++i)
      {

         while (orig.charAt(i + j) == find.charAt(j))
         {
            if (j == (findLength - 1))
            {
               isMatch = true;
               i += j;
               break;
            }
            else
            {
               ++j;
            }
         }

         
         if (isMatch)
         {
            sb.append(repl);
            isMatch = false;
         }
         else
         {
            sb.append(orig.charAt(i));
         }
         
         j = 0;
      }
      
      return sb.toString();
   }
}