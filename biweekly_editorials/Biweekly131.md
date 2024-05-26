## Question - 1 :  Find the XOR of Numbers Which Appear Twice

<details>
<summary>Python</summary>

```python
class Solution:
    def duplicateNumbersXOR(self, nums: List[int]) -> int:
        d = defaultdict(int)
        ans = 0
        for i in range(len(nums)):
            d[nums[i]]+=1
            if d[nums[i]] == 2:
                ans^=nums[i]
        return ans
```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    int duplicateNumbersXOR(vector<int>& nums) {
        int d = 0;
        map<int, int> m;
        for (int i : nums) {
            m[i]++;
        }
        for (auto i : m) {
            if (i.second > 1)
                d = d ^ i.first;
        }

        return d;
    }
};
```

</details>

<details>
<summary>Java</summary>

```java
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int d = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() > 1) {
                d = d ^ entry.getKey();
            }
        }

        return d;
    }
```

</details>

## Question - 2 : Find Occurrences of an Element in an Array

<details>
<summary>Python</summary>

```python
class Solution:
    def occurrencesOfElement(self, nums: List[int], queries: List[int], x: int) -> List[int]:
        d = dict()
        cnt = 1
        for i in range(len(nums)):
            if nums[i] == x:
                d[cnt] = i
                cnt+=1
        ans = [0] * len(queries)
        for i in range(len(queries)):
            ans[i] = d.get(queries[i],-1)
        return ans
```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    vector<int> occurrencesOfElement(vector<int>& nums, vector<int>& queries, int x) {
        map<int, int> m;

        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == x) {
                count++;
                m[count] = i;
            }
        }

        vector<int> v;
        for (int i = 0; i < queries.size(); i++) {
            if (queries[i] > count) {
                v.push_back(-1);
            }
            else {
                v.push_back(m[queries[i]]);
            }
        }
        return v;
    }
};
```

</details>

<details>
<summary>Java</summary>

```java
class Solution {
    public List<Integer> occurrencesOfElement(List<Integer> nums, List<Integer> queries, int x) {
        Map<Integer, Integer> m = new HashMap<>();

        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == x) {
                count++;
                m.put(count, i);
            }
        }

        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            if (queries.get(i) > count) {
                v.add(-1);
            } else {
                v.add(m.get(queries.get(i)));
            }
        }
        return v;
    }
```

</details>

## Question - 3

<details>
<summary>Python</summary>

```python

```

</details>

<details>
<summary>Cpp</summary>

```cpp

```

</details>

<details>
<summary>Java</summary>

```java

```

</details>

