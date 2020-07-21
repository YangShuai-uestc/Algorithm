package com.yangshuai;


public class LinkedListSort {

    public static void main(String[] args) {
        // write your code here
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node7 = new ListNode(7);
        ListNode node1 = new ListNode(1);
        node4.next = node3;
        node3.next = node2;
        node2.next = node6;
        node6.next = node5;
        node5.next = node7;
        node7.next = node1;

        ListNode cur = sortList(node4);
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }

    }

    /**
     * 归并排序列表
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        //递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //找到链表中点，并断开链表
        ListNode middle = findListMiddle(head);
        //右半部分的链表头
        ListNode rightHead = middle.next;
        middle.next = null;//!!!!!!非常重要，否则就会一直递归下去无法终止

        //递归操作左右半链表
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        //合并两个有序链表
        return merge(left, right);

    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode merge(ListNode l1, ListNode l2) {
        //哨兵结点
        ListNode sentry = new ListNode(-1);
        ListNode cur = sentry;
        while (l1 != null && l2 != null) {
            //把结点值小的挂上链
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        //未遍历完的链表直接挂上链
        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return sentry.next;
    }

    /**
     * 找链表的中点,偶数个结点的链表返回前半链表的最后一个结点
     *
     * @param head
     * @return
     */
    public static ListNode findListMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //快慢指针，快指针一次走两步，慢指针一次走一步
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
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
                    '}';
        }
    }
}