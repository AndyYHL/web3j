package com.hx.eplate.trafficdata.query.chain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-03-23.
 */
public class SevenToFiveGroups {

    private static Map fiveGroup(List map)
    {
        Map group = new HashMap ();
        int num = 0;
        for (int a = 0; a < 3; a++)
        {
            for (int b = a + 1; b < 4; b++)
            {
                for (int c = b + 1; c < 5; c++)
                {
                    for (int d = c + 1; d < 6; d++)
                    {
                        for (int e = d + 1; e < 7; e++)
                        {
                            List pukeGroup = new ArrayList();
                            pukeGroup.add(map.get(a));
                            pukeGroup.add(map.get(b));
                            pukeGroup.add(map.get(c));
                            pukeGroup.add(map.get(d));
                            pukeGroup.add(map.get(e));
                            group.put(num++, pukeGroup);
                        }
                    }
                }
            }
        }
        num = 0;
        return group;
    }

    //运行测试
    public static void main(String[] args) throws Exception{
        int flag = 0;
        //发牌 1 使用ABCD 标识牌类型  数字标识牌大小
        List<Poker> list = new ArrayList<>();
        list.add(new Poker("A",1));
        list.add(new Poker("C",5));
        list.add(new Poker("A",3));
        list.add(new Poker("A",4));
        list.add(new Poker("A",5));

        //组合判断
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = i + 1; j < list.size(); j++)
            {
                if (list.get(i).getNum() == list.get(j).getNum())
                {
                    flag++;
                }
            }
        }
        //判断是什么牌型
        switch (flag)
        {
            case 6:
                //四条
                System.out.println("四条");
                break;
            case 4:
                //葫芦
                System.out.println("葫芦");
                break;
            case 3:
                //三条
                System.out.println("三条");
                break;
            case 2:
                //两队
                System.out.println("两队");
                break;
            case 1:
                //一对;
                System.out.println("一对");
                break;
            case 0:
                //高牌;
                System.out.println("高牌");
                break;
        }
    }
}
