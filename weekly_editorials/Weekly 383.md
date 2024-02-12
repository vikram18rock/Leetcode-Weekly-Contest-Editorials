## Modify the Matrix

<details>
<summary>Python</summary>

```python
class Solution:
    def modifiedMatrix(self, a):
        n = len(a)
        m = len(a[0])
        ans = [[0] * m for _ in range(n)]
        
        for j in range(m):
            mx = -1
            for i in range(n):
                mx = max(mx, a[i][j])
            for i in range(n):
                if a[i][j] == -1:
                    ans[i][j] = mx
                else:
                    ans[i][j] = a[i][j]
        
        return ans

# Example usage:
# solution = Solution()
# input_matrix = [[1, 2, 3], [-1, 5, -1], [7, 8, 9]]
# result_matrix = solution.modifiedMatrix(input_matrix)
# print(result_matrix)
```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    vector<vector<int>> modifiedMatrix(vector<vector<int>>& a) {
        int n = a.size();
        int m = a[0].size();
        vector<vector<int>> ans(n, vector<int>(m));
        
        for (int j = 0; j < m; j++) {
            int mx = -1;
            for (int i = 0; i < n; i++) mx = max(mx, a[i][j]);
            for (int i = 0; i < n; i++) {
                if (a[i][j] == -1) ans[i][j] = mx;
                else ans[i][j] = a[i][j];
            }
        }
        
        return ans;
    }
};
```

</details>

<details>
<summary>Java</summary>

```java
import java.util.*;

class Solution {
    public int[][] modifiedMatrix(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];
        
        for (int j = 0; j < m; j++) {
            int mx = -1;
            for (int i = 0; i < n; i++) {
                mx = Math.max(mx, a[i][j]);
            }
            for (int i = 0; i < n; i++) {
                if (a[i][j] == -1) {
                    ans[i][j] = mx;
                } else {
                    ans[i][j] = a[i][j];
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] inputMatrix = {{1, 2, 3}, {-1, 5, -1}, {7, 8, 9}};
        int[][] resultMatrix = solution.modifiedMatrix(inputMatrix);
        for (int i = 0; i < resultMatrix.length; i++) {
            System.out.println(Arrays.toString(resultMatrix[i]));
        }
    }
}

```

</details>

## Number of Subarrays that match a pattern |

<details>
<summary>Python</summary>

```python
class Solution:
    def countMatchingSubarrays(self, a, pattern):
        n = len(a)
        m = len(pattern)
        ans = 0
        
        for start in range(n):
            end = start + m
            if end >= n:
                break
            
            ok = True
            for i in range(m):
                curr = 0
                if a[start + i + 1] > a[start + i]:
                    curr = 1
                elif a[start + i + 1] < a[start + i]:
                    curr = -1
                if curr != pattern[i]:
                    ok = False
                    break
            if ok:
                ans += 1
        
