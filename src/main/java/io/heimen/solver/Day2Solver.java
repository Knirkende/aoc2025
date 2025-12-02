package io.heimen.solver;

import io.heimen.listener.ParserListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Wow such javadoc
 */
public class Day2Solver {
    private static final Logger logger = LoggerFactory.getLogger(Day2Solver.class);
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
        for (var range : data.entrySet()) {
            for (long i = Long.parseLong(range.getKey()); i <= Long.parseLong(range.getValue()); i++) {
                var productId = String.valueOf(i);
                HashSet<String> xDigits = new HashSet<>();
                for (int chunk = 1; chunk < productId.length(); chunk++) {
                    if (!(productId.length() % chunk == 0)) continue;
                    xDigits.clear();
                    xDigits = new HashSet<>();
                    for (int start = 0; start + chunk <= productId.length(); start+=chunk) {
                        xDigits.add(productId.substring(start, start+chunk));
                        if (xDigits.size() > 1) break;
                    }
                    if (xDigits.size() == 1) {
                        res += i;
                        break;
                }
                }
            }
        }
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
