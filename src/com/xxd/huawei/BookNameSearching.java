package com.xxd.huawei;

import java.util.*;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public class BookNameSearching {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> bookMap = new HashMap();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++){
            String name = scanner.nextLine();
            String[] nameWords = name.split(" ");
            Set<String> nameSet = new HashSet();
            for (int j = 0; j < nameWords.length; j++){
                nameSet.add(nameWords[j]);
            }
            bookMap.put(name, nameSet);
        }
        String keyLine = scanner.nextLine();
        String[] keyWords = keyLine.split(" ");
        ArrayList<String> outStr = new ArrayList();
        Iterator<String> iterator = bookMap.keySet().iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            if (containsName(keyWords, bookMap.get(name))){
                outStr.add(name);
            }
        }
        Collections.sort(outStr);
        System.out.println(outStr.size());
        for (int i = 0; i < outStr.size(); i++){
            System.out.println(outStr.get(i));
        }

    }

    public static boolean containsName(String[] keyWords, Set<String> keys){
        for (String word : keyWords){
            if (keys.contains(word)){
                return true;
            }
        }
        return false;
    }

}
