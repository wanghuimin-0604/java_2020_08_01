package SortDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-13
 * Time:11:21
 * 一万年太久，只争朝夕，加油
 */
public class TestSet {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("java");
        set.add("c++");
        set.add("python");
        set.add("php");
        System.out.println(set.contains("java"));
        set.remove("c++");
        System.out.println(set.contains("c++"));
        System.out.println(set);
        for(String s:set){
            System.out.println(s);
        }
        Iterator<String> iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
