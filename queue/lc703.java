import java.util.*;
import static java.lang.System.out;

class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for(int num: nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if(q.size() < k){
            q.offer(val);
        }
        else if(val > q.peek()){
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}

public class lc703{
    public static void main(String[] args){
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(k, arr);
        out.println(kthLargest.add(3));   // returns 4
        out.println(kthLargest.add(5));   // returns 5
        out.println(kthLargest.add(10));  // returns 5
        out.println(kthLargest.add(9));   // returns 8
        out.println(kthLargest.add(4));   // returns 8
    }
}