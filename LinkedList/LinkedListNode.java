/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How to implement a Binary Tree in Java. 
 * 
 */

package IQLib.LinkedListLib;

public class LinkedListNode
{
   private int value;
   private LinkedListNode next;
   private LinkedListNode previous;

   public LinkedListNode(int newValue)
   {
      this(newValue, null, null);
   }

   public LinkedListNode(int newValue, LinkedListNode newNext)
   {
      this(newValue, newNext, null);
   }

   public LinkedListNode(int newValue, LinkedListNode newNext, LinkedListNode newPrevious)
   {
      value = newValue;
      setNext(newNext);
      setPrevious(newPrevious);
   }

   public int getValue()
   {
      return value;
   }

   public void setNext(LinkedListNode newNext)
   {
      next = newNext;

      if (newNext != null && newNext.previous != this)
      {
         newNext.setPrevious(this);
      }
   }

   public void setPrevious(LinkedListNode newPrevious)
   {
      previous = newPrevious;

      if (newPrevious != null && newPrevious.next != this)
      {
         newPrevious.setNext(this);
      }
   }
}