package com.yangshuai;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 50};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 有序数组的排序
     *
     * @param a     前半段和后半段为两个有序数组
     * @param left
     * @param mid
     * @param right
     * @return 有序数组
     */
    public static int[] merge(int[] a, int left, int mid, int right) {
        //临时存放的数组
        int[] tempArray = new int[a.length];
        //左检测指针
        int p1 = left;
        //右检测指针
        int p2 = mid + 1;
        //存放指针
        int k = left;
        while (p1 <= mid && p2 <= right) {
            //两个有序数组中取小的存进来
            if (a[p1] < a[p2]) {
                tempArray[k] = a[p1];
                p1++;
            } else {
                tempArray[k] = a[p2];
                p2++;
            }
            k++;
        }

        //将未遍历完的部分直接存入数组
        while (p1 <= mid) {
            tempArray[k] = a[p1];
            k++;
            p1++;
        }

        while (p2 <= right) {
            tempArray[k] = a[p2];
            k++;
            p2++;
        }

        System.arraycopy(tempArray, left, a, left, right - left + 1);

        return a;
    }

    /**
     * 归并排序
     *
     * @param a     待排序数组
     * @param start 排序起点元素
     * @param end   排序终点元素
     */
    public static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            //划分子数组
            int mid = (start + end) / 2;
            //递归排序左数组
            mergeSort(a, start, mid);
            //递归排序右数组
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}