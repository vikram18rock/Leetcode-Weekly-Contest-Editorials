class Solution:
    def beautifulIndices(self, s: str, a: str, b: str, k: int) -> List[int]:
        n = len(s)
        index_a = []
        self.lps = []
        self.KMPSearch(a, s, index_a)
        index_b = []
        self.KMPSearch(b, s, index_b)

        n1 = len(index_a)
        n2 = len(index_b)
        #print(index_a)
        #print(index_b)
        ans = []
        j = 0
        for i in range(n1):
            #print(i,j)
            while j < n2 and index_a[i] > index_b[j] and abs(index_a[i] - index_b[j]) > k:
                j += 1
            if j < n2 and abs(index_a[i] - index_b[j]) <= k:
                ans.append(index_a[i])
        return ans
