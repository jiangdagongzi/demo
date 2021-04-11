package com.tao.jiang.demo.utils;

public class BucketSort {
    private static void sort(int[] k){
        //题目限定所有的元素都在0-9范围内
        int[] bucket= new int[10];
        for(int num : k){
            bucket[num] += 1;
        }
        int step = 0;
        //遍历10个桶
        for(int i = 0;i < 10;i ++){
            for(int j = 0; j < bucket[i];j ++){
                k[step] = i;
                step +=1;
            }
        }

    }

    public static void main(String[] args){
        int[] k = new int[]{0,1,0,4,8,2};
        BucketSort.sort(k);
        for(int num: k){
            System.out.println(num);
        }
    }
}
