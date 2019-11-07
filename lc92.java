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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode reverseList = null;
        ListNode Answer = null;
        Boolean setReverse = false;
        int iter = 1;

        while(curr != null){
            if(iter >= m && iter <= n){
                ListNode nextTmp = curr.next;
                curr.next = reverseList;
                reverseList = curr;
                curr = nextTmp;
            }
            else if (iter == n+1){
                setReverse = true;
                while(reverseList != null)
                {
                    ListNode tmp = reverseList.next;
                    
                    reverseList.next = null;
                    if(prev == null){
                        prev = reverseList;
                        Answer = reverseList;
                    }
                    else{
                        prev.next = reverseList;
                        prev = prev.next;
                    }
                    reverseList = tmp;
                }
            }
            else{
                ListNode nextTmp = curr.next;
                curr.next = null;
                if(prev == null){
                    prev = curr;
                    Answer = curr;
                }
                else{
                    prev.next = curr;
                    prev = prev.next;
                }
                curr = nextTmp;
            }
            iter++;
        }

        if(Answer == null){
            Answer = reverseList;
        }
        else if(!setReverse){
            prev.next = reverseList;
        }
        
        return Answer;
    }
}

public class lc92{
    public static void main(String[] args){
        ListNode test = null;
        ListNode tmp  = null;

        for(int i = 1; i <= 10; i++){
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
        ListNode Ans = sol.reverseBetween(test, 8, 10);
        Solution.showlist(Ans);
        System.out.println();
    }
}