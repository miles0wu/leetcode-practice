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
        int iter = 1;

        while(curr != null){
            System.out.printf("----Round%s----%n",iter);
            ListNode nextTmp = curr.next;
            System.out.print("n:");
            showlist(nextTmp);
            System.out.println("");
            curr.next = prev;
            System.out.print("c:");
            showlist(curr);
            System.out.println("");
            prev = curr;
            System.out.print("p:");
            showlist(prev);
            System.out.println("");
            curr = nextTmp;
            System.out.print("c:");
            showlist(curr);
            System.out.println("");
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
        //Solution.showlist(test);
        //System.out.println("");
    }
}