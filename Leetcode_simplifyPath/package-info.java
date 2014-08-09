/**
 * 
 */
/**
 * @author Fei
 * 1. 等于“/”，跳过，直接开始寻找下一个element
 * 2. 等于“.”，什么都不需要干，直接开始寻找下一个element
 * 3. 等于“..”，弹出栈顶元素，寻找下一个element
 * 4. 等于其他，插入当前elemnt为新的栈顶，寻找下一个element
 */
package Leetcode_simplifyPath;