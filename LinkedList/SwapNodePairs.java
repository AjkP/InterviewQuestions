/*
 * @Author: Ajk Palikuqi
 * 
 * @Question: Given a LinkedList swap its adjacent nodes. 
 * 
 */

package IQLib.LinkedListLib;

public class SwapNodePairs
{
    // Uses constant space
    public static void SwapAdjacentNodes(LinkedListNode head)
    {
        if (head == null || head.getNext() == null)
        {
            return head;
        }

        LinkedListNode newHead = head.getNext();

        while (head != null && head.getNext() != null)
        {
            LinkedListNode currNext = head.getNext();

            currNext.setPrevious(head.getPrevious());
            head.setPrevious(currNext);
            head.setNext(currNext.getNext());
            currNext.setNext(head);

            head = head.getNext();
        }

        return newHead;
    }
}