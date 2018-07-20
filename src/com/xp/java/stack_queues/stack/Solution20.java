package com.xp.java.stack_queues.stack;

/**
 * @类描述：跟外面leetcode0020是一样的，只不过这里用自己的数组栈实现
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/20 0020 14:28
 * @修改人：
 * @修改时间：2018/7/20 0020 14:28
 * @修改备注：
 */
public class Solution20 {
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (top == '(' && c != ')') return false;
                if (top == '{' && c != '}') return false;
                if (top == '[' && c != ']') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution20().isValid("({[]})"));
        System.out.println(new Solution20().isValid("({]})"));
    }
}
