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

## Question - 4

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
