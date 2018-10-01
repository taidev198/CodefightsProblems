package com.taidev198.game.CodingInterview.Challenges;

import java.math.BigInteger;
import java.util.*;

public class Challenges {


    static String marvelousNumber(String n) {
        int len = n.length();
        if (len % 2 == 1 )
           return (generateNum(len + 1));
        else if ( (n.charAt(0) -'0') > 7)
            return (generateNum(len + 2));
        StringBuilder[] res = generateNumber(len);
        String[] temp = new String[res.length];
        for (int i = 0; i < res.length; i++) {
            temp[i] = res[i].toString();
        }
        Arrays.sort(temp);
        for (int i = 0; i < res.length; i++) {
            System.out.println(temp[i]);
        }
        for (int i = 0; i < res.length; i++) {
            if (new BigInteger(n).compareTo(new BigInteger(temp[i])) < 0)
                return temp[i];
        }
        return (generateNum(len + 2));
    }


    static String generateNum(int n){
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i<n/2)
                ans.append('4');
            else ans.append('7');
        }
        return ans.toString();
    }
    static StringBuilder[] generateNumber(int n){
        StringBuilder[] ans = new StringBuilder[n*n];
        ans[0] = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i<n/2)
                ans[0].append('4');
            else ans[0].append('7');
        }
        int idx =1;
            for (int j = n/2 -1; (n/2) % 2== 0? j>0 :j >=0 ; j--) {
                for (int i = n/2; i <n ; i++) {
                    char[] temp = ans[0].toString().toCharArray();
                    char tmp =   temp[j];
                    temp[j] = temp[i];
                    temp[i]= tmp;
                    ans[idx++] = new StringBuilder(String.valueOf(temp));
                }
            }
            for (int i = 0; i <= n/2; i++) {
                char[] temp = ans[i].toString().toCharArray();
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] == '7')
                        temp[j] = '4';
                    else temp[j] = '7';
                }
                ans[idx++] = new StringBuilder(String.valueOf(temp));
        }
        HashSet<String> test = new HashSet<>();
        return Arrays.copyOfRange(ans, 0 , idx);
    }

    static int schoolSupplies(String[] supplies, int[] prices) {
        int len = supplies.length;

        if(len == 0)
            return 0;
        Map<String, Integer> suppliesItem = new LinkedHashMap<>();

        for(int i=0; i< len; i++){
            String supply = supplies[i].substring(supplies[i].indexOf(" ")+1, supplies[i].length());
            int value = Integer.valueOf(supplies[i].substring(0, supplies[i].indexOf(" ")));
            if (value == 1)
                supply += "s";
            if(!suppliesItem.containsKey(supply))
                suppliesItem.put(supply, value);
            else{
                int temp = suppliesItem.get(supply);
                suppliesItem.replace(supply, temp, temp+ value);
            }
        }
        int total =0;
        List<Map.Entry<String, Integer>> list = new ArrayList<>(suppliesItem.entrySet());

        for(int i=0; i< prices.length; i++){
            total = total + (list.get(i).getValue() * prices[i]);
        }
        return total;
    }


    static int studyOrSleep(int familiarity, int hoursRemaining) {
        float unfamiliarity = 100- familiarity;
        float bestResult = ((unfamiliarity *20)/100) + familiarity - 5;
        int bestHour =0;
        int hours = 1;
        int timeRemain = Math.abs(hoursRemaining - 8);
        if(hoursRemaining >8 ){
            hours =0;
        }
        float result ;
        float familiarityTmp = familiarity;
        while(hours < 8){
            familiarityTmp += ((unfamiliarity *20)/100);
            result =  familiarityTmp - hours * 5;
            unfamiliarity = 100-familiarityTmp;
            if ((result == bestResult && hours ==1) || (hours > 1 && bestResult < result )){
                bestHour = hours;
                bestResult = result;
            }else break;
            timeRemain--;
            if(timeRemain <= 0)
                hours ++;
        }
        return  bestHour;
    }

    public static void main(String...args){
        List<Character> list = new ArrayList<>();
        list.add('c');

    }
}
