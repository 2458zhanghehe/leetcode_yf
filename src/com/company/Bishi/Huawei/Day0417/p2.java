package com.company.Bishi.Huawei.Day0417;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*  计算云服务DI值
    我们将云服务看做一棵树，每个云服务在发布前尚未解决的问题称为云服务的遗留问题（云服务的遗留问题包含以该云
    服务为根节点的树上所有节点的问题），DI值（遗留问题缺陷密度）可以作为评估云服务发布的指标，当云服务DI值
    小于等于阈值时才准许云服务发布，否则视为风险云服务，需要问题整改完成后重新进行发布评估。现有一批云服务
    树，已给出云服务树各节点的问题数量，请通过计算输出风险云服务的个数。

    计算公式：DI值 ≤ 5×严重问题数＋2×一般问题数，其中每个节点的不同级别问题数量需要将该节点及该节点为根
    节点的所有子节点的相应级别问题数量求和。

    输入：
    第一行输入M和N(M≤100000，N≤1000)，使用空格分隔，M表示代表云服务阈值，N表示接下来有N行问题统计数据；
    接下来输入一个N∗4的矩阵表，行内使用空格分隔，第一列Ai为服务节点，第二列Bi为Ai的父节点，如果Ai为云服务则无父节点
    ，此时Bi用∗号表示(Ai和Bi取值为字符串，1≤字符串长度≤5，均由小写英文字母或∗号组成)，第三列Ci为问题级别（Ci取值
    为{0,1}，0表示严重问题，1表示一般问题），第四列Di为该节点该级别的问题数量(Di≤1000)。说明：输入保证只出现树的关
    系，不会出现连通图的情况。
    输出：
    风险云服务个数
    示例：
    输入：
50 10
e b 0 2
g c 1 2
b a 1 5
a * 0 2
b a 0 3
c a 1 3
d a 0 1
a * 1 2
d a 1 3
f b 1 1
    输出：
        1
    */
public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, int[]> map = new HashMap<>();
        HashMap<String,String> fatherMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            String cur = sc.nextLine();
            String[] splits = cur.split(" ");

            int cls = Integer.parseInt(splits[2]);
            int num = Integer.parseInt(splits[3]);
            String name = splits[0];
            String father = splits[1];
            if(father.equals("*")){
                if(!fatherMap.containsKey(name)){
                    fatherMap.put(name, name);
                }
                father = name;
            }else {
                fatherMap.put(name, father);
                while(fatherMap.containsKey(father) && !fatherMap.get(father).equals(father)){
                    father = fatherMap.get(father);
                }
            }

            if(map.containsKey(father)){
                int[] arr = map.get(father);
                arr[cls] += num;
            }else {
                int[] arr = new int[2];
                arr[cls] += num;
                map.put(father,arr);
            }
        }

        int ans = 0;
        Set<String> keys = map.keySet();
        for(String name : keys){
            if(!fatherMap.get(name).equals(name)){
                int[] arr = map.get(name);
                map.remove(name);
                while(!fatherMap.get(name).equals(name)){
                    name = fatherMap.get(name);
                }
                int[] arr1 = map.get(name);
                arr1[0] += arr[0];
                arr1[1] += arr[1];
            }
        }

        for(String name : keys){
            int[] nums = map.get(name);
            int di = 5 * nums[0] + 2 * nums[1];
            if(di > m){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
