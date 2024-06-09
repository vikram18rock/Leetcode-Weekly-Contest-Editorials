## Clear digits

<details>
<summary>Python</summary>

```python
# Python code
def clear_digits(s):
    res = []
    for ch in s:
        if ch.isdigit():
            if res:
                res.pop()
        else:
            res.append(ch)
    return ''.join(res)


```

</details>

<details>
<summary>Cpp</summary>

```cpp
   #include <string>
using namespace std;

string clearDigits(string s) {
    string res;
    for (char ch : s) {
        if (isdigit(ch))
            res.pop_back();
        else
            res += ch;
    }
    return res;
}


```

</details>

<details>
<summary>Java</summary>

```java
// Java code
public class ClearDigits {
    public static String clearDigits(String s) {
        StringBuilder res = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1);
                }
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}



```

</details>

## Find the first player to win K games in a row

<details>
<summary>Python</summary>

```python
class Solution:
    def findWinningPlayer(self, skills, k):
        count = 0
        values = skills[0]
        index = 0
        for i in range(1, len(skills)):
            if count == k:
                return index
            if values > skills[i]:
                count += 1
            else:
                values = skills[i]
                index = i
                count = 1
        return index



```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    int findWinningPlayer(vector<int>& skills, int k) 
    {
        int count=0;
        int values=skills[0];
        int index=0;
        for(int i=1;i<skills.size();i++)
        {
            if(count==k)
                return index;
            if(values > skills[i])
            count++;
            else
            {
                values=skills[i];
                index=i;
                count=1;
            }
        }
        return index;
    }
};


```

</details>

<details>
<summary>Java</summary>

```java
// Java code
import java.util.List;

class Solution {
    public int findWinningPlayer(List<Integer> skills, int k) {
        int count = 0;
        int values = skills.get(0);
        int index = 0;
        for (int i = 1; i < skills.size(); i++) {
            if (count == k) {
                return index;
            }
            if (values > skills.get(i)) {
                count++;
            } else {
                values = skills.get(i);
                index = i;
                count = 1;
            }
        }
        return index;
    }
}





```

</details>

## Maximum lngth of good subsequence |

<details>
<summary>Python</summary>

```python
class Solution:
    def maximumLength(self, nums, k):
        dp = [[[-1 for _ in range(26)] for _ in range(503)] for _ in range(503)]
        
        def find(pos, prev, cnt, nums):
            if pos == len(nums):
                return 0

            if dp[pos][prev + 1][cnt] != -1:
                return dp[pos][prev + 1][cnt]

            ans = -1

            if prev == -1:
                ans = max(ans, find(pos + 1, -1, cnt, nums))  # not starting
                ans = max(ans, 1 + find(pos + 1, pos, cnt, nums))  # starting
            else:
                if nums[pos] == nums[prev]:
                    ans = max(ans, 1 + find(pos + 1, pos, cnt, nums))  # adding
                else:
                    ans = max(ans, find(pos + 1, prev, cnt, nums))  # skipping
                    if cnt > 0:
                        ans = max(ans, 1 + find(pos + 1, pos, cnt - 1, nums))  # adding and reducing cnt

            dp[pos][prev + 1][cnt] = ans
            return ans

        ans = find(0, -1, k, nums)
        return ans

```

</details>

<details>
<summary>Cpp</summary>

```cpp
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;

class Solution {
public:
    int dp[503][503][26];

    int find(int pos, int prev, int cnt, vector<int>& nums) {
        if (pos == nums.size())
            return 0;

        if (dp[pos][prev + 1][cnt] != -1)
            return dp[pos][prev + 1][cnt];

        int ans = -1;

        if (prev == -1) {
            ans = max(ans, find(pos + 1, -1, cnt, nums));  // not starting
            ans = max(ans, 1 + find(pos + 1, pos, cnt, nums));  // starting
        } else {
            if (nums[pos] == nums[prev])
                ans = max(ans, 1 + find(pos + 1, pos, cnt, nums));  // adding
            else {
                ans = max(ans, find(pos + 1, prev, cnt, nums));  // skipping
                if (cnt > 0)
                    ans = max(ans, 1 + find(pos + 1, pos, cnt - 1, nums));  // adding and reducing cnt
            }
        }

        return dp[pos][prev + 1][cnt] = ans;
    }

    int maximumLength(vector<int>& nums, int k) {
        memset(dp, -1, sizeof(dp));
        int ans = find(0, -1, k, nums);
        return ans;
    }
};



```

</details>

<details>
<summary>Java</summary>

```java
import java.util.*;

public class Solution {
    int[][][] dp = new int[503][503][26];

    public int find(int pos, int prev, int cnt, int[] nums) {
        if (pos == nums.length)
            return 0;

        if (dp[pos][prev + 1][cnt] != -1)
            return dp[pos][prev + 1][cnt];

        int ans = -1;

        if (prev == -1) {
            ans = Math.max(ans, find(pos + 1, -1, cnt, nums));  // not starting
            ans = Math.max(ans, 1 + find(pos + 1, pos, cnt, nums));  // starting
        } else {
            if (nums[pos] == nums[prev])
                ans = Math.max(ans, 1 + find(pos + 1, pos, cnt, nums));  // adding
            else {
                ans = Math.max(ans, find(pos + 1, prev, cnt, nums));  // skipping
                if (cnt > 0)
                    ans = Math.max(ans, 1 + find(pos + 1, pos, cnt - 1, nums));  // adding and reducing cnt
            }
        }

        return dp[pos][prev + 1][cnt] = ans;
    }

