## Ant On Boundary

<details>
<summary>Python</summary>

```python
def returnToBoundaryCount(nums):
    length = len(nums)
     sum_val = 0
     count = 0
 
     for i in range(length):
         sum_val += nums[i]
         if sum_val == 0:
             count += 1
 
     return count
```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution{
Public: 
 int returnToBoundary(vector<int>&nums) 
{
   int sum=0;
  int ans=0;
for(auto it:nums) 
{
    Sum+=it;
If(sum==it) ans++;
}
Return ans;
}}
```

</details>

<details>
<summary>Java</summary>

```java
int returnToBoundaryCount(int[] nums) {
     int length = nums.length;
     int sum_val = 0;
     int count = 0;
 
     for (int i = 0; i < length; i++) {
         sum_val += nums[i];
         if (sum_val == 0)
             count++;
     }
 
     return count;
 }

```

</details>

## Minimum to revert word to initial state I

<details>
<summary>Python</summary>

```python
class Solution:
    def minimumTimeToInitialState(self, word, k):
        n = len(word)
        ans = 0

        for i in range(1, n):
            d = k
            ok = True

            for j in range(d, n):
                if word[j] != word[d]:
                    ok = False
                    break

            if ok:
                return 1

        return 0


```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    int minimumTimeToInitialState(string word, int k) {
        int n = word.length();
        int ans = 0;

        for (int i = 1; i < n; i++) {
            int d = k;
            bool ok = true;

            for (int j = d; j < n; j++) {
                if (word[j] - word[d]) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                return 1;
            }
        }

        return 0;
    }
};

```

</details>

<details>
<summary>Java</summary>

```java
public class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int ans = 0;

        for (int i = 1; i < n; i++) {
            int d = k;
            boolean ok = true;

            for (int j = d; j < n; j++) {
                if (word.charAt(j) != word.charAt(d)) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                return 1;
            }
        }

        return 0;
    }
}
```

</details>

## Find the grid of region average

<details>
<summary>Python</summary>

```python
def resultGrid(image, threshold):
    m = len(image)
    n = len(image[0])
    ans = [[0] * n for _ in range(m)]
    cnt = [[0] * n for _ in range(m)]

    for i in range(m - 2):
        for j in range(n - 2):
            valid = True
            for p in range(3):
                if abs(image[i + p][j] - image[i + p][j + 1]) > threshold or \
                   abs(image[i + p][j + 1] - image[i + p][j + 2]) > threshold:
                    valid = False
                    break

                if abs(image[i + 1][j + p] - image[i][j + p]) > threshold or \
                   abs(image[i + 1][j + p] - image[i + 2][j + p]) > threshold:
                    valid = False
                    break
            
            if valid:
                _sum = 0
                for p in range(3):
                    for q in range(3):
                        _sum += image[i + p][j + q]
                
                for p in range(3):
                    for q in range(3):
                        ans[i + p][j + q] += _sum // 9
                        cnt[i + p][j + q] += 1
    
    for i in range(m):
        for j in range(n):
            ans[i][j] = ans[i][j] // cnt[i][j] if cnt[i][j] > 0 else image[i][j]
    
    return ans

```

</details>

<details>
<summary>Cpp</summary>

```cpp


vector<vector<int>> resultGrid(vector<vector<int>>& image, int threshold) {
    int m = image.size(), n = image[0].size();
    vector<vector<int>> ans(m, vector<int>(n));
    vector<vector<int>> cnt(m, vector<int>(n));

    for (int i = 0; i <= m - 3; i++) {
        for (int j = 0; j <= n - 3; j++) {
            bool valid = true;
            for (int p = 0; p < 3; p++) {
                if (abs(image[i + p][j] - image[i + p][j + 1]) > threshold ||
                    abs(image[i + p][j + 1] - image[i + p][j + 2]) > threshold) {
                    valid = false;
                    break;
                }

                if (abs(image[i + 1][j + p] - image[i][j + p]) > threshold ||
                    abs(image[i + 1][j + p] - image[i + 2][j + p]) > threshold) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                int sum = 0;
                for (int p = 0; p < 3; p++) {
                    for (int q = 0; q < 3; q++) {
                        sum += image[i + p][j + q];
                    }
                }

                for (int p = 0; p < 3; p++) {
                    for (int q = 0; q < 3; q++) {
                        ans[i + p][j + q] += sum / 9;
                        cnt[i + p][j + q]++;
                    }
                }
            }
        }
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            ans[i][j] = cnt[i][j] > 0 ? (ans[i][j] / cnt[i][j]) : image[i][j];
        }
    }

    return ans;
}

```

