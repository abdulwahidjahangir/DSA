package StackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, 0, 0, ans, new StringBuilder());
        return ans;
    }

    public void helper(int n, int openN, int closeN, List<String> ans, StringBuilder curr) {
        if (openN == n && closeN == n) {
            ans.add(new String(curr.toString()));
            return;
        }

        if (openN < n) {
            curr.append('(');
            helper(n, openN + 1, closeN, ans, curr);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (openN > closeN) {
            curr.append(')');
            helper(n, openN, closeN + 1, ans, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
