/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How To Find The Sum Of Numbers In A Rectangular Region In A Matrix
 */

package iqLib.oopLib

import java.util.ArrayList;

public class BookReader
{
   private Screen screen;
   private Buffer readerLineBuffer
   private ElectronicBook book;
   LRUCache<User, Book> cache;
   
   public BookReader(Screen screen)
   {
      this.screen = screen;
   }
   
   /* idea:
    * main entry point will be "read" - it will read a portion of text lines comparative to the screen size.
    * we will keep track of where we are in the book (probably keeping track of lines) and then read a buffer about
    * x-times the size forward and backward, where x is to be determined. 
    * When the user will give directions up or down, we will show the buffered / cached content. When the user's
    * size of remaining data backwards or foreward becomes less than x/2, then we will rebuffer loading more content
    * to the buffer.
    * 
    * In case of a multi-book reader (not specified). We might want to make a cache to preserve the "usual" books data
    * so their load time is comparatively small.
    */

   public class User
   {
      String username;
      String password;
      
      
   }
   
   public class Book
   {
      private static ArrayList<Book> BOOKS;
      private String name;
      private int size;
      private String path;
      
      public Book(String name, int size, String path)
      {
         this.name = name;
         this.size = size;
         this.path = path;
         
         if (BOOKS == null)
         {
            BOOKS = new ArrayList<Book>();
         }
         
         BOOKS.add(this);
      }
   }
   
   public class Screen
   {
      private Dimension screenDimension;
      
      public Screen(Dimension dim)
      {
         screenDimension = dim;
      }
   }
   
   public class Dimension
   {
      private int width;
      private int height;
      
      public Dimension(int width, int height)
      {
         this.width = width;
         this.height = height;
      }
   }
}
