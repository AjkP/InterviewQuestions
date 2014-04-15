/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How to implement a Binary Tree in Java. 
 * 
 */

package iqLib.treeLib;

public class TreeNode
{
   private int value;
   private TreeNode left;
   private TreeNode right;
   private TreeNode parent;
   private int size;

   public TreeNode(int newValue)
   {
      value = newValue;
      size = 1;
   }

   public int getValue()
   {
      return value;
   }

   public int getHeight()
   {
      int leftHeight = 0;
      int rightHeight = 0;

      if (left != null)
      {
         leftHeight = left.getHeight();
      }

      if (right != null)
      {
         rightHeight = left.getHeight();
      }

      return Math.max(leftHeight, rightHeight) + 1;
   }

   public int getSize()
   {
      return size;
   }
   
   public TreeNode getLeft()
   {
      return left;
   }

   public void setLeft(TreeNode newLeft)
   {
      left = newLeft;

      if (newLeft != null)
      {
         newLeft.parent = this;
      }
   }
   
   public TreeNode getRight()
   {
      return right;
   }

   public void setRight(TreeNode newRight)
   {
      right = newRight;

      if (newRight != null)
      {
         newRight.parent = this;
      }
   }
}