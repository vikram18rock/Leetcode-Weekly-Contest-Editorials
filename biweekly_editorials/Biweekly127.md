## Shortest Subarray With OR atleast K |

<details>
<summary>Python</summary>

```python
def perform_or_operation(bit_count, or_val, n):
    or_val |= n
    for t in range(32):
        bit_count[t] += 1 if n & (1 << t) else 0

def nullify_or_operation(bit_count, or_val, n):
    for t in range(32):
        bit_count[t] -= 1 if n & (1 << t) else 0
        if bit_count[t] == 0:
            or_val &= ~(1 << t)

def minimum_subarray_length(nums, k):
    or_val = 0
    ans = float('inf')
    bit_count = [0] * 32
    i = j = 0
    while i < len(nums):
        perform_or_operation(bit_count, or_val, nums[i])
        if or_val < k:
            i += 1
            continue
        while j <= i and or_val >= k:
            nullify_or_operation(bit_count, or_val, nums[j])
            ans = min(ans, i - j + 1)
            j += 1
        i += 1
    return ans if ans != float('inf') else -1

nums = [1, 2, 3, 4, 5]
k = 7
print(minimum_subarray_length(nums, k))

```

</details>

<details>
<summary>Cpp</summary>

```cpp
     void performOrOperation(vector<int>& bitCount, int& orVal, int n){
    orVal = (orVal | n);
    for(int t = 0; t < 32; ++t) bitCount[t] += (n & (1 << t))?1:0;
}

void nullifyOrOperation(vector<int>& bitCount, int& orVal, int n){
    for(int t = 0; t < 32; ++t){
        bitCount[t] += (n & (1 << t))?-1:0;
        if(bitCount[t] == 0) orVal = orVal & (~(1<<t));
    }
}

int minimumSubarrayLength(vector<int>& nums, int k) {
    int orVal = 0, ans = INT_MAX;
    vector<int> bitCount(32, 0);
    for(int i = 0, j = 0; i < nums.size(); ++i){
        performOrOperation(bitCount, orVal, nums[i]);
        if(orVal < k) continue; 
        for( ;j <= i && orVal >= k; j++){
            nullifyOrOperation(bitCount, orVal, nums[j]);
            ans = min(ans, i - j + 1);
        }
    }
    return (ans == INT_MAX)? -1: ans;
}
```

</details>

<details>
<summary>Java</summary>

```java
import java.util.Arrays;
import java.util.Vector;

public class Main {
    
    static void performOrOperation(Vector<Integer> bitCount, int[] orVal, int n) {
        orVal[0] |= n;
        for (int t = 0; t < 32; ++t)
            bitCount.set(t, bitCount.get(t) + ((n & (1 << t)) != 0 ? 1 : 0));
    }

    static void nullifyOrOperation(Vector<Integer> bitCount, int[] orVal, int n) {
        for (int t = 0; t < 32; ++t) {
            bitCount.set(t, bitCount.get(t) + ((n & (1 << t)) != 0 ? -1 : 0));
            if (bitCount.get(t) == 0)
                orVal[0] &= ~(1 << t);
        }
    }

    static int minimumSubarrayLength(Vector<Integer> nums, int k) {
        int[] orVal = {0};
        int ans = Integer.MAX_VALUE;
        Vector<Integer> bitCount = new Vector<>(Arrays.asList(new Integer[32]));
        for (int i = 0; i < 32; ++i) bitCount.set(i, 0);
        for (int i = 0, j = 0; i < nums.size(); ++i) {
            performOrOperation(bitCount, orVal, nums.get(i));
            if (orVal[0] < k) continue;
            for (; j <= i && orVal[0] >= k; j++) {
                nullifyOrOperation(bitCount, orVal, nums.get(j));
                ans = Math.min(ans, i - j + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Vector<Integer> nums = new Vector<>(Arrays.asList(1, 2, 3, 4, 5));
        int k = 7;
        System.out.println(minimumSubarrayLength(nums, k));
    }
}

```

</details>

## Minimum Levels to Gain more points

<details>
<summary>Python</summary>

```python
class Solution:
    def __init__(self):
        pass

    def minimum_levels(self, possible):
        sum_val = sum(1 if num != 0 else -1 for num in possible)
        print(sum_val)

        first_player = 0
        for i in range(len(possible) - 1):
            first_player += 1 if possible[i] != 0 else -1
            if first_player > sum_val - first_player:
                return i + 1
        return -1


if __name__ == "__main__":
    possible = [1, 0, 1, 0, 1]
    solution = Solution()
    print(solution.minimum_levels(possible))

```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    Solution()
    {
        ios_base::sync_with_stdio(false); 
        cin.tie(NULL); 
        cout.tie(NULL);
    }

    int minimumLevels(vector<int>& possible) {
        int sum {};
        int n = possible.size();
        for (int& num : possible)
            sum += (num ? 1 : -1);

        cout << sum << '\n';

        int firstPlayer = 0;
        for (int i = 0; i < n-1; ++i)
        {
            firstPlayer += (possible[i] ? 1 : -1);
            if (firstPlayer > sum-firstPlayer)
                return i + 1;
        }
        return -1;
    }
};
```

</details>

<details>
<summary>Java</summary>

```java
import java.util.Arrays;

class Solution {
    Solution() {
        // Constructor
    }

