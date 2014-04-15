/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How to check if a tree is balanced in Java
 * 
 */

package iqLib.treeLib;

public class TreeHeightBalanced
{
   public static boolean isHeightBalanced(TreeNode root)
   {
      return (maxLeafHeight(root) - minLeafHeight(root)) <= 1;
   }
   
   public static int maxLeafHeight(TreeNode root)
   {
      if (root == null)
      {
         return 0;
      }
      
      return Math.max(maxLeafHeight(root.getLeft()), maxLeafHeight(root.getRight())) + 1;
   }
   
   public static int minLeafHeight(TreeNode root)
   {
      if (root == null)
      {
         return 0;
      }
      
      return Math.min(minLeafHeight(root.getLeft()), minLeafHeight(root.getRight())) + 1;
   }
}