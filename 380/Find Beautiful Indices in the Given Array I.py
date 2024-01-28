class Solution:
    def substrPosition(self, str, sub_str, index):
        for i in range(len(str)):
            if str[i:i+len(sub_str)] == sub_str:
                index.append(i)
    
    def beautifulIndices(self, s, a, b, k):
        n = len(s)
        indexa = []
        self.substrPosition(s, a, indexa)
        indexb = []
        self.substrPosition(s, b, indexb)
        n1 = len(indexa)
        n2 = len(indexb)
        ans = []
        for i in range(n1):
            for j in range(n2):
                sol = abs(indexa[i] - indexb[j])
                if sol <= k:
                    ans.append(indexa[i])
                    break
        return ans

