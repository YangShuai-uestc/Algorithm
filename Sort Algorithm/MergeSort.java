public class MergeSort {

    public static void main(String[] args) {
        // write your code here
        int max = 100000;
        int[] test = new int[max];

        for (int i = 0; i < max; i++) {
            test[i] = (int) (Math.random() * max * 10);
        }

        //排序开始时间
        long start = System.currentTimeMillis();
        int[] temp = new int[test.length];
        mergeSort(test, temp, 0, test.length - 1);
        //排序结束时间
        long end = System.currentTimeMillis();


        System.out.println(end - start);

    }

    /**
     * 有序数组的排序
     *
     * @param a         前半段和后半段为两个有序数组
     * @param arrayTemp 用来临时存放数据的数组
     * @param left
     * @param mid
     * @param right
     * @return 有序数组
     */
    public static void merge(int[] a, int[] arrayTemp, int left, int mid, int right) {
        //左检测指针
        int p1 = left;
        //右检测指针
        int p2 = mid + 1;
        //存放指针
        int k = left;
        while (p1 <= mid && p2 <= right) {
            //两个有序数组中取小的存进来
            if (a[p1] < a[p2]) {
                arrayTemp[k] = a[p1];
                p1++;
            } else {
                arrayTemp[k] = a[p2];
                p2++;
            }
            k++;
        }

        //将未遍历完的部分直接存入数组
        while (p1 <= mid) {
            arrayTemp[k] = a[p1];
            k++;
            p1++;
        }

        while (p2 <= right) {
            arrayTemp[k] = a[p2];
            k++;
            p2++;
        }

        System.arraycopy(arrayTemp, left, a, left, right - left + 1);
    }

    /**
     * 归并排序
     *
     * @param a         待排序数组
     * @param arrayTemp 临时存放数据的空间
     * @param start     排序起点元素
     * @param end       排序终点元素
     */
    public static void mergeSort(int[] a, int[] arrayTemp, int start, int end) {
        if (start < end) {
            //划分子数组
            int mid = (start + end) / 2;
            //递归排序左数组，使之有序
            mergeSort(a, arrayTemp, start, mid);
            //递归排序右数组，使之有序
            mergeSort(a, arrayTemp, mid + 1, end);
            //合并左右的有序子数组
            merge(a, arrayTemp, start, mid, end);
        }
    }
}