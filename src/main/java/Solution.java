import java.util.Arrays;
import java.util.List;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int res = 0;
        int[][] ps = new int[nums.size() + 1][101];
        ps[0][nums.get(0)]++;
        for (int i = 1; i < nums.size(); i++) {
            ps[i] = Arrays.copyOf(ps[i - 1], 101);
            ps[i][nums.get(i)]++;
        }
        for (int i = 0; i < nums.size(); i++) {
            int[] ps1 = Arrays.copyOf(ps[i], 101);
            for (int j = 0; j <= i; j++) {
                int c = 0;
                for (int k = 1; k < 101; k++) {
                    if (ps1[k] != 0) {
                        c++;
                    }
                }
                res += c * c;
                ps1[nums.get(j)]--;
            }
        }
        return res;
    }

}

