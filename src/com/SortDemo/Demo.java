package SortDemo;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:七大排序算法
 * User:wanghuimin
 * Date:2020-05-06
 * Time:15:31
 * 一万年太久，只争朝夕，加油
 */
public class Demo {
    public static void main(String[] args) {
        int[] array = {3,1,6,8,5,4};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    //直接插入排序
    //升序排序
    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            //先把bound位置的元素保存下来
            int tmp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > tmp) {
                    //tmp往前找，cur往后搬运
                    array[cur + 1] = array[cur];

                } else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    //希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;

        }
        insertSortGap(array, 1);
    }

    //希尔排序
    private static void insertSortGap(int[] array, int gap) {
        //从每组下标为1的元素开始
        for (int bound = gap; bound < array.length; bound++) {
            //取出当前元素
            int tmp = array[bound];
            //找出bound位置相邻的元素位置
            int cur = bound - gap;
             for (; cur >= 0; cur -= gap) {
                //比较
                if (array[cur] > tmp) {
                    //进行搬运，搬到cur+gap位置
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }

            }
            array[cur + gap] = tmp;
        }
    }

    //选择排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            //借助bound把数组分成两个区间
            //在待排序中找到最小值
            for (int cur = bound; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    //bound位置的元素为擂台（升序排序）
                     swap(array, cur, bound);
                } else {
                    continue;
                }
            }
        }
    }

    //堆排序
    public static void HeapSort(int[] array) {
        //先建立一个堆
        createHeap(array);
        //堆的大小刚开始和数组长度是一样的
        int heapSize = array.length;
        //循环n-1次就够了，剩下一个元素
        for (int i = 0; i < array.length - 1; i++) {
            //交换堆顶元素（最大的元素）和堆中最后一个元素
            swap(array, 0, heapSize - 1);
            //从堆中删除最后一个元素
            heapSize--;
            //向下调整
            shiftDown(array, heapSize, 0);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = parent * 2 + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            }
            parent = child;
            child = child * 2 + 1;
        }
    }

    //建堆
    private static void createHeap(int[] array) {
        //从最后一个非叶子节点出发，从后往前遍历，向下调整
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        /*for (int bound = array.length - 1; bound >= 0; bound--) {
            for (int cur = 0; cur < array.length - 1; cur++) {
                if (array[cur] > array[cur + 1]) {
                    swap(array, cur, cur + 1);
                }

            }
        }*/
        //比较相邻元素，看是否满足升序排序
        //[0,bound）已排序区间，[bound,array.length)待排序区间
        //从后向前遍历，找最小，放最前面
        for(int bound=0;bound<array.length;bound++){
            for(int cur=array.length-1;cur>bound;cur--){
                if(array[cur]<array[cur-1]){
                    swap(array,cur,cur-1);
                }
            }
        }
    }
    //快速排序
    public static void fastSort(int[] array){
        quickSortHelper(array,0,array.length-1);
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
        // 当整个循环结束, i 和 j 就重合了. 接下来就把 基准值 位置的元素交换到 i j 重合位置上.
        // 此时 i 和 j 重合位置的元素一定是大于基准值的元素.
        // 为啥 i 和 j 重合位置的元素一定大于基准值呢?
        // 1) i++ 触发了和 j 重合, 上次循环中刚把 i 和 j 交换元素. 交换之后 j 一定是一个大于基准值的元素. i 再往 j 上靠, 结果也一定是指向大于基准值的元素
        // 2) j-- 触发了和 i 重合, 此时 i 一定是指向一个大于基准值的元素(第一个 while 的功能)
        swap(array, i, right);
        return i;
    }
    //快速排序的非递归实现
    public static void quickSort(int[] array){
        //栈中保存的是当前要进行paratition的范围
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        stack.push(array.length-1);
        while(!stack.isEmpty()){
            int right=stack.pop();
            int left=stack.pop();
            if(left>=right){
                continue;
            }
           int index= partition(array,left,right);
            //把右子树入栈
            stack.push(index+1);
            stack.push(right);
            //左子树入栈
            stack.push(left);
            stack.push(index-1);
        }
    }
    public static void mergeSort(int[] array){
        //前闭后开区间
        mergerSortHelper(array,0,array.length);
    }

    private static void mergerSortHelper(int[] array, int left, int right) {
        if(right-left<=1){
            //当前区间中有0个或者1个元素
            return;
        }
        //针对这个区间分成两组
        int mid=(left+right)/2;
        //[left,mid)
        //[mid,right)
        mergerSortHelper(array,left,mid);
        mergerSortHelper(array,mid,right);
        //排好序
        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //合并方法
        //[left,mid)   [mid,right)
        //借助一个临时空间
        int cur1=left;
        int cur2=mid;
        int[] output=new int[right-left];
        int outputIndex=0;//插入了几个元素
        while(cur1<mid&&cur2<right){
            if(array[cur1]<array[cur2]){
                output[outputIndex]=array[cur1];
                cur1++;
                outputIndex++;
            }else{
                output[outputIndex]=array[cur2];
                cur2++;
                outputIndex++;

            }
        }
        while(cur1<mid){
            output[outputIndex]=array[cur1];
            cur1++;
            outputIndex++;
        }
        while(cur2<right){
            output[outputIndex]=array[cur2];
            cur2++;
            outputIndex++;

        }
        for(int i=0;i<right-left;i++){
            array[left+i]=output[i];
        }

    }
    public static void mergeSortByLoop(int[] array){
        //分组
        for(int gap=1;gap<array.length;gap*=2){
            //gap表示每个组中的元素个数
            for(int i=0;i<array.length;i+=2*gap){
                //每执行一次循环体，说明把两个长度为gap的组进行了合并
                //[i,i+gap)
                //[i+gap,i+2*gap)
                int left=i;
                int mid=i+gap;
                int right=i+2*gap;
                if(mid>array.length){
                    mid=array.length;
                }
                if(right>array.length){
                    right=array.length;
                }
                merge(array,left,mid,right);
            }
        }
    }
}
