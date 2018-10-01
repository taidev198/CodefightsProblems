package com.taidev198.game.CodingInterview.Companies.ThumStack;

import com.sun.org.apache.xerces.internal.xs.StringList;
import com.taidev198.game.CodingInterview.Array.Array;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.Collectors;

public class ThumbTack {


    public static void main(String...args){


        System.out.println(Arrays.toString(proCategorization(new String[]{"Jack", "Leon", "Maria"}, new String[][]{{"Computer repair", "Handyman", "House cleaning"},
                {"Computer lessons", "Computer repair", "Data recovery service"},{"Computer lessons", "House cleaning"}})));

    }


    static String[][][] proCategorization(String[] pros, String[][] preferences) {
        Map<String, List<String>> map  = new HashMap<>();
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                if (!map.containsKey(preferences[i][j])){
                    List<String> pros1 = new ArrayList<>();
                    pros1.add(pros[i]);
                    map.put(preferences[i][j], pros1);
                }else {
                    List<String> tmp = map.get(preferences[i][j]);
                    if (!tmp.contains(pros[i])){
                        tmp.add(pros[i]);
                        Collections.sort(tmp);
                    }
                }
            }
        }
        Collection<List<String>> values = map.values();//get value
        Set<String> keySet = map.keySet();//get key
        List<Map.Entry<String, List<String>>> entryList = new ArrayList<>(map.entrySet());

        String[][][] ans = new String[1][keySet.size()][values.size()];
        for (Map.Entry<String, List<String>> entry:
                entryList) {
            Collections.sort(entry.getValue());
            String[] temp = entry.getValue().toArray(new String[0]);
            System.out.println(temp[0]);
        }

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i][i].length; j++) {
                for (int k = 0; k < ans[i][j][k].length(); k++) {
                    
                }
            }
        }
        return null;
    }

    /**
     * https://app.codesignal.com/company-challenges/thumbtack/fEnagAYuHR3msAYfK*/
    static String[] requestMatching(String[] pros, int[] distances, int[] travelPreferences) {
        int n = pros.length;
        Map<String, Integer> matchingScore = new HashMap<>();
        Map<String, Integer> nonMatchingScore = new HashMap<>();
        for(int i=0;i< n;i++){
            int diff =travelPreferences[i] - distances[i];
            if(diff <0){
                nonMatchingScore.put(pros[i], -diff);
            }else matchingScore.put(pros[i], distances[i]);
        }
        nonMatchingScore = sortByValue(nonMatchingScore);
        matchingScore = sortByValue(matchingScore);
        List<Map.Entry<String, Integer>> entriesMatchingScore = new ArrayList<>(matchingScore.entrySet());
        List<Map.Entry<String, Integer>> entriesNonMatchingScore = new ArrayList<>(nonMatchingScore.entrySet());
        String[] ans = new String[5];
          int i=0;
         for (Map.Entry<String, Integer> entry:
              entriesMatchingScore) {
             ans[i++] = entry.getKey();
         }
         for (Map.Entry<String, Integer> entry:
                 entriesNonMatchingScore) {
             ans[i++] = entry.getKey();
             if(n >=5 &&i ==5) break;
         }
        if(n<5)
            return Arrays.copyOfRange(ans, 0, n);
        return ans;
    }


        /**
         * stored by value, if values are same then sorted by key =))))*/
    static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
      //  list.sort(Map.Entry.comparingByValue());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                if (((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue()) ==0 )
                    return ((Comparable) ((Map.Entry) (o1)).getKey())
                            .compareTo(((Map.Entry) (o2)).getKey());
               return  ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    static String[] campusCup(String[] emails){
        int n = emails.length;
        String[] ans = new String[n];
        for (int i = 0; i < emails.length; i++) {
            emails[i] = emails[i].substring(emails[i].indexOf("@")+1, emails[i].length());
        }
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsValue(emails[i])){
                map.put(emails[i], 20);
            }else {
                Integer tmp = map.get(emails[i]);
                map.replace(emails[i], tmp, tmp+20);
            }
        }
        return ans;
    }

    static  void givenMap_whenSortingByValues_thenSortedMap(Map<String, Integer> map) {
        String[] sortedValues = new String[]
                { "Apple", "Earl", "George", "John", "Pearl", "Rocky" };

        List<Map.Entry<String, Integer>> entries
                = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
            entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(
                    Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Map<String,Integer > sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String,Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        Arrays.equals(sortedMap.values().toArray(), sortedValues);
        Set<String> string = map.keySet();
        for (int i = 0; i < map.size(); i++) {
           // System.out.println(map.get(string.));
        }
    }



}
