//# You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
//        #
//        # You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
//        #
//        # You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
//        # Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
//        # Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
//        # Given the integer array fruits, return the maximum number of fruits you can pick.
//        #
//        # Example:
//        # Input: fruits = [3,3,3,1,2,1,1,2,3,3,4]
//        # Output: 5
//        # Explanation: We can pick from trees [1,2,1,1,2].
//

package com.tao.jiang.demo.utils.afterPay;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        int[] trees = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int[] trees1 = new int[]{3, 3, 3};
        int[] trees2 = new int[]{3, 3, 3, 1, 1};
        int[] trees3 = new int[]{1};
        System.out.println(pick(trees3));
    }

    public static int pick(int[] trees) {
        if (trees.length <= 2)
            return trees.length;
        int i = 0;
        int result = 0;
        while (result > trees.length -i ) {
            int j = i;
            HashSet set = new HashSet<>();
            while (j < trees.length) {
                set.add(trees[j]);
                if (set.size() > 2) {
                    result = Math.max(result, (j - i));
                    break;
                } else {
                    j++;
                }
            }
            if (set.size() <= 2)
                result = Math.max(result, (j - i));
            i = findN(trees, i, j);
        }
        return result;
    }

    public static int findN(int[] trees, int curI, int curJ) {
        for (int tmp = curI; tmp < curJ; tmp++) {
            if (trees[tmp] != trees[curI])
                return tmp;
        }
        return curJ;
    }

}
