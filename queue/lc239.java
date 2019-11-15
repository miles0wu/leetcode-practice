import java.util.*;
import static java.lang.System.out;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0|| k == 0){
            return nums;
        }
        int idx = 0;
        int[] ans = new int[nums.length-k+1];
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b.compareTo(a);
            }
        });

        for(int i = 0; i < nums.length; i++){
            if(q.size() < k){
                q.offer(nums[i]);
            }
            else if(i >= k){
                q.remove(nums[i-k]);
                q.offer(nums[i]);
            }

            if(q.size() == k){
                ans[idx++] = q.peek();
            }
        }

        return ans;
    }
}

public class lc239{
    public static void main(String[] args){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        Solution ans = new Solution();
        out.println(Arrays.toString(ans.maxSlidingWindow(nums, k)));
    }
}