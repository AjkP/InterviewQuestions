/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: Postorder traversal in Java
 *            Preorder traversal in Java
 *            Inorder traversal in Java
 * 
 */

package Tree

public class PostOrderTraversal
{
    // Postorder Traversal
    public static ArrayList<Integer> getPostOrder(TreeNode root)
    {
        ArrayList<Integer> retVal = new ArrayList<Integer>();

        if (root == null)
        {
            return retVal;
        }

        retVal.addAll(getPostOrder(root.getLeft()));
        retVal.addAll(getPostOrder(root.getRight()));
        retVal.add(root.getValue());

        return retVal; //Space = O(nlog(n)), Time = O(n);
    }

    // Try to solve for Space == O(n); maybe another day.

    public static ArrayList<Integer> getPostOrderBetter(TreeNode root)
    {
        ArrayList<Integer> retVal = new ArrayList<Integer>();
    }

    // Preorder Traversal
    public static ArrayList<Integer> getPreOrder(TreeNode root)
    {
        ArrayList<Integer> retVal = new ArrayList<Integer>();

        if (root == null)
        {
            return retVal;
        }

        retVal.add(root.getValue());
        retVal.addAll(getPreOrder(root.getLeft()));
        retVal.addAll(getPreOrder(root.getRight()));

        return retVal;
    }

    // Inorder Traversal
    public static ArrayList<Integer> getInOrder(TreeNode root)
    {
        ArrayList<Integer> retVal = new ArrayList<Integer>();

        if (root == null)
        {
            return retVal;
        }

        retVal.addAll(getInOrder(root.getLeft()));
        retVal.add(root.getValue());
        retVal.addAll(getInOrder(root.getRight()));

        return retVal;
    }
}