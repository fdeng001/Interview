/**
 * 
 */
/**
 * @author Fei
 * Solution: �ж� ')' �����, ͦ�鷳��һ���⣬����corner�Ƚ϶ֻ࣬��Ҫѭ��һ�� O(n).
 * ����Ŀ�鷳�ĵط�����������')'ʱ������жϺϷ�����. ������stack ��indexֵ���ܹؼ�
 * 1. stack isEmpty --> ��ǰ ')' �޺Ϸ�����, ����start, ֻ��inValid�Ÿ���start
 * 2. stack !isEmpty, pop()
 * 		* isEmpty like (), (() ) --> length = index-start+1 
 * 		* !isEmpty like (() --> length = index-stack.peek();  ����Ͳ�����start �����
 */
package Leetcode_longestValidParentheses;