        return ans

# Example usage:
# solution = Solution()
# a = [1, 2, 3, 4, 5]
# pattern = [1, 1, 1]
# result = solution.countMatchingSubarrays(a, pattern)
# print(result)

```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    int countMatchingSubarrays(vector<int>& a, vector<int>& pattern) {
        int n = a.size(), m = pattern.size();
        int ans = 0;
        
        for (int start = 0; start < n; start++) {
            int end = start + m;
            if (end >= n) break;
            
            bool ok = true;
            for (int i = 0; i < m; i++) {
                int curr = 0;
                if (a[start + i + 1] > a[start + i]) curr = 1;
                else if (a[start + i + 1] < a[start + i]) curr = -1;
                if (curr != pattern[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans++;
        }
        
        return ans;
    }
};

```

</details>

<details>
<summary>Java</summary>

```java
class Solution {
    public int countMatchingSubarrays(int[] a, int[] pattern) {
        int n = a.length;
        int m = pattern.length;
        int ans = 0;
        
        for (int start = 0; start < n; start++) {
            int end = start + m;
            if (end >= n)
                break;
            
            boolean ok = true;
            for (int i = 0; i < m; i++) {
                int curr = 0;
                if (a[start + i + 1] > a[start + i])
                    curr = 1;
                else if (a[start + i + 1] < a[start + i])
                    curr = -1;
                if (curr != pattern[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok)
                ans++;
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 3, 4, 5};
        int[] pattern = {1, 1, 1};
        int result = solution.countMatchingSubarrays(a, pattern);
        System.out.println(result);
    }
}
```

</details>

## Maximum Palindromes

<details>
<summary>Python</summary>

```python

 
def maxPalindromesAfterOperations(words):
    a = [0] * 26
    even = 0
    odd = 0
    temp = []
    for word in words:
        x = len(word)
        temp.append(x)
        for c in word:
            a[ord(c) - ord('a')] += 1
    for i in range(26):
        even += (a[i] // 2)
        odd += (a[i] % 2)
    temp.sort()
    ans = 0
    for i in range(len(temp)):
        x = temp[i] // 2
        if even - x < 0:
            break
        else:
            even -= x
        if temp[i] % 2:
            if odd > 0:
                odd -= 1
            elif even > 0:
                even -= 1
                odd += 2
                odd -= 1
            else:
                break
        ans += 1
    return ans
```

</details>

<details>
<summary>Cpp</summary>

```cpp


int maxPalindromesAfterOperations(vector<string>& words) 
    {
        int a[26]={0};
        int even=0;
        int odd=0;
        vector<int>temp;
        for(int i=0;i<words.size();i++)
        {
            int x=words[i].size();
            temp.push_back(x);
            for(int j=0;j<words[i].size();j++)
            {
                a[words[i][j]-'a']++;
            }
        }
        for(int i=0;i<26;i++)
        {
            even+=(a[i]/2);
            odd+=(a[i]%2);
        }
        sort(temp.begin(),temp.end());
        int ans=0;
        for(int i=0;i<temp.size();i++)
        {
            int x=temp[i]/2;
            if(even-x <0)
                break;
            else
                even-=x;
            if(temp[i]%2)
            {
                if(odd>0)
                {
                    odd--;
                }
                else if(even>0)
                {
                    even--;
                    odd+=2;
                    odd--;
                }
                else
                    break;
            }
            ans++;
        }
        return ans;
    }




```

</details>

<details>
<summary>Java</summary>

```java
public int maxPalindromesAfterOperations(String[] words) {
    int[] a = new int[26];
    int even = 0;
    int odd = 0;
    ArrayList<Integer> temp = new ArrayList<>();
    for (String word : words) {
        int x = word.length();
        temp.add(x);
        for (char c : word.toCharArray()) {
            a[c - 'a']++;
        }
    }
    for (int i = 0; i < 26; i++) {
        even += (a[i] / 2);
        odd += (a[i] % 2);
    }
    Collections.sort(temp);
    int ans = 0;
    for (int i = 0; i < temp.size(); i++) {
        int x = temp.get(i) / 2;
        if (even - x < 0)
            break;
        else
            even -= x;
        if (temp.get(i) % 2 == 1) {
            if (odd > 0) {
                odd--;
            } else if (even > 0) {
                even--;
                odd += 2;
                odd--;
            } else
                break;
        }
        ans++;
    }
    return ans;
}

```

</details>

## Number of Subarrays that match a pattern ||

<details>
<summary>Python</summary>

```python


def countMatchingSubarrays(nums, pattern):
    n = len(nums)
    m = len(pattern)
    temp = []
    for i in range(n - 1):
        if nums[i] < nums[i + 1]:
            temp.append(1)
        elif nums[i] == nums[i + 1]:
            temp.append(0)
        else:
            temp.append(-1)
    
    lps = [0] * m
    prevlps = 0
    i = 1
    while i <= m - 1:
        if pattern[prevlps] == pattern[i]:
            lps[i] = prevlps + 1
            prevlps += 1
            i += 1
        else:
            if prevlps == 0:
                lps[i] = 0
                i += 1
            else:
                prevlps = lps[prevlps - 1]
    
    i = 0
    j = 0
    ans = 0
    n = len(temp)
    while i <= n - 1:
        if pattern[j] == temp[i]:
            i += 1
            j += 1
        else:
            if j == 0:
                i += 1
            else:
                j = lps[j - 1]
        if j == m:
            ans += 1
            j = lps[j - 1]
    return ans
```

</details>

<details>
<summary>Cpp</summary>

```cpp
int countMatchingSubarrays(vector<int>& nums, vector<int>& pattern) 
    {
        int n=nums.size();
        int m=pattern.size();
        vector<int>temp;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]<nums[i+1])
                temp.push_back(1);
            else if(nums[i]==nums[i+1])
                temp.push_back(0);
            else
                temp.push_back(-1);
        }
        
        vector<int>lps(m,0);
        int prevlps=0;
        int i=1;
        while(i<=m-1)
        {
            if(pattern[prevlps]==pattern[i])
            {
                lps[i]=prevlps+1;
                prevlps++;
                i++;
            }
            else
            {
                if(prevlps==0)
                {
                    lps[i]=0;
                    i++;
                }
                else
                {
                    prevlps=lps[prevlps-1];
                }
            }
        }
        
        i=0;
        int j=0;
        int ans=0;
        n=temp.size();
        while(i<=n-1)
        {
            if(pattern[j]==temp[i])
            {
                i++;
                j++;
            }
            else
            {
                if(j==0)
                    i++;
                else
                    j=lps[j-1];
            }
            if(j==m)
            {
                ans++;
                j=lps[j-1];
            }
        }
        return ans;
    }



```

</details>