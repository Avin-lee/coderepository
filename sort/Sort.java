import java.util.Arrays;


public class Sort {


// 直接插入排序（越有序越快）：（稳定）
    public static void insertSort(int[] array){         // 时间复杂度为：O(n^2)   空间复杂度为：O(1)
        for(int i = 1;i < array.length;i++ ){
            int temp = array[i];
            int j = i-1;
            while(j >= 0){
                if(array[j] > temp){
                    array[j + 1] = array[j];
                }else{
                    break;
                }
                j--;
            }
            array[j + 1] = temp;
        }
    }


// 希尔排序（缩小增量排序）：（不稳定）
    public static void shell(int[] array,int gap){      // 平均时间复杂度为：O(N^1.3—N^2）
        for(int i = gap;i < array.length;i++ ){
            int temp = array[i];
            int j = i-gap;
            while(j >= 0){
                if(array[j] > temp){
                    array[j + gap] = array[j];
                }else{
                    break;
                }
                j -= gap;
            }
            array[j + gap] = temp;
        }
    }

    public static void shellSort(int[] array){
        int[] arr = {5,3,1};
        for(int i = 0;i < arr.length;i++){
            shell(array,arr[i]);
        }
    }


// 选择排序（跳跃式的交换）：（不稳定）
    public static void selectSort(int[] array){         // 时间复杂度为：O(n^2)   空间复杂度为：O(1)
        for(int i = 0;i < array.length;i++){
            for(int j = i + 1;j < array.length;j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


// 堆排序（大跟堆）：（不稳定）
    public static void adjust(int[] array,int start,int end){   // 把一颗树调整为大跟堆的时间复杂度为：O(log2n)
        int temp = array[start];
        for(int i = 2*start+1;i <= end;i = i*2+1){
            // 1.找到左右孩子最大值下标
            if((i < end) && array[i] < array [i + 1]){
                i++;
            }
            if(array[i] > temp){
                array[start] = array[i];
                start = i;
            }
            if(array[i] < temp){
                //array[start] = temp;
                break;
            }
        }
        array[start] = temp;
    }

    public static void heapSort(int[] array){               // 时间复杂度为：O(n*log2n)   空间复杂度为：O(1)

        // 把整棵树调整为大跟堆（时间复杂度为：n*log2n）
        for (int i = (array.length-1-1)/2;i >= 0;i--){      // n
            adjust(array,i,array.length - 1);               // log2n
        }

        // 交换（时间复杂度为：n*log2n）
        for(int i = 0;i < array.length;i++){                // n
            int temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[0];
            array[0] = temp;
            adjust(array,0,array.length - 1 - i - 1);       // log2n
        }
    }


// 快速排序（递归实现）：（不稳定）
    public static void swap(int[] array,int start,int end){
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static void medianOfThree(int[] array,int low,int high){
        int mid = (low + high) >>> 1;
        if(array[mid] > array[low]){
            swap(array,mid,low);
        }
        if(array[mid] > array[high]){
            swap(array,mid,high);
        }
        if(array[low] > array[high]){
            swap(array,low,high);
        }
    }

    public static int partion(int[] array,int low,int high){
        int temp = array[low];
        while(low < high){
            while((low < high) && array[high] >= temp){
                high--;
            }
            if(low == high){
                break;
            }else{
                array[low] = array[high];
            }
            while((low < high) && array[low] <= temp){
                low++;
            }
            if(low == high){
                break;
            }else{
                array[high] = array[low];
            }
        }
        array[low] = temp;
        return low;
    }

    public static void quick(int[] array,int start,int end){
        int par = partion(array,start,end);
        // 左边是否有两个数据以上
        if( par > start + 1){
            quick(array,start,par - 1);
        }
        // 右边是否有两个数据以上
        if(par < end - 1){
            quick(array,par + 1,end);
        }
    }

    public static void quickSort1(int[] array){         // 时间复杂度为：O(n*log2n)   空间复杂度为：O(log2n)
        quick(array,0,array.length - 1);
    }


// 快速排序（非递归实现）：（不稳定）
    public static void quickSort(int[] array){
        int[] stack = new int[array.length*2];
        int top = 0;
        int low = 0;
        int high = array.length - 1;
        int par = partion(array,low,high);
        if(par > low + 1){
            stack[top++] = low;
            stack[top++] = par - 1;
        }
        if(par < high - 1){
            stack[top++] = par + 1;
            stack[top++] = high;
        }
        while(top > 0) {
            high = stack[--top];
            low = stack[--top];
            par = partion(array, low, high);
            if(par > low + 1){
                stack[top++] = low;
                stack[top++] = par - 1;
            }
            if(par < high - 1){
                stack[top++] = par + 1;
                stack[top++] = high;
            }
        }
    }


// 冒泡排序：（稳定）
    public static void bubbleSort(int[] array){             // 时间复杂度为：O(n^2)   空间复杂度为：O(1)
        for(int i = 1;i < array.length;i++){
            for(int j = 0;j < array.length - i;j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


// 归并排序（递归实现）：（稳定）
    public static void merge(int[] array,int start,int mid,int end){
        int[] tmpArray = new int[array.length];
        int tmpIndex = start;
        int start2 = mid+1;
        int i = start;
        //两个归并段都有数据的时候
        while(start <= mid && start2 <= end) {
            if(array[start] <= array[start2]) {
                tmpArray[tmpIndex++] = array[start++];
            }else {
                tmpArray[tmpIndex++] = array[start2++];
            }
        }
        //退出循环后，可能存在某一个归并段会有数据
        while(start <= mid){
            tmpArray[tmpIndex++] = array[start++];
        }

        while (start2 <= end) {
            tmpArray[tmpIndex++] = array[start2++];
        }

    }

    public static void mergeSort(int[] array,int start,int end){// 时间复杂度为：O(n*log2n)   空间复杂度为：O(n)
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array,start,mid);
        mergeSort(array,mid + 1,end);       //分解
        //肯定是一个一个有序的序列
        //合并的过程
        merge(array,start,mid,end);
    }




    public static void main(String[] args) {
        int[] arr = {8,17,6,16,19,21,9,3,5,11};
//        insertSort(arr);
//        shellSort(arr);
//        selectSort(arr);
//        heapSort(arr);
//        quickSort1(arr);
//        quickSort(arr);
//        bubbleSort(arr);
        mergeSort(arr,0,9);
        System.out.println(Arrays.toString(arr));
    }
}
