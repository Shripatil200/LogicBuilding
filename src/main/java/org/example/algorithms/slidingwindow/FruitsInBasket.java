package org.example.algorithms.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
904. Fruit Into Baskets
Medium

https://leetcode.com/problems/fruit-into-baskets/description/

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.
 */
public class FruitsInBasket {

    public static int totalFruits(int[] fruits){
        int maxFruits = 0;
        int windowStart = 0;
        Map<Integer, Integer> selectedTrees = new HashMap<>();

        for(int windowEnd = 0; windowEnd < fruits.length; windowEnd++){
            int tree = fruits[windowEnd];
            selectedTrees.put(tree, selectedTrees.getOrDefault(tree, 0)+ 1);

            while(selectedTrees.size() > 2){
                int currentTree = fruits[windowStart];
                selectedTrees.put(currentTree, selectedTrees.get(currentTree) - 1);

                if(selectedTrees.get(currentTree) == 0){
                    selectedTrees.remove(currentTree);
                }

                windowStart++;
            }
            maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2};
        System.out.println("Total Fruits: "+FruitsInBasket.totalFruits(arr));
    }
}
