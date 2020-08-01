package SortDemo;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-06-01
 * Time:12:14
 * 一万年太久，只争朝夕，加油
 */
public class Test {
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            String A=sc.next();
            String B=sc.next();
            if(A.length()>100||B.length()>100){
                System.out.println("输入数据不合法");
                return;
            }
            //输入的字符串必须是小写字母
            for(int i=0;i<A.length();i++){
                if(A.charAt(i)<'a'||A.charAt(i)>'z'){
                    System.out.println("输入数据不合法");
                    return;
                }
            }
            for(int i=0;i<B.length();i++){
                if(B.charAt(i)<'a'||B.charAt(i)>'z'){
                    System.out.println("输入数据不合法");
                    return;
                }
            }
            find(A,B);

        }

        public static void find(String A,String B){
            int lengthA=A.length();
            int count=0;
            String str1=A+B;
            if(isReverse(str1)){
                count++;
            }

            for(int i=0;i<lengthA;i++){
                StringBuilder sb=new StringBuilder(A);
                sb.insert(i,B);
                if(isReverse(sb.toString())){
                    count++;
                }
            }
            /*if(A.length()==1) {
                if (B.length() == 1) {
                    count = 2;
                }
            }*/
            System.out.println(count);
        }
        public static boolean isReverse(String str){
            int left=0;
            int right=str.length()-1;
            while(left<right){
                if(str.charAt(left)!=str.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }