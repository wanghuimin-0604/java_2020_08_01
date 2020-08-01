package SortDemo;

import java.util.HashMap;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-13
 * Time:13:02
 * 一万年太久，只争朝夕，加油
 */
public class OccueOneNum {
    public static void main(String[] args) {
        int[] nums={1,1,2,3,2};
        System.out.println(singleNumber2(nums));

    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            Integer count = map.get(x);
            if (count == null) {
                //x之前没存在过，就把新的放到map中
                map(x, 1);
            } else {
                map(x, count + 1);
            }

        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return 0;
    }
    public static int singleNumber2(int[] nums) {
        int ret=0;
        for(int x:nums){
            ret^=x;
        }
        return ret;
    }
    public static int[] singleNumber3(int[] nums) {
        int ret=0;
        for(int x:nums){
            ret^=x;
        }
        //在ret中找一个不为0的位
        int bit=0;
        for(;bit<32;bit++){
            if((ret&(1<<bit))>0){
                break;
            }
        }
        int a=0;
        int b=0;
        for(int x:nums){
            if((x&(1<<bit))>0){
             a^=x;
            }else{
                b^=x;
            }
        }
        return new int[]{a,b};
   }
}