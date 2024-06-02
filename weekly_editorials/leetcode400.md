## Minimum number of chairs in waiting room

<details>
<summary>Python</summary>

```python
# Python code
class Solution:
    def minimumChairs(self, s: str) -> int:
        cnt = 0
        ans = 0
        for c in s:
            if c == 'E':
                cnt += 1
            else:
                cnt -= 1
            ans = max(ans, cnt)
        return ans

```

</details>

<details>
<summary>Cpp</summary>

```cpp
   class Solution {
public:
    int minimumChairs(string s) {
        int cnt = 0, ans = 0;
        for (char c : s) {
            if (c == 'E') cnt++;
            else cnt--;
            ans = max(ans, cnt);
        }
        return ans;
    }
};

```

</details>

<details>
<summary>Java</summary>

```java
// Java code
class Solution {
    public int minimumChairs(String s) {
        int cnt = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                cnt++;
            } else {
                cnt--;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}


```

</details>

## Count days without meetings

<details>
<summary>Python</summary>

```python
class Solution:
    def countDays(self, days: int, a: List[List[int]]) -> int:
        n = len(a)
        a.sort()
        last = 0
        ans = 0
        for i in range(n):
            if a[i][0] > last + 1:
                ans += a[i][0] - last - 1
            last = max(last, a[i][1])
        if days > last:
            ans += days - last
        return ans


```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    int countDays(int days, vector<vector<int>>& a) {
        int n = a.size();
        sort(a.begin(), a.end());
        int last = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i][0] > last + 1) ans += a[i][0] - last - 1;
            last = max(last, a[i][1]);
        }
        if (days > last) ans += days - last;
        return ans;
    }
};


```

</details>

<details>
<summary>Java</summary>

```java
// Java code
import java.util.*;

class Solution {
    public int countDays(int days, List<List<Integer>> a) {
        int n = a.size();
        a.sort((x, y) -> Integer.compare(x.get(0), y.get(0)));
        int last = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a.get(i).get(0) > last + 1) {
                ans += a.get(i).get(0) - last - 1;
            }
            last = Math.max(last, a.get(i).get(1));
        }
        if (days > last) {
            ans += days - last;
        }
        return ans;
    }
}



```

</details>

## Lexicographically Minimum String After Removing Stars

<details>
<summary>Python</summary>

```python
class Solution:
    def clearStars(self, s: str) -> str:
        n = len(s)
        st = set()
        del_set = set()
        
        for i in range(n):
            if s[i] == '*':
                first = min(st)
                st.remove(first)
                del_set.add(-first[1])
                del_set.add(i)
            else:
                st.add((ord(s[i]) - ord('a'), -i))
        
        ans = ""
        for i in range(n):
            if i not in del_set:
                ans += s[i]
        return ans


```

</details>

<details>
<summary>Cpp</summary>

```cpp
class Solution {
public:
    string clearStars(string s) {
        int n = s.size();
        set<pair<int,int>> st;
        
        set<int> del;
        
        for (int i = 0; i < n; i++) {
            if (s[i] == '*') {
                auto first = *st.begin();
                st.erase(st.begin());
                del.insert(-first.second);
                del.insert(i);
            } else {
                st.insert({s[i] - 'a', -i});
            }
        }
        
        string ans = "";
        for (int i = 0; i < n; i++) if (!del.count(i)) ans += s[i];
        return ans;
    }
}; 



```

</details>

<details>
<summary>Java</summary>

```java
// Java code
import java.util.*;

