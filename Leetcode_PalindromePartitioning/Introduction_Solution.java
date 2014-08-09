package Leetcode_PalindromePartitioning;

public class Introduction_Solution {
/*
 * 最原始的思路，典型的DFS，终止条件+判断条件，其中判断条件是子字符串是不是palindrome。
一个改进版的思路，取代判断条件需要每次判断子字符串是否是palindrome, 转化成为一个DP的问题，用一个table来保存结果，因为在上面的原始思路中，有很多字符串需要被重复计算。
下面着重解释一下这个table：
table[ i ] [ j ] 的值代表字符串中从下标 i 到下标 j 的子串是否是 palindrome。 那么这个值可以由左下角的值推演而来，左下角的值是 table[ i+1 ][ j-1 ]。
很容易可以想到，如果 [ i+1 ][ j-1 ] 不是一个palindrome 那么 [ i ][ j ] 一定也不是。
很容易可以想到，如果 [ i+1 ][ j-1 ] 是一个palindrome 那么 [ i ][ j ] 相当于在这个子串上的左边附加了sring[ i ], 在右边附加上string[ j ], 那么新的子串是否相等就取决于这两个char是否相等。

推演的方法确定了，就要确定base case：
对角线上的值是奇数子串的base case， 一定是true。
对角线元素上（或右）的值是偶数子串的base case，取决于相邻两个字符是否相等。

 */
}
