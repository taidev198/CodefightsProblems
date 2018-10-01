package com.taidev198.game.CodingInterview.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author traig on 7/20/2018.
 * @project Codefights
 */
public class DynamicProgramming {

    static int houseRobber(int[] nums){


        System.out.println(houseRobberHelper(nums, new ArrayList<>(), 0, 0 ,2));

        return 0;
    }

    static int houseRobberHelper(int[] nums, List<Integer> chosen, int money, int initPos, int jump){

        if(jump + initPos > nums.length){
          //  chosen.add(money);
            //houseRobberHelper(nums, chosen, money - nums[initPos], initPos);
            return money;
         //
        }
        if (initPos > nums.length -2)
            return money;

     return  houseRobberHelper(nums, chosen, money + nums[initPos ], initPos + jump, jump);

    }

    static int[] prefixSum(int[] arr){

        int n = arr.length;
        int[] p = new int[n +1];

        for (int i = 1; i < n+1; i++) {
            p[i] = p[i -1] + arr[i -1];
        }

        return p;

    }

    static int sumInRange(int[] nums, int[][] queries) {
        int count = 0;
        int n = nums.length;

        int[] p = new int[n +1];
        for (int i = 1; i < n+1; i++) {
            p[i] = p[i -1] + nums[i -1];
        }

        for(int i = 0 ; i< queries.length; i++){

                count += p[queries[i][1] + 1] - p[queries[i][0] ];

              count = (count % 1000000007 +  1000000007) % 1000000007;
        }


        return count ;

    }


    static int arrayMaxConsecutiveSum2(int[] inputArray) {

        int n = inputArray.length;


        int maxStartIndex =0, maxEndIndex = 0, maxSum = -1000000;

        int currentMaxSum = 0;
        int currentStartIndex = 1;
        for (int currentEndIndex = 1; currentEndIndex < n; currentEndIndex++){
            currentMaxSum += inputArray[currentEndIndex];
            if (currentMaxSum > maxSum){
                maxSum = currentMaxSum;
                maxStartIndex = currentStartIndex;
                maxEndIndex = currentEndIndex;
            }
            if (currentMaxSum < 0 ){
                currentMaxSum = 0;
                currentStartIndex = currentEndIndex+1;
            }
        }

        return maxSum;
    }

    public static void main(String...args){


      //  System.out.println(arrayMaxConsecutiveSum2(new int[]{-2,2,5,-11,6}));
    double result =(double)(300 + 200)/40 + 5;
    String temp = "5.0% lower than in-store";
        int index = temp.indexOf("%");
        String value = temp.substring(0, index);
    System.out.println((48 +48*20/100) - 48);
    }
}
