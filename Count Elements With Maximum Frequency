class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        //create hash table
        int hash[101]={0};
        int n=nums.size();
        //store counts of elements in hash table
        for(int i=0;i<n;i++)
        {
            hash[nums[i]]++;
        }
        //max frequency of hash table
        int maxi=*max_element(hash,hash+101);
        int ans=0;
        //addition of maxi frequency
        for(int i=0;i<101;i++)
        {
            if(hash[i]==maxi)
            {
                ans=ans+hash[i];
            }
        }
        return ans;
    }
};
