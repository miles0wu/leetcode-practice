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

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null || head.next == null){
            return head;
        }

        ListNode ans  = null;
        ListNode ptr  = null;
        ListNode prev = null;
        ListNode curr = head;
        int cnt = 0;
        while(curr != null){
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
            if(++cnt == k){
                cnt = 0;
                if(ans == null){
                    ptr = prev;
                    ans = prev;
                }
                else{
                    while(ptr.next != null){
                        ptr = ptr.next;
                    }
                    ptr.next = prev;
                }
                prev = null;
            }
        }

        if(prev != null){
            while(prev != null){
                ListNode nextTmp = prev.next;
                prev.next = curr;
                curr = prev;
                prev = nextTmp;
            }

            if(ptr != null){
                while(ptr.next != null){
                    ptr = ptr.next;
                }
                ptr.next = curr;
            }
            else{
                ans = curr;
            }
        }
        return ans;
    }
}

public class lc25{
    public static void main(String[] args){
        ListNode test = null;

        test                          = new ListNode(1);
        test.next                     = new ListNode(2);
        test.next.next                = new ListNode(3);
        test.next.next.next           = new ListNode(4);
        test.next.next.next.next      = new ListNode(5);
        test.next.next.next.next.next = null;

        Solution sol = new Solution();
        ListNode Ans = sol.reverseKGroup(test, 3);
        Solution.showlist(Ans);
        System.out.println("");
    }
}