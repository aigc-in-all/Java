package com.demo.linklist;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月7日 下午3:10:30
 * @version V1.0
 */
public class Node {

    private int val;
    private Node next;
    
    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(val);
        if (next != null) {
            b.append(" ").append(next.getVal());
        }
        return b.toString();
    }
}
