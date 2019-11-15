class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution{
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}

public class lc141{
    public static void main(String[] args){
        ListNode test = null;
        ListNode tmp  = null;

        test                     = new ListNode(1);
        test.next                = new ListNode(2);
        test.next.next           = new ListNode(3);
        test.next.next.next      = new ListNode(4);
        test.next.next.next.next = test.next;

        Solution sol = new Solution();
        Boolean Ans = sol.hasCycle(test);
    }
}