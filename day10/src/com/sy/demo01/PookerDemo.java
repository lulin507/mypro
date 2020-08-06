package com.sy.demo01;

import java.util.*;

/**
 * @Title: PookerDemo
 * @Description:
 * @Auther:
 * @Version: 1.0
 * @create 2020/6/30 0030 13:50
 */
public class PookerDemo {

    public static void main(String[] args) {
        // 1 定义扑克牌的map  key  扑克牌的编号  value 扑克牌的内容
        Map<Integer,String> pookerMap = new HashMap<>();
        // 2 定义结合   存储扑克牌的序号
        List<Integer> pookerList = new ArrayList<>();
        // 3  组合牌
        // 3.1 定义花色的仓库
        String[] hStore = {"♥","♠","♦","♣"};
        // 3.2 定义牌面点数的仓库
        String[] nStore = {"A","2","3","4","5","6","7","8","9","10","J","Q","k"};
        // 3.3 定义一个编号
        int count = 0;
        // 特殊处理  大王和小王
        pookerMap.put(count,"大王");
        pookerList.add(count);
        count++;
        pookerMap.put(count,"小王");
        pookerList.add(count);
        count++;

//        for(int i = 0;i<hStore.length;i++) {
//            String h =  hStore[i];
//            for(int j = 0;j<nStore.length;j++) {
//               String n =  nStore[j];
//               String hn = h + n;
//               // System.out.println(hn);
//                pookerMap.put(count,hn);
//                pookerList.add(count);
//                count++;
//            }
//        }

        for(int i = 0;i<nStore.length;i++) {
            String h =  nStore[i];
            for(int j = 0;j<hStore.length;j++) {
                String n =  hStore[j];
                String hn = n+h;
                // System.out.println(hn);
                pookerMap.put(count,hn);
                pookerList.add(count);
                count++;
            }
        }

       // System.out.println(pookerMap);
       // System.out.println(pookerList);
         // 洗牌
        Collections.shuffle(pookerList);
        //System.out.println(pookerList);
        // 定义四个玩家
        List<Integer> play01 = new ArrayList<>();
        List<Integer> play02 = new ArrayList<>();
        List<Integer> play03 = new ArrayList<>();
        // 底牌
        List<Integer> play = new ArrayList<>();


        // 抓牌 玩家
        for (int i = 0;i<pookerList.size();i++) {
             int code =  pookerList.get(i);
            // 特殊处理  留给底牌
            if(i >=  pookerList.size() - 3) {
                play.add(code);
            }else {
                 if(i % 3   == 0) {
                     play01.add(code);
                 }else if(i % 3 == 1) {
                     play02.add(code);
                 }else {
                     play03.add(code);
                 }
            }
        }

        // 排序
        Collections.sort(play01);
        Collections.sort(play02);
        Collections.sort(play03);
        Collections.sort(play);
        //打印  玩家  1 2 3  底牌
//        System.out.println(play01);
//        System.out.println(play02);
//        System.out.println(play03);
//        System.out.println(play);

        // 打印玩家的牌面
        printPooker(play01,pookerMap,"玩家1");
        printPooker(play02,pookerMap,"玩家2");
        printPooker(play03,pookerMap,"玩家3");
        printPooker(play,pookerMap,"底牌");


    }


    public  static  void printPooker(List<Integer> play, Map<Integer,String> pookerMap,String name) {
          StringBuffer str = new StringBuffer("[");
          for (Integer index:play) {
              String conetnt = pookerMap.get(index);
              str.append(conetnt+",");
          }
          str.deleteCharAt(str.length() - 1);
          str.append("]");
        System.out.println(name+str.toString());
    }
}
