package com.xp.java.datastructures.linked;


/**
 * @类描述：跟外面leetcode0020是一样的，只不过这里用自己的链表栈实现 如果我们要用自己代码去提交leetcode 那么需要将 所有的代码实现都贴进去  不然leetcode找不到具体类
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/20 0020 14:28
 * @修改人：
 * @修改时间：2018/7/20 0020 14:28
 * @修改备注：
 */
public class Solution20 {
    public boolean isValid(String s) {
        LinkedListStack<Character> stack = new LinkedListStack<>();
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
