/**
 * 
 */
/**
 * @author Fei
 *Analysis:

Possible input cases:

1. "", empty string

2. "123", simple valid string

3. "+123", valid string with '+' sign

4. "-123", valid string with '-' sign

5. " 123abc ", string with space and other characters

6. "abc123", invalid input string

7. "33333333333333", "-3333333333333", invalid overflow string

According to those given cases, we should follow the steps listed below:

1. check whether the string is empty, define what to return if the string is empty; if it's empty, return directly

2. trim the spaces of the string both at the head and the end

3. judge whether the first character is '+' or '-', by default no either of them are positive num

4. start from the first position, continue convert until meeting the end of the string or a non-numeric character

5. judge whether the result overflows, if overflow, return the MAX_VALUE or MIN_VALUE, else return the result
 */
package Leetcode_atoi;