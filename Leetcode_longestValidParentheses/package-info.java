/**
 * 
 */
/**
 * @author Fei
 * Solution: 判断 ')' 的情况, 挺麻烦的一道题，考虑corner比较多，只需要循环一边 O(n).
 * 这题目麻烦的地方在于在碰到')'时候如何判断合法序列. 另外用stack 存index值，很关键
 * 1. stack isEmpty --> 当前 ')' 无合法序列, 更新start, 只有inValid才更新start
 * 2. stack !isEmpty, pop()
 * 		* isEmpty like (), (() ) --> length = index-start+1 
 * 		* !isEmpty like (() --> length = index-stack.peek();  这里就不能用start 标记了
 */
package Leetcode_longestValidParentheses;