    int minimumLevels(int[] possible) {
        int sum = 0;
        int n = possible.length;
        for (int num : possible)
            sum += (num != 0 ? 1 : -1);

        System.out.println(sum);

        int firstPlayer = 0;
        for (int i = 0; i < n - 1; ++i) {
            firstPlayer += (possible[i] != 0 ? 1 : -1);
            if (firstPlayer > sum - firstPlayer)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] possible = {1, 0, 1, 0, 1};
        Solution solution = new Solution();
        System.out.println(solution.minimumLevels(possible));
    }
}

```

</details>

## Shortest Subarray with atleast K ||

<details>
<summary>Python</summary>

```python
class Solution:
    def update(self, bits: List[int], x: int, change: int):
        # insert or remove element from window, time: O(32)
        for i in range(32):
            if (x >> i) & 1:
                bits[i] += change

    def bitsToNum(self, bits: List[int]) -> int:
        # convert 32-size bits array to integer, time: O(32)
        result = 0
        for i in range(32):
            if bits[i]:
                result |= 1 << i
        return result
    
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        result = n + 1
        bits = [0] * 32
        start = 0
        for end in range(n):
            self.update(bits, nums[end], 1) # insert nums[end] into window
            while start <= end and self.bitsToNum(bits) >= k:
                result = min(result, end - start + 1)
                self.update(bits, nums[start], -1) # remove nums[start] from window
                start += 1
        return result if result != n + 1 else -1

```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
private:
    void update(vector<int>& bits, int x, int change) {
        // insert or remove element from window, time: O(32)
        for (int i = 0; i < 32; i++) {
            if ((x >> i) & 1) {
                bits[i] += change;
            }
        }
    }
    
    int bitsToNum(vector<int>& bits) {
        // convert 32-size bits array to integer, time: O(32)
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i]) {
                result |= 1 << i;
            }
        }
        return result;
    }
    
public:
    int minimumSubarrayLength(vector<int>& nums, int k) {
        int n = nums.size(), result = n + 1;
        vector<int> bits(32);
        for (int start = 0, end = 0; end < n; end++) {
            update(bits, nums[end], 1); // insert nums[end] into window
            while (start <= end && bitsToNum(bits) >= k) {
                result = min(result, end - start + 1);
                update(bits, nums[start++], -1); // remove nums[start] from window
            }
        }
        return result != n + 1 ? result : -1;
    }
};

```

</details>

<details>
<summary>Java</summary>

```java
class Solution {
    private void update(int[] bits, int x, int change) {
        // insert or remove element from window, time: O(32)
        for (int i = 0; i < 32; i++) {
            if (((x >> i) & 1) != 0) {
                bits[i] += change;
            }
        }
    }

    private int bitsToNum(int[] bits) {
        // convert 32-size bits array to integer, time: O(32)
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] != 0) {
                result |= 1 << i;
            }
        }
        return result;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length, result = n + 1;
        int[] bits = new int[32];
        for (int start = 0, end = 0; end < n; end++) {
            update(bits, nums[end], 1); // insert nums[end] into window
            while (start <= end && bitsToNum(bits) >= k) {
                result = Math.min(result, end - start + 1);
                update(bits, nums[start++], -1); // remove nums[start] from window
            }
        }
        return result != n + 1 ? result : -1;
    }
}

```

</details>

## Find the sum of subsequence of powers

<details>
<summary>Python</summary>

```python
from functools import cache

class Solution:
    def sumOfPowers(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()
        
        @cache
        def sim(i, prev, k, mini):
            if k == 0:
                return mini
            
            if i == n and k:
                return 0
            
            skip = sim(i+1, prev, k, mini)
            
            pick = sim(i+1, i, k-1, min(mini, nums[i] - nums[prev] if prev != -1 else 1e9))
            
            return (pick + skip) % int(1e9 + 7)

        return sim(0, -1, k, 1e9)

```

</details>

<details>
<summary>Cpp</summary>

```cpp
#include <unordered_map>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
    int n, mod = 1e9 + 7;
    unordered_map<long long, int> dp;
private:
    int sim(int i, int prev, int k, int mini, vector<int> &nums) {
        if (!k) return mini;
        if (i == n and k) return 0;
        
        long long key = i + 1e2 * prev + 1e4 * k + 1e6 * mini;
        
        if (dp.find(key) != dp.end()) 
            return dp[key];

        int skip = sim(i+1, prev, k, mini, nums);
        int pick = sim(i+1, i, k-1, min(mini, prev == -1 ? mod : nums[i] - nums[prev]), nums);
        
        return dp[key] = (pick + skip) % mod;
    }
public:
    int sumOfPowers(vector<int>& nums, int k) {
        n = nums.size();
        sort(nums.begin(), nums.end());

        return sim(0, -1, k, 1e9, nums);
    }
};

```

</details>

<details>
<summary>Java</summary>

```java
import java.util.*;

class Solution {
    private int n;
    private final int mod = (int) 1e9 + 7;
    private Map<Long, Integer> dp = new HashMap<>();

    private int sim(int i, int prev, int k, int mini, int[] nums) {
        if (k == 0) return mini;
        if (i == n && k > 0) return 0;

        long key = i + 1e2 * prev + 1e4 * k + 1e6 * mini;

        if (dp.containsKey(key))
            return dp.get(key);

        int skip = sim(i + 1, prev, k, mini, nums);
        int pick = sim(i + 1, i, k - 1, Math.min(mini, prev == -1 ? mod : nums[i] - nums[prev]), nums);

        int result = (pick + skip) % mod;
        dp.put(key, result);
        return result;
    }

    public int sumOfPowers(int[] nums, int k) {
        n = nums.length;
        Arrays.sort(nums);

        return sim(0, -1, k, (int) 1e9, nums);
    }
}

```

</details>