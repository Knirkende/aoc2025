package io.heimen.solver;

import java.util.Map;

/**
 * Wow such javadoc
 */
public class Day2Solver {

    public long solve(Map<String, String> data) {

        var res = 0L;
        for (var range : data.entrySet()) {
            for (long i = Long.parseLong(range.getKey()); i <= Long.parseLong(range.getValue()); i++) {
                var productId = String.valueOf(i);
                if (isSymmetric(productId)) {
                    res += i;
                }
            }
        }
        return res;
    }

    public long solvePartTwo(Map<String, String> data) {
        var res = 0L;
        return res;
    }

    private boolean isSymmetric(String productId) {
        if (productId.length() == 1) {
            return false;
        }
        if (productId.length() % 2 == 0) {
            var left = productId.substring(0, productId.length() / 2);
            var right = productId.substring(productId.length() / 2);
            return left.equals(right);
        }
        return false;
    }

}
