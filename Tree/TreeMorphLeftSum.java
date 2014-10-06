/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: How to Morph a Binary Tree From Its Left Subsum.
 * 
 */

package iqLib.treeLib;

import iqLib.treeLib.TreeNode;

public class TreeMorphLeftSum
{
   /*
    * Returns the tree under root morphed in a way so that every node is equal
    * to the sum of the nodes on its left nodes and itself.
    */
   public static TreeNode MorphTree(TreeNode root)
   {
      if (root != null)
      {
         morphTreeHelper(root, 0);
      }
      
      return root;
   }
   
   /*
    * Recursive method to return the tree with nodes morphed to the sum of all 
    * their left children plus previousLeftSum in their value.
    */
   private static int morphTreeHelper(TreeNode root, int previousLeftSum)
   {
      if (root == null)
      {
         return 0;
      }

      int currentLeftValue = morphTreeHelper(root.getLeft(), previousLeftSum) + root.getValue();

      root.setValue(currentLeftValue);

      morphTreeHelper(root.getRight(), currentLeftValue);

      return currentLeftValue;
   }
}
