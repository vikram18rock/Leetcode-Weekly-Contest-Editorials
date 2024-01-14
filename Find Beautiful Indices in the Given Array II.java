```Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public ArrayList<Integer> beautifulIndices(String s, String a, String b, int k) {
        ArrayList<Integer> indicesA = new ArrayList<>();
        ArrayList<Integer> indicesB = new ArrayList<>();

        int n = s.length();
        int m = a.length();
        int p = b.length();

        int[] lpsA = new int[m];
        int[] lpsB = new int[p];

        computeLPSArray(a, m, lpsA);
        computeLPSArray(b, p, lpsB);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (a.charAt(j) == s.charAt(i)) {
                j++;
                i++;
            }

            if (j == m) {
                indicesA.add(i - j);
                j = lpsA[j - 1];
            } else if (i < n && a.charAt(j) != s.charAt(i)) {
                if (j != 0)
                    j = lpsA[j - 1];
                else
                    i++;
            }
        }

        i = 0;
        j = 0;

        while (i < n) {
            if (b.charAt(j) == s.charAt(i)) {
                j++;
                i++;
            }

            if (j == p) {
                indicesB.add(i - j);
                j = lpsB[j - 1];
            } else if (i < n && b.charAt(j) != s.charAt(i)) {
                if (j != 0)
                    j = lpsB[j - 1];
                else
                    i++;
            }
        }

        Collections.sort(indicesA);
        Collections.sort(indicesB);

        int indexA = 0;
        int indexB = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (indexA < indicesA.size() && indexB < indicesB.size()) {
            if (Math.abs(indicesA.get(indexA) - indicesB.get(indexB)) <= k) {
                result.add(indicesA.get(indexA));
