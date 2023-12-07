import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int part = sequence[0];

        int n = sequence.length;

        List<SubSequence> subs = new ArrayList<>();
        while (true){
            if(part == k){
                subs.add(new SubSequence(left, right));
            }
            if(left == n && right == n) break;

            if(part <= k && right < n){
                right++;
                if(right < n) part += sequence[right];
            } else {
                if(left < n) part -= sequence[left];
                left++;
            }
        }

        subs.sort(SubSequence::compareTo);

        return new int[]{subs.get(0).left, subs.get(0).right};
    }

    private class SubSequence implements Comparable<SubSequence>{
        int left, right, size;

        public SubSequence(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = right - left;
        }

        @Override
        public int compareTo(SubSequence o) {
            if(this.size == o.size){
                return this.left - o.left;
            }
            return this.size - o.size;
        }
    }
}