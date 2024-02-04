import java.util.*;

public class Solution {
    public long findMaximumNumber(long k, int x) {
        long l = 1, r = 1e15*64;
        
        while (l < r) {
            long m = (l+r) >> 1;
            
            if (SumOfPrices(m+1, x) <= k) l = m+1;
            else r = m;
        }
        return l;
    }

    public long SumOfPrices (long n, int x) {
        List<Long> cnt_bits = SetBitsCount (n);
        
        long result = 0;
        for (int i = 63; i >= 0; i --)
            if ((i+1) % x == 0) result += cnt_bits.get(i);
        
        return result;
    }

    public List<Long> SetBitsCount (long x) {
        int highest_bit = 63;
        while (highest_bit >= 0 && !IsSet(highest_bit, x)) highest_bit --;
        
        List<Long> cnt = new ArrayList<>(Collections.nCopies(64, 0L));
        
        for (int i = highest_bit; i >= 0;) {
            x -= (1L << i);
            cnt.set(i, cnt.get(i) + x+1);
            
            for (int j = i-1; j >= 0; j --)
                cnt.set(j, cnt.get(j) + (1L << i)/2);
            
            i --;
            while (i >= 0 && !IsSet(i, x)) i--;
        }
        
        return cnt;
    }

    public boolean IsSet (int bit, long x) {
        return ((x & (1L << bit)) > 0);
    }
}
