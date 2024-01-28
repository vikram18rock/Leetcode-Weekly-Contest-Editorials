class Solution {
    private:
    //used O(N^2) method to find indices. I'll use KMP in 4th question
    void substrPosition(string str, string sub_str,vector<int>&index) 
        {
            for (int i = 0; i < str.length(); i++) 
            {
                if (str.substr(i, sub_str.length()) == sub_str) 
                {
                    index.push_back(i);
                }
            }
        }
public:
    vector<int> beautifulIndices(string s, string a, string b, int k) {
        int n=s.length();
        vector<int>indexa;
        substrPosition(s,a,indexa);
        vector<int>indexb;
        substrPosition(s,b,indexb);

        int n1=indexa.size();
        int n2=indexb.size();
 
        vector<int>ans;
            //store absolute difference of indices which is greater less than equal to k
            //this can further optimise which i will show in 4th question
            for(int i=0;i<n1;i++)
            {
                for(int j=0;j<n2;j++)
                {
                    int sol=abs(indexa[i]-indexb[j]);
                    if(sol<=k)
                    {
                        ans.push_back(indexa[i]);
                        break;
                    }
                }
            }
        return ans;
        
    }
};
