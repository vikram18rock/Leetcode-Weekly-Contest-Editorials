## Check if Grid Satisfies Conditions

<details>
<summary>Python</summary>

```python
class Solution:
    def satisfiesConditions(self, grid: List[List[int]]) -> bool:
        for i in range(len(grid) - 1):
            if grid[i] == grid[i+1]:
                continue
            else:
                return False
        for j in range(len(grid[0]) - 1):
            if grid[0][j] == grid[0][j+1]:
                return False
        return True
```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    bool satisfiesConditions(vector<vector<int>>& grid) {
        for(int i = 0 ; i < grid.size()-1 ; i++)
        {
            if(grid[i]==grid[i+1])
            {
                continue;
            }
            else
                return false;
        }
        for(int j = 0 ; j < grid[0].size()-1 ; j++)
        {
            if(grid[0][j]==grid[0][j+1])
                return false;
        }
        return true;
    }
};
```

</details>

<details>
<summary>Java</summary>

```java
import java.util.List;

class Solution {
    public boolean satisfiesConditions(List<List<Integer>> grid) {
        for (int i = 0; i < grid.size() - 1; i++) {
            if (grid.get(i).equals(grid.get(i + 1))) {
                continue;
            } else {
                return false;
            }
        }
        for (int j = 0; j < grid.get(0).size() - 1; j++) {
            if (grid.get(0).get(j).equals(grid.get(0).get(j + 1))) {
                return false;
            }
        }
        return true;
    }
}
```

</details>

## Maximum Points Inside the Square

<details>
<summary>Python</summary>

```python
class Solution:
    def maxPointsInsideSquare(self, points: List[List[int]], s: str) -> int:
        minLens = {}
        secondMin = float('inf')

        for point, char in zip(points, s):
            size = max(abs(point[0]), abs(point[1]))

            if char not in minLens:
                minLens[char] = size
            elif size < minLens[char]:
                secondMin = min(minLens[char], secondMin)
                minLens[char] = size
            else:
                secondMin = min(size, secondMin)

        count = 0
        for len in minLens.values():
            if len < secondMin:
                count += 1

        return count
```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    int maxPointsInsideSquare(vector<vector<int>>& points, string s) {
        unordered_map<char, int> minLens;
        int secondMin = INT_MAX, count = 0;

        for(int i = 0; i < points.size(); ++i) {
            int len = max(abs(points[i][0]), abs(points[i][1]));
            char c = s[i];

            if(minLens.find(c) == minLens.end()) {
                minLens[c] = len;
            } else if(len < minLens[c]) {
                secondMin = min(secondMin, minLens[c]);
                minLens[c] = len;
            } else {
                secondMin = min(secondMin, len);
            }
        }

        for(auto& pair : minLens) {
            if(pair.second < secondMin) {
                count++;
            }
        }

        return count;
    }
};
```

</details>

<details>
<summary>Java</summary>

```java
class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        HashMap<Character, Integer> minLens = new HashMap<>();
        int secondMin = Integer.MAX_VALUE, count = 0;

        for (int i = 0; i < points.length; ++i) {
            int len = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            char c = s.charAt(i);

            if (!minLens.containsKey(c)) {
                minLens.put(c, len);
            } else if (len < minLens.get(c)) {
                secondMin = Math.min(minLens.get(c), secondMin);
                minLens.put(c, len);
            } else {
                secondMin = Math.min(len, secondMin);
            }
        }

        for(int len : minLens.values()) {
            if(len < secondMin) {
                count++;
            }
        }

        return count;
    }
}
```

</details>

## Minimum Substring Partition of Equal Character Frequency

<details>
<summary>Python</summary>

```python
class Solution:
    def __init__(self):
        self.dp = [-1] * 10001

    def helper(self, i, s):
        if i < 0:
            return 0

        if self.dp[i] != -1:
            return self.dp[i]

        freq = [0] * 26
        res = 10001

        for j in range(i, -1, -1):
            freq[ord(s[j]) - ord('a')] += 1
            mini = 10001
            maxi = 0

            for k in range(26):
                if freq[k] > 0:
                    mini = min(mini, freq[k])
                    maxi = max(maxi, freq[k])

            if mini == maxi:
                res = min(res, 1 + self.helper(j - 1, s))

        self.dp[i] = res
        return res

    def minimumSubstringsInPartition(self, s: str) -> int:
        self.dp = [-1] * 10001
        return self.helper(len(s) - 1, s)
```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    int dp[10001];
    int helper(int i, string &s) {
        if (i < 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int freq[26] = {0}, res = 10001;
        for (int j = i; j >= 0; j--) {
            freq[s[j] - 'a']++;
            int mini = 10001, maxi = 0;
            for (int k = 0; k < 26; k++) {
                if (freq[k]) {
                    mini = min(mini, freq[k]);
                    maxi = max(maxi, freq[k]);
                }
            }

            if (mini == maxi) {
                res = min(res, 1 + helper(j - 1, s));
            }
        }

        return dp[i] = res;
    }

    int minimumSubstringsInPartition(string s) {
        memset(dp, -1, sizeof dp);
        return helper(s.size() - 1, s);
    }
};
```

</details>

<details>
<summary>Java</summary>

```java
class Solution {
    int[] dp = new int[10001];
    public int helper(int i, String s) {
        if(i < 0) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int[] freq = new int[26];
        int res = 10001;

        for(int j = i; j >= 0; j--) {
            freq[s.charAt(j) - 'a']++;
            int mini = 10001, maxi = 0;

            for(int k = 0; k < 26; k++) {
                if(freq[k] > 0) {
                    mini = Math.min(mini, freq[k]);
                    maxi = Math.max(maxi, freq[k]);
                }
            }

            if(mini == maxi) {
                res = Math.min(res, 1 + helper(j - 1, s));
            }
        }

        return dp[i] = res;
    }

    public int minimumSubstringsInPartition(String s) {
        Arrays.fill(dp, -1);
        return helper(s.length() - 1, s);
    }
}
```

</details>
