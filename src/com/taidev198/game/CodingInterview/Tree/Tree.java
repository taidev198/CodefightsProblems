package com.taidev198.game.CodingInterview.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author traig on 7/17/2018.
 * @project Codefights
 */
public class Tree<T> {


   private Tree(T x) {
     value = x;
   }
   private T value;
   private Tree<T> left;
   private Tree<T> right;

    static boolean hasPathWithGivenSum(Tree<Integer> t, int s) {

//
//        if (t.left != null && t.right != null){
//           // System.out.println("s of right:"+ (s  - t.value ));
//            System.out.println("right:" + t.value);
//             hasPathWithGivenSum(t.right, s - t.value);
//        }
//        else if (t.left != null){
//            System.out.println("left:" + t.value);
//      //      System.out.println("s of left:"+ (s  - t.value ));
//              hasPathWithGivenSum(t.left, s - t.value);
//        }
//        System.out.println("leaf:" + t.value);
//           return s - t.value == 0;
        if (t.left == null && t.right == null){
            System.out.println("left:" + t.value);
            return s - t.value == 0;

        }

        //if (t.right != null && t.left != null){
            System.out.println("s:" + s);


      //  }
        if (t.right != null){
            System.out.println("right:" + t.value);
            hasPathWithGivenSum(t.right, s -t.value);
        }

        if (t.left != null){
            System.out.println("left:" + t.value);
            hasPathWithGivenSum(t.left, s - t.value);
        }

        return  false;

    }

  static boolean travel(Tree<Integer> root, int s){
        List<Boolean> chosen = new ArrayList<>();

        hasPathWithGivenSumHelper(root, s, chosen);

        return chosen.indexOf(true) != -1;
    }

    static void hasPathWithGivenSumHelper(Tree<Integer> root, int s, List<Boolean> chosen){
        if(root != null) {
           hasPathWithGivenSumHelper(root.right, s - root.value, chosen);
           hasPathWithGivenSumHelper(root.left, s - root.value, chosen);
           if (root.left == null && root.right == null && s - root.value == 0) {
                   chosen.add(true);
           }
        }
    }



    /**https://app.codesignal.com/interview-practice/task/jAKLMWLu8ynBhYsv6/description*/
    static int kthSmallestInBST(Tree<Integer> t, int k) {
        List<Integer> ans = new ArrayList<>();

        inOrderBST(t, ans);
        return ans.get(k-1);
    }

    static void inOrderBST(Tree<Integer> root, List<Integer> list){
        if(root!= null){

            inOrderBST(root.left, list);
            list.add(root.value);
            inOrderBST(root.right, list);
        }

    }

    public static void main(String... args){
        Tree<Integer> t = new Tree<>(4);
        t.left = new Tree<>(1);
        t.left.left = new Tree<>(-2);
        t.left.left.right = new Tree<>(4);

        t.right = new Tree<>(3);
        t.right.left = new Tree<>(1);
        t.right.right = new Tree<>(2);
        t.right.right.left = new Tree<>(-2);
        t.right.right.right = new Tree<>(-3);
        System.out.println(travel(t, 7));


    }
}
