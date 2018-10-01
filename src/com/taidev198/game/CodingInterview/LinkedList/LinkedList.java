package com.taidev198.game.CodingInterview.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author traig on 7/12/2018.
 * @project Codefights
 */
public class LinkedList {


    // Definition for singly-linked list:

        static class ListNode<T> {
        ListNode(T x) {
          value = x;
        }
        T value;
        ListNode<T> next;
 }

    static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {

        long NumberA = 0;
        long NumberB = 0;
        while(a != null){
            NumberA = NumberA *10000 + a.value;
            a = a.next;
        }

        while(b != null){
            NumberB = NumberB *10000 + b.value;
            b = b.next;
        }

        Stack<Integer> result = new Stack<Integer>();
        long convertToStack = NumberA + NumberB;
        System.out.println(NumberB);
        String strTemp = Long.toString((convertToStack));
        int count = strTemp.length() /4;
        while (count != 0){

            int num = Integer.valueOf(strTemp.substring(strTemp.length()-4,strTemp.length()));
            strTemp = strTemp.substring(0,strTemp.length()-4);
            result.push(num);
           count--;
        }
        if (strTemp.length() > 0)
        result.push(Integer.valueOf(strTemp));
        ListNode<Integer> temp = new ListNode<>(result.pop());
        ListNode<Integer> list = temp;
        while (!result.isEmpty()){
            list.next = new ListNode<>(result.pop());
            list = list.next;
        }
        return temp;

    }

    static ListNode<Integer> oddNodesFollowedEvenNode(ListNode<Integer> head){
            if (head == null || head.next == null)
                return head;
            ListNode<Integer> result = head;
            ListNode<Integer> p1 = head;
            ListNode<Integer> p2 = head.next;
            ListNode<Integer> connectNode = head.next;

            while (p1 != null && p2 != null){
                ListNode<Integer> t = p2.next;
                if (t == null)
                    break;
                p1.next = p2.next;
                p1 = p1.next;

                p2.next = p1.next;
                p2 = p2.next;
            }

            p1.next = connectNode;

        return result;
    }

    static <T> ListNode<T> reverseList(ListNode<T> head){
            if (head == null || head.next == null)
                return head;
            ListNode<T> reverseList = null;
            while (head != null){
                ListNode<T> node = new ListNode<>( head.value);
                reverseList = addFirst(reverseList, node);
                head = head.next;
            }
        return reverseList;
    }

    private static <T>  ListNode<T> addFirst(ListNode<T> head, ListNode<T> node){
            ListNode<T> newestNode = new ListNode<>(node.value);
            if (head == null)
                head = newestNode;
            else {
                newestNode.next = head;
                head = newestNode;
            }
            return head;
    }

    static <T> ListNode<T> reverseList2(ListNode<T> head){

            if (head == null || head.next == null)
                return head;
            ListNode<T> p1 = head;
            ListNode<T> p2 = p1.next;
            head.next = null;//break linking between p1 and p2
            while (p2 != null && p1 != null){
                ListNode<T> temp = p2.next;//
                p2.next = p1;//the next of node p2 point to p1
                p1 = p2;//p2 assign to p1
                p2 = temp;//temp assign to p2
            }
            //p1 is head of list.
            return p1;

    }

    public static <T> ListNode<T> reverseList3(ListNode<T> head){

            if (head == null || head.next == null)
                return head;

            //get second node
        ListNode<T> second = head.next;
        //set second node to null
        head.next = null;

        ListNode<T> rest = reverseList3(second);
        second.next = head;
        return rest;
    }

