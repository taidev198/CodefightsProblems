package com.taidev198.game;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
       // System.out.println(arithmeticExpression(8,3,2));
       // int[] a = metroCard(28);

        int t,x,y,n;

      //  Scanner in = new Scanner(System.in);
      //  t = in.nextInt();
//        for (int i = 0 ; i < t ;i++){
//            n = in.nextInt();
//            x = in.nextInt();
//            y = in.nextInt();
//            for (int j = 1; ; j++) {
//
//                System.out.print(x * j +" ");
//                if (x * j > n)
//                    break;
//            }
//        }

     //   int[][] xxx = new int[t][];
     //   xxx[0][0] = 2;

      //  System.out.print(xxx[0][0]);
//        for (int i = 0; i < xxx.length ; i++) {
//            for (int j = 0; j < xxx.length; j++) {
//
//
//        }
     //   System.out.println(almostIncreasingSequence(new int[]{10,1,2,3,4,5}));


        //int m = countSumOfTwoRepresentations2(24,8,16);
        //System.out.println(m);

       // System.out.println(firstDuplicate(new int[]{8, 4, 6, 2, 6, 4, 7, 9, 5, 8}));


       // System.out.println(sumOfTwo(new int[]{1,2,3},new int[]{10,20,30,40},42));


  System.out.print(rounders(1234));
    }

    static int rounders(int n){
        if (n / 10  == 0)
            return n;
        if (n % 10 < 5)
            n -= n %10;
        else n += (10 - n %10) *10;
       return rounders(n /10);
    }
    static  int lateRide(int n) {

        int hours = n / 60;
        int minutes = n - hours*60;

        int x1 = hours /10;
        int y1 = hours - x1*10;
        int x2 = minutes /10;
        int y2 = minutes - x2 * 10;
        System.out.println(x1 +" ," + y1 + "," + x2 + " ," + y2);
        return x1 + y1 + x2 + y2;

    }

    static  int phoneCall(int min1, int min2_10, int min11, int s) {

        if (min1 == s)
            return 1;
        else if (min1 > s)
            return  0;
        int Min2_10;
        int Min11 = 0;
        int cosForMin2_10 = 9 * min2_10;
        if (cosForMin2_10 < s - min1){
            Min2_10 = 9;
            Min11= (s - cosForMin2_10 - min1 )/min11;
        }

        else {
            Min2_10 = (s - min1)/min2_10;
        }
        return 1 + Min2_10 + Min11;
    }

    static  int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {

        int totalW = weight1 + weight2;
        if (totalW <= maxW)
            return value1 + value2;
        else {
            int maxWOfTwoItems = Math.max(weight1,weight2);
            if (weight1 < maxW && weight2 == maxW)
                return value1;
            else if (weight2 < maxW && weight1 == maxW)
                return value2;
            else if (weight1 == maxW && weight2 > maxW)
                return value1;
            else if (weight2 == maxW && weight1   > maxW)
                return value2;
            else  if (weight1 > maxW && weight2 > maxW)
                return 0;
            return Math.max(value1,value2);
        }
    }

    static  boolean arithmeticExpression(int a, int b, int c) {

        float result = (float)a / b;
        System.out.println(result);
        if(a + b == c)
            return true;
        if(a * b == c)
            return true;
        if( result == (float)c)
            return true;
        if(a - b == c)
            return true;
        return false;

    }

    static int[] metroCard(int lastNumberOfDays) {

        switch(lastNumberOfDays){
            case 28: int b[] = {31};
            return b;
            case 30:  int a[] = {31};
            return a;
            case 31:
            int a1[] = {28,30};
            return a1;
            default: return null;
        }

    }

    static boolean almostIncreasingSequence(int[] sequence) {

        int n = sequence.length;
        int count = 0;
        for(int i = 0; i < n -1; i++){
            for(int j = i+1; j< n; j++){
                if(sequence[j] <= sequence[i])
                    count++;
                //System.out.println(count);

            }
        }
        return count < 2;
    }


    static int countSumOfTwoRepresentations2(int n, int l, int r) {

        int count = 0;
        int length = r  - l+1;
        int[] arr = new int[length];
        int j = 0;
        for(int i = l ; i <= r; i++){
            arr[j ++] = i;
        }
        for(int i = l ; i <= r; i++){
            if(isFound(l,r,i,n))
                count ++;
        }
        return count;

    }

    static boolean isFound(int l, int r, int value, int target){
        if (l > r)
            return false;
        if (value + l ==  target)
            return true;
        System.out.println(target - l);
        return isFound(( target - value), r, value, target);
    }

    static boolean binarySearch(int[] arr, int n, int l, int r, int value){

        while(l < r){

            int mid = (l + r) /2;

            if(value + arr[mid] == n)
                return true;
            if(value + arr[mid] < n)
                return binarySearch( arr, n , mid + 1, r, value);
            else return binarySearch( arr, n , l, mid - 1, value);

        }
        return false;

    }

   static int firstDuplicate(int[] a) {

        int n = a.length;
        int[] ints;
        List<Integer> min  = new ArrayList<>();
        int minIndex = n -1;
        int idx = 0;
        for (int i = 0; i <= n/2 ; i++) {
            int value = a[i];

            ints = Arrays.copyOfRange(a, i+1,n );
            int find = findIndex(ints, value);
            if (find != -1){
                min.add(find);
                System.out.println("value:" + a[i] + ",index:" + find+",i:"+i);
                if ((find + i) < minIndex){
                    minIndex = find + i;
                    idx = i;
                    System.out.println("i:" +idx +",minIndex:" + minIndex);
                }
            }
        }

        if (min.size() == 0)
            return -1;
        return a[idx];


    }
    static int findIndex(int[] arr, int value){

        return Arrays.stream(arr).boxed().collect(Collectors.toList()).indexOf(value) ;
    }


   static boolean sumOfTwo(int[] a, int[] b, int v) {
        Arrays.sort(a);
        Arrays.sort(b);
        int mid = a.length / 2;
        if (a[mid] > v)
            if (foundNdNumber(0, mid ,a,b,v))
                return true;
        else {
                return foundNdNumber(mid, a.length, a, b, v);
            }

        return false;
    }

    static boolean foundNdNumber(int left, int right, int[] a, int[] b, int v){

        for( int i = left ; i < right ; i++ ){
            if (binarySearch(b,0,b.length-1,v-a[i]))
                return true;
        }
        return false;

    }

    static boolean binarySearch(int[] arr, int left, int right, int value){
        if (left == right)
            return false;
        else {
            int mid = (left + right) / 2;

            if (arr[mid] == value)
                return true;
            else if (arr[mid] < value)
                return binarySearch(arr, left, mid -1, value);
            else return binarySearch(arr, mid + 1, right, value);
        }
    }


}
