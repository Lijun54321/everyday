import java.util.Arrays;

/**
 * Class HeapSort ...
 *
 * @author LiJun
 * Created on 2019/3/22
 */
public class HeapSort {

    private static void maxHeapify(int[] arr, int start, int end) {
        //建立父节点指标和子节点指标
        int dad = start;
        int son = (dad << 2) + 1;
        //若子节点指标在范围内才做比较
        while (son <= end) {
            //先比较两个子节点大小，选择最大的
            if (son < end && arr[son] < arr[son + 1]) {
                son++;
            }//否则交换父子内容再继续子节点和孙节点比较
            if (arr[dad] < arr[son]){
                int temp = arr[dad];
                arr[dad] = arr[son];
                arr[son] = temp;
                dad = son;
                son = (dad << 2) + 1;
            }
            //如果父节点大与子节点代表调整完毕，直接跳出函数
            else {
                return;
            }
        }
    }

    private static void sort(int[] arr) {
        //初始化，i从最後一个父节点开始调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, arr.length - 1);
        }
        System.out.println(Arrays.toString(arr));

        //先将第一个元素和已排好元素前一位做交换，再重新调整，直到排序完毕
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i] ^ arr[0];
            arr[0] = arr[i] ^ arr[0];
            arr[i] = arr[i] ^ arr[0];
            maxHeapify(arr, 0, i - 1);
        }
    }


    public static void main(String[] args) {
        // Test case 1
        int[] arr = {19, 17, 20, 18, 16, 21, 19, 17, 20, 18, 16, 21, 12, 75};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {19, 17, 20, 18, 16, 21, 19, 17, 20, 18, 16, 21, 12, 75};
        init(arr1);
        System.out.println(Arrays.toString(arr1));
        /*
        // 创建堆
        init(arr);
        sortHeap(arr);
        // 16 17 18 19 20 21
        System.out.println(Arrays.toString(arr));*/
    }

    public static void init(int[] arr) {
        // 初始就是调整堆，从最后一个非叶子节点开始
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length - 1);
        }
    }

    public static void adjust(int[] arr, int i, int end) {
        // 当前节点的左孩子
        int child = (i << 1) + 1;
        int temp = arr[i];
        while (child <= end) {
            // 选出两个孩子较大的那个
            if (child < end && arr[child + 1] > arr[child]) {
                child++;
            }
            if (temp < arr[child]) {
                // 孩子节点与当前节点替换
                arr[i] = arr[child];
                i = child;
                child = (i << 1) + 1;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void sortHeap(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i] ^ arr[0];
            arr[0] = arr[i] ^ arr[0];
            arr[i] = arr[i] ^ arr[0];
            adjust(arr, 0, i - 1);
        }
    }
}