    public int maximumLength(int[] nums, int k) {
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        int ans = find(0, -1, k, nums);
        return ans;
    }
}



```

</details>

## Find maximum length of good subsequence ||

<details>
<summary>Python</summary>

```python
from bisect import bisect_right
from collections import defaultdict

class Solution:
    def fn(self, v, ci):
        return bisect_right(v, ci)
    
    def f(self, nums, i, k, strict, mp, memo):
        if i >= len(nums):
            return 0
        if k < 0:
            return 0
        if memo[i][k][strict] != -1:
            return memo[i][k][strict]

        val = 0
        nextIndex = self.fn(mp[nums[i]], i)
        if nextIndex < len(mp[nums[i]]):
            val = max(val, 1 + self.f(nums, mp[nums[i]][nextIndex], k, 1, mp, memo))
        else:
            val = max(val, 1 + self.f(nums, len(nums), k, 1, mp, memo))
        if k > 0:
            val = max(val, 1 + self.f(nums, i + 1, k - 1, 0, mp, memo))
        if not strict:
            val = max(val, self.f(nums, i + 1, k, 0, mp, memo))

        memo[i][k][strict] = val
        return val
    
    def maximumLength(self, nums, k):
        mp = defaultdict(list)
        for i in range(len(nums)):
            mp[nums[i]].append(i)

        memo = [[[-1] * 2 for _ in range(k + 1)] for _ in range(len(nums))]
        return self.f(nums, 0, k, 0, mp, memo)

```

</details>

<details>
<summary>Cpp</summary>

```cpp
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

class Solution {
public:
    int fn(vector<int>& v, int ci) {
        return upper_bound(v.begin(), v.end(), ci) - v.begin();
    }

    int f(vector<int>& nums, int i, int k, bool strict, map<int, vector<int>>& mp, vector<vector<vector<int>>>& memo) {
        if (i >= nums.size()) return 0;
        if (k < 0) return 0;
        if (memo[i][k][strict] != -1) return memo[i][k][strict];

        int val = 0;
        int nextIndex = fn(mp[nums[i]], i);
        if (nextIndex < mp[nums[i]].size()) {
            val = max(val, 1 + f(nums, mp[nums[i]][nextIndex], k, 1, mp, memo));
        } else {
            val = max(val, 1 + f(nums, nums.size(), k, 1, mp, memo));
        }
        if (k)
            val = max(val, 1 + f(nums, i + 1, k - 1, 0, mp, memo));
        if (!strict)
            val = max(val, f(nums, i + 1, k, 0, mp, memo));

        return memo[i][k][strict] = val;
    }

    int maximumLength(vector<int>& nums, int k) {
        map<int, vector<int>> mp;
        for (int i = 0; i < nums.size(); i++) {
            mp[nums[i]].push_back(i);
        }

        vector<vector<vector<int>>> memo(nums.size(), vector<vector<int>>(k + 1, vector<int>(2, -1)));
        return f(nums, 0, k, 0, mp, memo);
    }
};

```

</details>

<details>
<summary>Java</summary>

```java
import java.util.*;

public class Solution {
    public int fn(List<Integer> v, int ci) {
        int pos = Collections.binarySearch(v, ci);
        if (pos < 0) {
            pos = -pos - 1;
        } else {
            while (pos < v.size() && v.get(pos) <= ci) {
                pos++;
            }
        }
        return pos;
    }

    public int f(List<Integer> nums, int i, int k, boolean strict, Map<Integer, List<Integer>> mp, int[][][] memo) {
        if (i >= nums.size()) return 0;
        if (k < 0) return 0;
        if (memo[i][k][strict ? 1 : 0] != -1) return memo[i][k][strict ? 1 : 0];

        int val = 0;
        int nextIndex = fn(mp.get(nums.get(i)), i);
        if (nextIndex < mp.get(nums.get(i)).size()) {
            val = Math.max(val, 1 + f(nums, mp.get(nums.get(i)).get(nextIndex), k, true, mp, memo));
        } else {
            val = Math.max(val, 1 + f(nums, nums.size(), k, true, mp, memo));
        }
        if (k > 0)
            val = Math.max(val, 1 + f(nums, i + 1, k - 1, false, mp, memo));
        if (!strict)
            val = Math.max(val, f(nums, i + 1, k, false, mp, memo));

        return memo[i][k][strict ? 1 : 0] = val;
    }

    public int maximumLength(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            mp.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }

        int[][][] memo = new int[nums.size()][k + 1][2];
        for (int[][] level1 : memo) {
            for (int[] level2 : level1) {
                Arrays.fill(level2, -1);
            }
        }
        return f(nums, 0, k, false, mp, memo);
    }
}

```

</details>

