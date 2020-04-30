package com.xncoding.util;

import java.util.ArrayList;
import java.util.Stack;

public class CommonUtils {

    public static String replaceSpace(String str){

        if(str==null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++){
            if(" ".equals(String.valueOf(str.charAt(i)))){
                sb.append("%10");
            }else{
                sb.append(str.charAt(i));
            }
        }
        return String.valueOf(sb);
    }

    //创建一个链表的类
    private static class ListNode{
        int val;	//数值 data
        ListNode next;	// 结点 node

        ListNode(int x){	//可以定义一个有参构造方法，也可以定义一个无参构造方法
            val = x;
        }
        // 添加新的结点
        public void add(int newval) {
            ListNode newNode = new ListNode(newval);
            if(this.next == null)
                this.next = newNode;
            else
                this.next.add(newval);
        }
        // 打印链表
        public void print() {
            System.out.print(this.val);
            if(this.next != null)
            {
                System.out.print("-->");
                this.next.print();
            }
        }
    }


    public static ArrayList<Integer> printListFromTailtoHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        if(list == null){
            return list;
        }
        Stack<ListNode> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }

        while(!stack.isEmpty()){
            //stack.pop();

            list.add(stack.pop().val);
        }

        return list;
    }


    public static void main(String[] args) throws InterruptedException {

       char c = ' ';
       System.out.println(replaceSpace("we are happy").replaceAll("%10", ""));
        ListNode node = new ListNode(2);
        node.add(3);
        node.add(4);
        node.print();
        System.out.println(printListFromTailtoHead(node));
    }
}
