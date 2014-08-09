/**
 * 
 */
/**
 * @author Fei
 * Solution:
 
 remember that  a line can be represented by y=kx+d, if p1 and p2 are in same line, then y1=x1k+d, 
 y2=kx2+d, so y2-y1=kx2-kx1, so k=(y2-y1)/(x2-x1), then we can apply this formular to check 
 if two points are in same line, however how to handle the duplicate points problem?
 So instead to calculate the line with maximum points , we should calculate
 longest line(maximum ponts) through same point, 
 */
package Leetcode_maxPoints;