package SortDemo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-06-01
 * Time:11:10
 * 一万年太久，只争朝夕，加油
 */
import java.util.*;

public class Main {
    /*public static void main(String[] args) {
        int[] array={1,2,7,5};
        int K=2;
        System.out.println(findKth(array, array.length, K));
    }*/
    public static Integer findKth(int[] array, int n, int K) {
        // write code here
        if(K>n){
            return null;
        }
        quickSortHelper(array,0,n-1);

        //现在整个数组排好序了
        //去重
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!list.contains(array[i])){
                list.add(array[i]);
            }
        }
        //现在是一个有序的集合，并且集合中没有重复元
        return list.get(n-K);

    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            // 区间中有 0 个元素或者 1 个元素
            return;
        }
        // 返回值表示 整理之后, 基准值所处在的位置.
        int index = partition(array, left, right);
        // [left, index - 1]
        // [index + 1, right]
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            // 1. 先从左往右找到一个大于基准值的元素
            while (i < j && array[i] <= baseValue) {
                i++;
            }
            // 此时 i 指向的位置要么和 j 重合, 要么就是一个比基准值大的元素
            // 2. 再从右往左找到一个小于基准值的元素
            while (i < j && array[j] >= baseValue) {
                j--;
            }
            // 此时 j 指向的元素要么和 i 重合, 要么就是比基准值小的元素
            // 3. 交换 i 和 j 的值
            if (i < j) {
                swap(array, i, j);
            }
        }

        swap(array, i, right);
        return i;
    }
    public static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
