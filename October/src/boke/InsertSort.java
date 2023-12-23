package src.boke;

public class InsertSort {
    public static void main(String[] args){
       //无序序列
        int[] arr = {6,4,9,1,10,2,8};
        //调用直接排序方法
        insertSort(arr);
        //打印有序序列
        printArray(arr);

    }

    /**
     * 直接插入排序方法实现
     * @param arr
     */
    public static void insertSort(int[] arr){
        //对传进来的无序序列进行直接插入排序操作
        for (int i = 1; i < arr.length; i++) {
            //接收int[i] ,即摸到的牌
            int key = arr[i];
            int j  = i-1;
            for (; j >=0 ; j--) {
                if(arr[j]>key){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
        arr[j+1] = key;
        }
    }

    /**
     * 打印素组的方法
     */
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
            }
}
