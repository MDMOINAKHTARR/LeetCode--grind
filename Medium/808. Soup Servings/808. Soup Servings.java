import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Double> memo = new HashMap<>();

    public double soupServings(int n) {
        // If n is large enough, return 1.0 directly as the probability converges
        if (n >= 5000) return 1.0;

        // Convert to units of 25mL to reduce the problem space
        int N = (n + 24) / 25;

        return dfs(N, N);
    }

    private double dfs(int a, int b) {
        // Base cases
        if (a <= 0 && b <= 0) return 0.5;  // both empty at same time
        if (a <= 0) return 1.0;            // A is empty before B
        if (b <= 0) return 0.0;            // B is empty before A

        String key = a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);

        // Recursively calculate probability with 4 possible serving options
        double result = 0.25 * (
            dfs(a - 4, b) +         // 100ml A, 0ml B
            dfs(a - 3, b - 1) +     // 75ml A, 25ml B
            dfs(a - 2, b - 2) +     // 50ml A, 50ml B
            dfs(a - 1, b - 3)       // 25ml A, 75ml B
        );

        memo.put(key, result);
        return result;
    }
}
