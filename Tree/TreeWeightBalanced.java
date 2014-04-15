/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How to check if a tree is balanced in Java
 * 
 */

package iqLib.treeLib;

public class TreeWeightBalanced
{
   public static boolean isWeightBalanced(TreeNode root)
   {
      if (getBalancedHeight(root) == -1)
      {
         return false;
      }

      return true;
   }

   /*
    * Given a TreeNode root, return the height of the tree under it if it is
    * balanced. Return -1 otherwise.
    */
   public static int getBalancedHeight(TreeNode root)
   {
      if (root == null)
      {
         return 0;
      }

      int leftBalancedHeight = getBalancedHeight(root.getLeft());
      int rightBalancedHeight = getBalancedHeight(root.getLeft());

      if ((Math.abs(leftBalancedHeight - rightBalancedHeight) > 1) || 
            (leftBalancedHeight == -1) || (rightBalancedHeight == -1))
      {
         return -1;
      }
      
      return Math.max(leftBalancedHeight, rightBalancedHeight);
   }
}