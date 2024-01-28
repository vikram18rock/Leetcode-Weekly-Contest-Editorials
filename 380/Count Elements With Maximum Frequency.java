import java.util.Arrays;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        int[] hash = new int[101];
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }
        
        int maxi = Arrays.stream(hash).max().getAsInt();
        int ans = 0;
        
        for (int i = 0; i < 101; i++) {
            if (hash[i] == maxi) {
                ans += hash[i];
            }
        }
        return ans;
    }
}

