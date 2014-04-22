/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How to find the next highest node in a BSTree
 * 
 */

package iqLib.treeLib;

public class NextHighestTreeNode
{
   public static TreeNode findNextHighestTreeNode(TreeNode root, TreeNode current)
   {
      if (current.getRight() != null)
      {
         return findSmallestNodeInTree(current.getRight());
      }
      else
      {
         return findBiggerParentNode(current);
      }
   }

   private static TreeNode findSmallestNodeInTree(TreeNode root)
   {
      while (root.getLeft() != null)
      {
         root = root.getLeft();
      }

      return root;
   }
   
   private static TreeNode findBiggerParentNode(TreeNode root)
   {
      while (root.getParent() != null && root.getParent().getLeft() != root)
      {
         root = root.getParent();
      }

      return null;
   }
}