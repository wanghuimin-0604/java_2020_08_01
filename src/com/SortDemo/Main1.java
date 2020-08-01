package SortDemo;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-06-04
 * Time:17:33
 * 一万年太久，只争朝夕，加油
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        //String str3 = str1.replaceAll("\\s*", "");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i)==' '){
                    sb.append(str1.charAt(i));
                    break;
                }else if (str1.charAt(i) == str2.charAt(j)) {
                    break;
                } else if (str1.charAt(i) != str2.charAt(j)) {
                    if (j == str2.length() - 1) {
                        sb.append(str1.charAt(i));
                    }
                    continue;
                }
            }
        }
        System.out.println();
        System.out.println(sb.toString());
    }
}