    static String[] taskMaker(String[] source, int challengeId) {
        List<String> result = new ArrayList<>();
        String temp;
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < source.length; i++) {
            if (source[i].contains("//DB") && !flag){
                flag = true;
                index = i;
                result.remove(i);
            }
            else if (source[i].contains("//DB "+ challengeId)){
                temp = source[i].substring(7,source[i].length());
              //  System.out.println(temp);
                result.remove(index);
                result.remove(index-1);
                result.add(temp);
            }else result.add(source[i]);
        }
        String[] answer = new String[result.size()];
        for (int i = 0; i <result.size() ; i++) {
            answer[i] = result.get(i);

        }
        return answer;
    }


   static boolean launchSequenceChecker(String[] systemNames, int[] stepNumbers) {

        int n = systemNames.length;
        int i= 0;
        while (i < n -1){
            int j = i;
            String temp = systemNames[i];
            int k = n -1;
            while(j < k){
                if(!systemNames[k].equals(temp))
                    k--;
                else{
                    if(stepNumbers[j] >= stepNumbers[k])
                        return false;
                    j++;
                }
            }
            i++;
        }
        return true;
    }

    static  ListNode<Integer> swapTwoAdjacentNode(ListNode<Integer> head){
            if (head.next == null)
                return head;

            ListNode<Integer> p1 = head;
            ListNode<Integer> preNode = p1;
            ListNode<Integer> p2 = p1.next;
            ListNode<Integer> temp ;

            while (p2 !=  null){
                temp = p2.next;
                preNode.next = p2;
                p1.next = temp;
                p2.next = p1;
                if (p1 == head)
                    head = p2;
                preNode = p1;
                p1 = p1.next;
                if (p1 == null)
                    break;
                p2 = p1.next;

            }

            return head;
    }


    static  ListNode<Integer> swapTwoAdjacentNode1(ListNode<Integer> head){

        if(head == null || head.next == null)
            return head;

        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;

        while(p.next != null && p.next.next != null){
            //use t1 to track first node
            ListNode t1 = p;
            p = p.next;
            t1.next = p.next;

            //use t2 to track next node of the pair
            ListNode t2 = p.next.next;
            p.next.next = p;
            p.next = t2;
        }

        return h.next;
    }

    static  ListNode<Integer> mergedTwoSortedList(ListNode<Integer> temp1, ListNode<Integer> temp2){
            ListNode<Integer> answer = null;
            ListNode<Integer> curNode = null;

            while (temp1 != null && temp2 != null){
                if (temp1.value >= temp2.value){
                 if (answer == null )
                        answer = curNode = temp2;
                 else{
                     curNode.next = temp2;
                     curNode = temp2;
                 }
                 temp2 = temp2.next;
                }else {
                    if (answer == null )
                        answer = curNode = temp1;
                    else{
                        curNode.next = temp1;
                        curNode = temp1;
                    }
                    temp1 = temp1.next;
                }
            }

            while(temp1 != null){
                curNode.next = temp1;
                curNode = temp1;
                temp1 = temp1.next;
            }
            while(temp2 != null){
                curNode.next = temp2;
                curNode = temp2;
                temp2 = temp2.next;
            }
            return answer;
    }

    static <T> ListNode<T> reOrderList(ListNode<T> head){

            if (head == null || head.next == null)
                return head;
            ListNode<T> pre = head;
            ListNode<T> cur = head;
            while (cur.next != null){
                pre = cur;
                cur = cur.next;
            }

            pre.next = head;
            cur.next = head;
            cur.next = head.next;
            head.next = null;
            head = cur;
            return head;
    }

    static void removeKthFromLast(ListNode<Integer> head, int k){
            if (head != null)
                removeKthFromLast(head.next, k);
            k --;


    }

    public static void main(String...args){

//    ListNode<Integer> a = new ListNode<>(1);
////    a.next = new ListNode<>(5432);
////    a.next.next = new ListNode<>(1999);
//
//    ListNode<Integer> b = new ListNode<>(9999);
//    b.next = new ListNode<>(9999);
//    b.next.next = new ListNode<>(9999);
//    b.next.next.next = new ListNode<>(9999);
//        b.next.next.next.next = new ListNode<>(9999);
//        b.next.next.next.next.next = new ListNode<>(9999);
//
//
//    ListNode<Integer> result = addTwoHugeNumbers(a,b);
//    while (result != null){
//
//        System.out.println(result.value);
//        result = result.next;
//    }

//        System.out.println(taskMaker( new String[]{"ans = 0",
//                "for i in range(n):",
//                "    for j in range(n):",
//                "    //DB 3//for j in range(1, n):",
//                "    //DB 2//for j in range(n + 1):",
//                "        ans += 1",
//                "return ans"}));

        ListNode<Integer> li = new ListNode<>(1);
        li.next = new ListNode<>(2);
        li.next.next = new ListNode<>(3);
        li.next.next.next = new ListNode<>(4);
        li.next.next.next.next = new ListNode<>(5);
//        li.next.next.next.next.next = new ListNode<>(6);
//        li.next.next.next.next.next.next = new ListNode<>(7);
//        li.next.next.next.next.next.next.next = new ListNode<>(8);

        ListNode<Integer> la = new ListNode<>(5);
        la.next = new ListNode<>(6);
        la.next.next = new ListNode<>(7);
        la.next.next.next = new ListNode<>(8);
      //  ListNode<Integer> temp = li;
//   System.out.println(temp.value);
        li = swapTwoAdjacentNode1(li);
        while (li != null){
            System.out.println(li.value);
            li = li.next;
        }


    }



}