class Solution {
    public String clearStars(String s) {
        int n = s.length();
        TreeSet<Pair> st = new TreeSet<>((a, b) -> {
            if (a.ch == b.ch) return Integer.compare(a.idx, b.idx);
            return Integer.compare(a.ch, b.ch);
        });
        Set<Integer> del = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                Pair first = st.first();
                st.remove(first);
                del.add(-first.idx);
                del.add(i);
            } else {
                st.add(new Pair(s.charAt(i) - 'a', -i));
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!del.contains(i)) {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
    
    static class Pair {
        int ch, idx;
        Pair(int ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }
}


```

</details>

## Find Subarray With Bitwise AND Closest to K

<details>
<summary>Python</summary>

```python
MX = (1 << 31) - 1

class Node:
    def __init__(self, val=MX):
        self.val = val
    
    @staticmethod
    def merge(l, r):
        return Node(l.val & r.val)
    
    def update(self, v):
        self.val = v

class SegmentTree:
    def __init__(self, a):
        self.n = len(a)
        self.seg = [Node() for _ in range(2 * self.n)]
        for i in range(self.n):
            self.seg[i + self.n] = Node(a[i])
        for i in range(self.n - 1, 0, -1):
            self.seg[i] = Node.merge(self.seg[i << 1], self.seg[i << 1 | 1])
    
    def update(self, i, v):
        i += self.n
        self.seg[i].update(v)
        i >>= 1
        while i > 0:
            self.seg[i] = Node.merge(self.seg[i << 1], self.seg[i << 1 | 1])
            i >>= 1
    
    def query(self, l, r):
        resl = Node()
        resr = Node()
        l += self.n
        r += self.n + 1
        while l < r:
            if l & 1:
                resl = Node.merge(resl, self.seg[l])
                l += 1
            if r & 1:
                r -= 1
                resr = Node.merge(self.seg[r], resr)
            l >>= 1
            r >>= 1
        return Node.merge(resl, resr)

class Solution:
    def minimumDifference(self, a, k):
        n = len(a)
        ans = 1e9 + 5
        sg = SegmentTree(a)
        
        def find(i):
            s, e = i, n - 1
            res = n
            while s <= e:
                m = (s + e) >> 1
                if sg.query(i, m).val <= k:
                    res = m
                    e = m - 1
                else:
                    s = m + 1
            return res
        
        for i in range(n):
            first = find(i)
            if first < n:
                ans = min(ans, abs(k - sg.query(i, first).val))
            if first > i:
                ans = min(ans, abs(k - sg.query(i, first - 1).val))
        
        return ans


```

</details>

<details>
<summary>Cpp</summary>

```cpp
const int MX = (1LL << 31) - 1;

struct Node {
    long long val;
    Node(): val(MX) {}
    Node(long long v): val(v) {}
    friend Node merge(Node l, Node r) { return Node(l.val & r.val); }
    void update(long long v) { val = v; }
};

struct SegmentTree {
    int n;
    vector<Node> seg;
    SegmentTree(int _n): n(_n), seg(2 * _n) {}
    template <typename Type>
    SegmentTree(vector<Type> a) {
        n = int(a.size());
        seg.resize(2 * n);
        for (int i = 0; i < n; i++) seg[i + n] = Node(a[i]);
        for (int i = n - 1; i > 0; i--) seg[i] = merge(seg[i << 1], seg[i << 1 | 1]);
    }
    void update(int i, long long v) {
        for (seg[i += n].update(v); i >>= 1; ) seg[i] = merge(seg[i << 1], seg[i << 1 | 1]);
    }
    Node query(int l, int r) {
        Node resl, resr;
        for (l += n, r += n + 1; l < r; l >>= 1, r >>= 1) {
            if (l & 1) resl = merge(resl, seg[l++]);
            if (r & 1) resr = merge(seg[--r], resr);
        }
        return merge(resl, resr);
    }
};

class Solution {
public:
    int minimumDifference(vector<int>& a, int k) {
        int n = a.size();
        long long ans = 1e9 + 5;
        SegmentTree sg(a);
        
        auto find = [&] (int i) {
            int s = i, e = n - 1, res = n;
            while (s <= e) {
                int m = (s + e) >> 1;
                if (sg.query(i, m).val <= k) res = m, e = m - 1;
                else s = m + 1;
            }
            return res;
        };
        
        for (int i = 0; i < n; i++) {
            int first = find(i);
            if (first < n) ans = min(ans, abs(k - sg.query(i, first).val));
            if (first > i) ans = min(ans, abs(k - sg.query(i, first - 1).val));
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

class Node {
    static final long MX = (1L << 31) - 1;
    long val;
    
    Node() {
        this.val = MX;
    }
    
    Node(long v) {
        this.val = v;
    }
    
    static Node merge(Node l, Node r) {
        return new Node(l.val & r.val);
    }
    
    void update(long v) {
        this.val = v;
    }
}

class SegmentTree {
    int n;
    Node[] seg;
    
    SegmentTree(int[] a) {
        n = a.length;
        seg = new Node[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            seg[i] = new Node();
        }
        for (int i = 0; i < n; i++) {
            seg[i + n] = new Node(a[i]);
        }
        for (int i = n - 1; i > 0; i--) {
            seg[i] = Node.merge(seg[i << 1], seg[i << 1 | 1]);
        }
    }
    
    void update(int i, long v) {
        seg[i += n].update(v);
        while (i > 1) {
            i >>= 1;
            seg[i] = Node.merge(seg[i << 1], seg[i << 1 | 1]);
        }
    }
    
    Node query(int l, int r) {
        Node resl = new Node();
        Node resr = new Node();
        for (l += n, r += n + 1; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) == 1) resl = Node.merge(resl, seg[l++]);
            if ((r & 1) == 1) resr = Node.merge(seg[--r], resr);
        }
        return Node.merge(resl, resr);
    }
}

class Solution {
    public int minimumDifference(int[] a, int k) {
        int n = a.length;
        long ans = (long)1e9 + 5;
        SegmentTree sg = new SegmentTree(a);
        
        for (int i = 0; i < n; i++) {
            int first = find(sg, i, n, k);
            if (first < n) ans = Math.min(ans, Math.abs(k - sg.query(i, first).val));
            if (first > i) ans = Math.min(ans, Math.abs(k - sg.query(i, first - 1).val));
        }
        
        return (int) ans;
    }
    
    private int find(SegmentTree sg, int i, int n, int k) {
        int s = i, e = n - 1, res = n;
        while (s <= e) {
            int m = (s + e) >> 1;
            if (sg.query(i, m).val <= k) {
                res = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return res;
    }
}

```

</details>

