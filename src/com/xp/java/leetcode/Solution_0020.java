package com.xp.java.leetcode;

import java.util.Stack;

/**
 * @类描述：Leetcode第20序号题 有效的括号  这其实是一个栈的题
 * 我们也可以用我们自己实现的栈 来解决这个问题
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/20 0020 11:43
 * @修改人：
 * @修改时间：2018/7/20 0020 11:43
 * @修改备注：
 */
public class Solution_0020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (top == '(' && c != ')')
                    return false;
                if (top == '{' && c != '}')
                    return false;
                if (top == '[' && c != ']')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
