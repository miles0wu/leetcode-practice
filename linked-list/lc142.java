class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution{
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode slow2 = head;
                while(slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }

        return null;
    }
}

public class lc142{
    public static void main(String[] args){
        ListNode test = null;

        test                     = new ListNode(1);
        test.next                = new ListNode(2);
        test.next.next           = new ListNode(3);
        test.next.next.next      = new ListNode(4);
        test.next.next.next.next = test.next;

        Solution sol = new Solution();
        ListNode Ans = sol.detectCycle(test);
        if(Ans != null){
            System.out.println(Ans.val);
        }
    }
}