package com.company.Bishi.Huawei.Day0410;

import java.util.*;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> ansList = new ArrayList<>();
        //name Client
        HashMap<String, Client> clientMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            String cur = sc.nextLine();
            String[] splits = cur.split(",");
            if(splits.length != 4){
                continue;
            }
            String timeStamp = splits[0];
            String name = splits[1];
            String factor = splits[2];
            Integer time = Integer.valueOf(splits[3]);
            if(time < 0 || time > 100){
                continue;
            }

            if(clientMap.containsKey(name)){
                Client client = clientMap.get(name);
                client.put(timeStamp,factor,time);
            }else {
                Client client = new Client();
                client.put(timeStamp,factor,time);
                clientMap.put(name,client);
            }
        }

        int m = sc.nextInt();
        sc.nextLine();
        HashMap<String,Integer> YinMap = new HashMap<>();
        for(int i = 0; i < m; i++){
            String cur = sc.nextLine();
            String[] splits = cur.split(",");
            YinMap.put(splits[0], Integer.valueOf(splits[1]));
        }

        Set<String> names = clientMap.keySet();
        for(String name : names){
            Client client = clientMap.get(name);
            int sum = 0;
            Set<String> times = client.map.keySet();
            for(String time : times){
                Map<String, Integer> factorMap = client.map.get(time);
                for(Map.Entry<String, Integer> entry : factorMap.entrySet()){
                    sum += YinMap.get(entry.getKey()) * entry.getValue();
                }
            }
            ansList.add(name + "," + sum);
        }

        Collections.sort(ansList);
        for(String paypal : ansList){
            System.out.println(paypal);
        }
    }

    static class Client{

        //时间戳 （因子，时间）
        HashMap<String, Map<String,Integer>> map;

        public Client() {
            map = new HashMap<>();
        }

        public void put(String timeStamp, String factor, Integer time) {
            if(map.containsKey(timeStamp)){
                Map<String, Integer> factorMap = map.get(timeStamp);
                if(!factorMap.containsKey(factor)){
                    factorMap.put(factor,time);
                }
            }else {
                HashMap<String, Integer> factorMap = new HashMap<>();
                factorMap.put(factor,time);
                map.put(timeStamp, factorMap);
            }
        }
    }

}
