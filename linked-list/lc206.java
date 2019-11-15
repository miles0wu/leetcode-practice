class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution{
    public static void showlist(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.printf("%s->",curr.val);
            if(curr.next == null){
                System.out.print("null");
                break;
            }
            curr = curr.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
            iter++;
        }
        return prev;
    }
}

public class lc206{
    public static void main(String[] args){
        ListNode test = null;
        ListNode tmp  = null;

        for(int i = 1; i <= 5; i++){
            if(i == 1){
                test = new ListNode(i);
                tmp = test;
            }
            else{
                tmp.next = new ListNode(i);
                tmp = tmp.next;
            }
        }
        Solution sol = new Solution();
        sol.reverseList(test);
    }
}