</details>

<details>
<summary>Java</summary>

```java
public int[][] resultGrid(int[][] image, int threshold) {
    int m = image.length, n = image[0].length;
    int[][] ans = new int[m][n];
    int[][] cnt = new int[m][n];

    for (int i = 0; i <= m - 3; i++) {
        for (int j = 0; j <= n - 3; j++) {
            boolean valid = true;
            for (int p = 0; p < 3; p++) {
                if (Math.abs(image[i + p][j] - image[i + p][j + 1]) > threshold ||
                    Math.abs(image[i + p][j + 1] - image[i + p][j + 2]) > threshold) {
                    valid = false;
                    break;
                }

                if (Math.abs(image[i + 1][j + p] - image[i][j + p]) > threshold ||
                    Math.abs(image[i + 1][j + p] - image[i + 2][j + p]) > threshold) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                int sum = 0;
                for (int p = 0; p < 3; p++) {
                    for (int q = 0; q < 3; q++) {
                        sum += image[i + p][j + q];
                    }
                }

                for (int p = 0; p < 3; p++) {
                    for (int q = 0; q < 3; q++) {
                        ans[i + p][j + q] += sum / 9;
                        cnt[i + p][j + q]++;
                    }
                }
            }
        }
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            ans[i][j] = cnt[i][j] > 0 ? (ans[i][j] / cnt[i][j]) : image[i][j];
        }
    }

    return ans;
}

```

</details>

## Minimum to revert word to initial state II

<details>
<summary>Python</summary>

```python

def minimumTimeToInitialState(self, word: str, k: int) -> int:
        def lsp(s):
            n = len(s)
            lsp = [0] * n
            for i in range(1, n):
                j = i - 1
                while j > 0 and s[i] != s[lsp[j]]:
                    j = lsp[j] - 1
                if s[i] == s[lsp[j]]:
                    lsp[i] = lsp[j] + 1
            return lsp
        
        n = len(word)
        
        lsp_list = lsp(word)
        
        l = lsp_list[-1]
        while l > 0 and (n - l) % k:
            l = lsp_list[l - 1]
        
        return ceil((n - l) / k)
```

</details>

<details>
<summary>Cpp</summary>

```cpp
in cpp :-

 vector<int> lsp(string s) 
    {
        int n = s.size();
        vector<int> lsp(n, 0);
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j > 0 && s[i] != s[lsp[j]]) {
                j = lsp[j] - 1;
            }
            if (s[i] == s[lsp[j]]) {
                lsp[i] = lsp[j] + 1;
            }
        }
        return lsp;
    }
 int minimumTimeToInitialState(string word, int k) 
    {
        vector<int> lsp = lsp(word);
        int n = word.size();
        int l = lsp[n - 1];
        while (l > 0 && (n - l) % k != 0) {
            l = lsp[l - 1];
        }
        return ceil((double) (n - l) / k);
    }
```

</details>

<details>
<summary>Java</summary>

```java
 
 private int[] lsp(String s) {
        int n = s.length();
        int[] lsp = new int[n];
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j > 0 && s.charAt(i) != s.charAt(lsp[j])) {
                j = lsp[j] - 1;
            }
            if (s.charAt(i) == s.charAt(lsp[j])) {
                lsp[i] = lsp[j] + 1;
            }
        }
        return lsp;
    }

 public int minimumTimeToInitialState(String word, int k) {
        int[] lsp = lsp(word);
        int n = word.length();
        int l = lsp[n - 1];
        while (l > 0 && (n - l) % k != 0) {
            l = lsp[l - 1];
        }
        return (int) Math.ceil((double) (n - l) / k);
    }
```

</details>