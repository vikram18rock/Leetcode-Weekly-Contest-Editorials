import java.util.ArrayList;
import java.util.List;

class Solution {
    private void substrPosition(String str, String sub_str, List<Integer> index) {
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + sub_str.length()).equals(sub_str)) {
                index.add(i);
            }
        }
    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n = s.length();
        List<Integer> indexa = new ArrayList<>();
        substrPosition(s, a, indexa);
        List<Integer> indexb = new ArrayList<>();
        substrPosition(s, b, indexb);
        int n1 = indexa.size();
        int n2 = indexb.size();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int sol = Math.abs(indexa.get(i) - indexb.get(j));
                if (sol <= k) {
                    ans.add(indexa.get(i));
                    break;
                }
            }
        }
        return ans;
    }
}

