class Solution {
private:
void KMPSearch(string pat, string txt,vector<int>&index)
{
    int M = pat.length();
    int N = txt.length();
 
    // create lps[] that will hold the longest prefix suffix
    // values for pattern
    int lps[M];
 
    // Preprocess the pattern (calculate lps[] array)
    computeLPSArray(pat, M, lps);
 
    int i = 0; // index for txt[]
    int j = 0; // index for pat[]
    while ((N - i) >= (M - j)) {
        if (pat[j] == txt[i]) {
            j++;
            i++;
        }
 
        if (j == M) {
            index.push_back(i - j);
            j = lps[j - 1];
        }
 
        // mismatch after j matches
        else if (i < N && pat[j] != txt[i]) {
            // Do not match lps[0..lps[j-1]] characters,
            // they will match anyway
            if (j != 0)
                j = lps[j - 1];
            else
                i = i + 1;
        }
    }
}
 
// Fills lps[] for given pattern pat[0..M-1]
void computeLPSArray(string pat, int M, int lps[])
{
    // length of the previous longest prefix suffix
    int len = 0;
 
    lps[0] = 0; // lps[0] is always 0
 
    // the loop calculates lps[i] for i = 1 to M-1
    int i = 1;
    while (i < M) {
        if (pat[i] == pat[len]) {
            len++;
            lps[i] = len;
            i++;
        }
        else // (pat[i] != pat[len])
        {
            // This is tricky. Consider the example.
            // AAACAAAA and i = 7. The idea is similar
            // to search step.
            if (len != 0) {
                len = lps[len - 1];
 
                // Also, note that we do not increment
                // i here
            }
            else // if (len == 0)
            {
                lps[i] = 0;
                i++;
            }
        }
    }
}
public:
    vector<int> beautifulIndices(string s, string a, string b, int k) {
        int n=s.length();
        vector<int>indexa;
        KMPSearch(a,s,indexa);
        vector<int>indexb;
        KMPSearch(b,s,indexb);

        int n1=indexa.size();
        int n2=indexb.size();
        for(int i=0;i<n1;i++)
        {
            cout<<indexa[i]<<" ";
        }
        cout<<endl;
        for(int i=0;i<n2;i++)
        {
            cout<<indexb[i]<<" ";
        }
        cout<<endl;
        vector<int>ans;
        int j=0;
        for(int i=0;i<n1;i++)
        {
            //now both indexa and indexb is sorted, so if difference is greater than k then if u will increase index of indexa vector then difference is also increase.
            //that's why we increase index of indexb vector so that difference will decrease and comes under K.
            while(j<n2&&indexa[i]>indexb[j]&&abs(indexa[i]-indexb[j])>k)
            {
                j++;
            }
            if(j<n2&&abs(indexa[i]-indexb[j])<=k)
            {
                ans.push_back(indexa[i]);
            }
        }
        return ans;
        
    }
};
