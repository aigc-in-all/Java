package com.demo.linklist;

/**
 * 两两交换
 * 
 * @author qingbao.ho@gmail.com
 * @date 2016年3月7日 下午7:47:59
 * @version V1.0
 * 
 * http://blog.csdn.net/fightforyourdream/article/details/12901841
 * 
 */
public class Demo2 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);

        // change(n1);
        printNodeList(n1);
        printNodeList(change1(n1));
    }

    private static void printNodeList(Node head) {
        while (head != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
        System.out.println();
    }

    // 判断比较花时间，需要分奇数个节点和偶数个节点的情况
    private static Node change(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node i = head;
        Node j = i.getNext();
        Node k = j.getNext();

        head = head.getNext();
        while (j != null) {
            j.setNext(i);
            if (k != null && k.getNext() != null) { // 有偶数个点
                i.setNext(k.getNext());
            } else { // 有奇数个点
                i.setNext(k);
            }

            // 更新i/j/k的值，前进两格
            i = k;
            if (k != null) {
                j = k.getNext();
            } else {
                j = null;
            }

            if (k != null && k.getNext() != null) {
                k = k.getNext().getNext();
            } else {
                k = null;
            }
        }

        return head;
    }

    // 用dummyHead解决奇偶问题，只要两个指针变量就够了
    private static Node change1(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node dumpHead = new Node(0);
        dumpHead.setNext(head);

        Node cur = dumpHead;
        Node probe = cur.getNext();

        while (probe != null && probe.getNext() != null) {
            cur.setNext(probe.getNext());
            probe.setNext(probe.getNext().getNext());
            cur.getNext().setNext(probe);
            cur = probe;
            probe = probe.getNext();
        }
        return dumpHead.getNext();
    }

    public Node swapPairs(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node dm = new Node(0);
        dm.setNext(head);
        Node p = dm, q = head, r;
        while (q != null && q.getNext() != null) {
            p.setNext(q.getNext());
            r = q.getNext().getNext();
            p.getNext().setNext(q);
            q.setNext(r);
            p = q;
            q = r;
        }
        return dm.getNext();
    }

    public Node rec(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node p = head;
        Node q = p.getNext().getNext();
        p.getNext().setNext(p);
        Node newHead = p.getNext();
        p.setNext(rec(q));
        return newHead;
    }
}
