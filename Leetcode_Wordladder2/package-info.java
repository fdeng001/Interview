/**
 * 
 */
/**
 * @author Fei
 * 思路：visited 是用hashmap来存储经过的路径path，注意这里path是hashset，所以顺序还是需要稍后的traceback 方法来找到。
            level是用hashmap存储到start的距离，跟Word ladder里的ladderMap是一样的。
           queue是实现BST
           1. 其中有两个情况是要把string加入hashset的，第一种情况是string在dict里面，但是不在level里面，第二种情况是string在dict里面，也在level里面，但是到start的距离更小。
2. 在traceback过程中不要怕占用空间，敞开用。不然java不容易过
 */
package Leetcode_Wordladder2;