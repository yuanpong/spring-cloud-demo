package com.yuanpeng.springcloud.common;

import io.micrometer.shaded.org.pcollections.HashPMap;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Escape {
    public static void main1(String[] args) {
        String url = "http://example.com/test?q=%.P%20some%20other%20Text";
        url = url.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        System.out.println(url);
    }

    public static void main2(String[] args) {

        Set mainWalletIds = new HashSet<>();
        HashPMap<Long,SharedWalletInfo> walletId2SharedWallet = null;
        for(Map.Entry<Long,SharedWalletInfo> entry: walletId2SharedWallet.entrySet()){
            if(entry.getValue().getWallet_type().equals(WalletType.main_wallet)){
                mainWalletIds.add(entry.getKey());
            }
        }
        walletId2SharedWallet.forEach((key, value) -> {
            if (value.getWallet_type().equals(WalletType.main_wallet.name)) {
                mainWalletIds.add(key);
            }
        });


        Set<Map.Entry<Long, SharedWalletInfo>> collect = walletId2SharedWallet.entrySet().stream()
                .filter(entry -> entry.getValue().getWallet_type().equals(WalletType.main_wallet.name))
                .collect(Collectors.toSet());
    }

    public class SharedWalletInfo{
        public String wallet_type;

        public String getWallet_type() {
            return wallet_type;
        }

        public void setWallet_type(String wallet_type) {
            this.wallet_type = wallet_type;
        }
    }
    public enum WalletType{
        main_wallet("wallet");

        public String name;

        WalletType(String name) {
            this.name = name;
        }
    }

    public static void main3(String[] args) {
        String[] array = {"a","b","c"};
        //List<String> list = Arrays.asList(array); // 只能查改,不能增删
        //ArrayList<String> list = new ArrayList<>(Arrays.asList(array)); // 可以增删

        ArrayList<Object> list = new ArrayList<>(array.length);// 可以增删改
        Collections.addAll(list,array);
        list.add("hello");
        System.out.println(list);
    }

    public static void main(String[] args) {
        //插入排序
        int[] array = {5,3,4,9,1};
        for (int i=1;i< array.length;i++){
            for(int j=i; j>0;j--){
                if(array[j-1] > array[j]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        for (int i : array) {
            System.out.println( i+ " ");
        }
    }


}
