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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode Ans  = null;
        ListNode ptr  = null;
        int cnt = 0;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = null;
            if(cnt % 2 == 0){
                prev = curr;
            }
            else{
                if(Ans == null){
                    Ans = curr;
                    ptr = curr;
                    ptr.next = prev;
                    ptr = prev;
                }
                else{
                    ptr.next = curr;
                    ptr.next.next = prev;
                    ptr = prev;
                }
            }
            curr = next;
            cnt++;
        }

        if(ptr.val != prev.val){
            ptr.next = prev;
        }

        return Ans;
    }
}

public class lc24{
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
        sol.swapPairs(test);
    }
}