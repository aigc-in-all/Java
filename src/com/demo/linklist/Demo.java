package com.demo.linklist;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月7日 下午3:09:40
 * @version V1.0
 */
public class Demo {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        printNodeList(n1);

        int nodeCount = getNodeListLength(n1);
        System.out.println("节点个数:" + nodeCount);

        // System.out.println("反转单链表（遍历）：");
        // printNodeList(reverseNodeList(n1));
        //
        // System.out.println("反转单链表（递归）：");
        // printNodeList(reverseNodeListByRec(n5));

//        System.out.println(getKNode1(n1, 2));
//        reGetKthNodeRec(n1, 2);
//        System.out.println(getMiddleNode(n1));
        
//        reversePrintNodeList2(n1);
        
        Node n6 = new Node(0);
        Node n7 = new Node(4);
        Node n8 = new Node(7);
        Node n9 = new Node(10);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n9);
        
//        Node mergedNode = mergeSortedNodeList2(n1, n6);
//        printNodeList(mergedNode);
    }

    private static void printNodeList(Node head) {
        while (head != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
        System.out.println();
    }

    // 节点个数
    private static int getNodeListLength(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.getNext();
        }

        return count;
    }

    // 翻转单链表，使用遍历
    private static Node reverseNodeList(Node current) {
        if (current == null) {
            return current;
        }
        
        Node preNode = null;
        Node nextNode = null;

        while (current != null) {
            nextNode = current.getNext();
            current.setNext(preNode);
            preNode = current;
            current = nextNode;
        }

        return preNode;
    }

    // 翻转单链表，使用递归
    private static Node reverseNodeListByRec(Node current) {
        if (current == null || current.getNext() == null) {
            return current;
        }

        Node next = current.getNext();
        current.setNext(null);
        Node reverse = reverseNodeListByRec(next);
        next.setNext(current);
        return reverse;
    }

    // 查找单链表倒数第K(k>0)个节点
    // 先统计单链表中结点的个数，然后再找到第（n-k）个结点
    private static Node getKNode1(Node head, int k) {
        int count = 0;

        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }

        int index = count - k;
        if (index < 0 || index > count) {
            return null;
        }

        int i = 0;
        while (head != null) {
            if (i++ == index) {
                return head;
            }
            head = head.getNext();
        }

        return null;
    }

    // 查找单链表倒数第K(k>0)个节点
    // 使用两个指针，先让前面的指针走到正向第k个结点，这样前后两个指针的距离差是k-1，之后前后两个指针一起向前走，前面的指针走到最后一个结点时，后面指针所指结点就是倒数第k个结点
    private static Node getKNode2(Node head, int k) {
        Node p = head;
        Node q = head;

        while (k > 1 && p != null) {
            p = p.getNext();
            k--;
        }

        while (k > 1 || p == null) {
            return null;
        }

        // 前后两个指针一起走，直到前面的指针指向最后一个节点  
        while (p.getNext() != null) {
            p = p.getNext();
            q = q.getNext();
        }

        // 当前面的指针指向最后一个节点时，后面的指针指向倒数k个节点  
        return q;
    }

    // 递归打印出倒数第k位的值
    static int level = 0;

    private static void reGetKthNodeRec(Node head, int k) {

        if (head == null) {
            return;
        }
        
        if (k == 1) {
            return;
        }

        reGetKthNodeRec(head.getNext(), k);
        level++;
        if (level == k) {
            System.out.println(head.getVal());
        }
    }
    
    /**
     * 查找单链表的中间结点  
     * 
     * 此题可应用于上一题类似的思想。也是设置两个指针，只不过这里是，两个指针同时向前走，前面的指针每次走两步，后面的指针每次走一步， 
     * 前面的指针走到最后一个结点时，后面的指针所指结点就是中间结点，即第（n/2+1）个结点。注意链表为空，链表结点个数为1和2的情况。时间复杂度
     * @param head
     * @return
     */
    private static Node getMiddleNode(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        
        Node p = head;
        Node q = head;
        
        // p指针每次走两步，直到指向最后一个结点，q指针每次走一步 
        while (p.getNext() != null) {
            p = p.getNext();
            q = q.getNext();
            if (p.getNext() != null) {
                p = p.getNext();
            }
        }
        
        return q;
    }
    
    /**
     * 从尾到头打印单链表 
     * 
     * 对于这种颠倒顺序的问题，我们应该就会想到栈，后进先出。所以，这一题要么自己使用栈，要么让系统使用栈，也就是递归。注意链表为空的情况。时间复杂度为O（n） 
     * @param head
     */
    private static void reversePrintNodeList1(Node head) {
        Stack<Node> s = new Stack<>();
        while (head != null) {
            s.push(head);
            head = head.getNext();
        }
        
        while (!s.isEmpty()) {
            Node n = s.pop();
            System.out.print(n.getVal() + " ");
        }
        
        System.out.println();
    }
    
    /**
     * 从尾到头打印链表，使用递归（优雅！）
     * @param head
     */
    private static void reversePrintNodeList2(Node head) {
        if (head == null) {
            return;
        }
        
        reversePrintNodeList2(head.getNext());
        System.out.print(head.getVal() + " ");
    }
    
    /** 
     * 已知两个单链表pHead1 和pHead2 各自有序，把它们合并成一个链表依然有序 
     * 这个类似归并排序。尤其注意两个链表都为空，和其中一个为空时的情况。只需要O（1）的空间。时间复杂度为O（max(len1, len2)） 
     */ 
    private static Node mergeSortedNodeList1(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        
        if (head2 == null) {
            return head1;
        }
        
        Node mergedHead = null;
        
        // 先确定下来mergeHead是在哪里  
        if (head1.getVal() < head2.getVal()) {
            mergedHead = head1;
            head1 = head1.getNext(); // 跳过已经合并了的元素 
        } else {
            mergedHead = head2;
            head2 = head2.getNext();
        }
        
        // 断开mergeHead和后面的联系  
        mergedHead.setNext(null);
        
        Node mergeCur = mergedHead;
        while (head1 != null && head2 != null) {
            if (head1.getVal() < head2.getVal()) {
                mergeCur.setNext(head1);
                head1 = head1.getNext();
            } else {
                mergeCur.setNext(head2);
                head2 = head2.getNext();
            }
            mergeCur = mergeCur.getNext();
            mergeCur.setNext(null);
        }
        
        // 合并剩余的元素
        if (head1 != null) {
            mergeCur.setNext(head1);
        } else if (head2 != null) {
            mergeCur.setNext(head2);
        }
        
        return mergedHead;
    }
    
    /** 
     * 递归合并两链表（优雅！） 
     */  
    private static Node mergeSortedNodeList2(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        
        if (head2 == null) {
            return head1;
        }
        
        Node mergedHead = null;
        if (head1.getVal() < head2.getVal()) {
            mergedHead = head1;
            mergedHead.setNext(mergeSortedNodeList2(head1.getNext(), head2));
        } else {
            mergedHead = head2;
            mergedHead.setNext(mergeSortedNodeList2(head1, head2.getNext()));
        }
        return mergedHead;
    }
    
    /**
     * 判断一个单链表中是否有环
     * 这里也是用到两个指针。如果一个链表中有环，也就是说用一个指针去遍历，是永远走不到头的。因此，我们可以用两个指针去遍历，一个指针一次走两步
     * ，一个指针一次走一步，如果有环，两个指针肯定会在环中相遇。时间复杂度为O（n）
     */
    public static boolean hasCycle(Node head) {
        Node fast = head; // 快指针每次前进两步
        Node slow = head; // 慢指针每次前进一步

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) { // 相遇，存在环
                return true;
            }
        }
        return false;
    }
    
    /** 判断两个单链表是否相交  
     * 如果两个链表相交于某一节点，那么在这个相交节点之后的所有节点都是两个链表所共有的。 也就是说，如果两个链表相交，那么最后一个节点肯定是共有的。 
     * 先遍历第一个链表，记住最后一个节点，然后遍历第二个链表， 到最后一个节点时和第一个链表的最后一个节点做比较，如果相同，则相交， 
     * 否则不相交。时间复杂度为O(len1+len2)，因为只需要一个额外指针保存最后一个节点地址， 空间复杂度为O(1) 
     */  
    public static boolean isIntersect(Node head1, Node head2) {  
        if (head1 == null || head2 == null) {  
            return false;  
        }  
  
        Node tail1 = head1;  
        // 找到链表1的最后一个节点  
        while (tail1.getNext() != null) {  
            tail1 = tail1.getNext();  
        }  
  
        Node tail2 = head2;  
        // 找到链表2的最后一个节点  
        while (tail2.getNext() != null) {  
            tail2 = tail2.getNext();  
        }  
  
        return tail1 == tail2;  
    }  
    
    /** 
     * 求两个单链表相交的第一个节点 对第一个链表遍历，计算长度len1，同时保存最后一个节点的地址。 
     * 对第二个链表遍历，计算长度len2，同时检查最后一个节点是否和第一个链表的最后一个节点相同，若不相同，不相交，结束。 
     * 两个链表均从头节点开始，假设len1大于len2 
     * ，那么将第一个链表先遍历len1-len2个节点，此时两个链表当前节点到第一个相交节点的距离就相等了，然后一起向后遍历，直到两个节点的地址相同。 
     * 时间复杂度，O(len1+len2) 
     *  
     *              ----    len2 
     *                   |__________ 
     *                   | 
     *       ---------   len1 
     *       |---|<- len1-len2 
     */  
    public static Node getFirstCommonNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = 1;
        Node tail1 = head1;
        while (tail1.getNext() != null) {
            tail1 = tail1.getNext();
            len1++;
        }

        int len2 = 1;
        Node tail2 = head2;
        while (tail2.getNext() != null) {
            tail2 = tail2.getNext();
            len2++;
        }

        // 不相交直接返回NULL
        if (tail1 != tail2) {
            return null;
        }

        Node n1 = head1;
        Node n2 = head2;

        // 略过较长链表多余的部分
        if (len1 > len2) {
            int k = len1 - len2;
            while (k != 0) {
                n1 = n1.getNext();
                k--;
            }
        } else {
            int k = len2 - len1;
            while (k != 0) {
                n2 = n2.getNext();
                k--;
            }
        }

        // 一起向后遍历，直到找到交点
        while (n1 != n2) {
            n1 = n1.getNext();
            n2 = n2.getNext();
        }

        return n1;
    }
    
    /**
     * 求进入环中的第一个节点 用快慢指针做（本题用了Crack the Coding Interview的解法，因为更简洁易懂！）
     */
    public static Node getFirstNodeInCycle(Node head) {
        Node slow = head;
        Node fast = head;

        // 1） 找到快慢指针相遇点
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) { // Collision
                break;
            }
        }

        // 错误检查，这是没有环的情况
        if (fast == null || fast.getNext() == null) {
            return null;
        }

        // 2）现在，相遇点离环的开始处的距离等于链表头到环开始处的距离，
        // 这样，我们把慢指针放在链表头，快指针保持在相遇点，然后
        // 同速度前进，再次相遇点就是环的开始处！
        slow = head;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        // 再次相遇点就是环的开始处
        return fast;
    }
    
    /**
     * 求进入环中的第一个节点 用HashMap做
     *  一个无环的链表，它每个结点的地址都是不一样的。
     * 但如果有环，指针沿着链表移动，那这个指针最终会指向一个已经出现过的地址 以地址为哈希表的键值，每出现一个地址，就将该键值对应的实值置为true。
     * 那么当某个键值对应的实值已经为true时，说明这个地址之前已经出现过了， 直接返回它就OK了
     */
    public static Node getFirstNodeInCycleHashMap(Node head) {
        HashMap<Node, Boolean> map = new HashMap<Node, Boolean>();
        while (head != null) {
            if (map.get(head) == true) {
                return head; // 这个地址之前已经出现过了，就是环的开始处
            } else {
                map.put(head, true);
                head = head.getNext();
            }
        }
        return head;
    }
    
    /**
     * 给出一单链表头指针head和一节点指针toBeDeleted，O(1)时间复杂度删除节点tBeDeleted
     * 对于删除节点，我们普通的思路就是让该节点的前一个节点指向该节点的下一个节点
     * ，这种情况需要遍历找到该节点的前一个节点，时间复杂度为O(n)。对于链表，
     * 链表中的每个节点结构都是一样的，所以我们可以把该节点的下一个节点的数据复制到该节点
     * ，然后删除下一个节点即可。要注意最后一个节点的情况，这个时候只能用常见的方法来操作，先找到前一个节点，但总体的平均时间复杂度还是O(1)
     */
    public void delete(Node head, Node toDelete) {
        if (toDelete == null) {
            return;
        }
        if (toDelete.getNext() != null) { // 要删除的是一个中间节点
            toDelete.setVal(toDelete.getNext().getVal()); // 将下一个节点的数据复制到本节点!
            toDelete.setNext(toDelete.getNext().getNext());
        } else { // 要删除的是最后一个节点！
            if (head == toDelete) { // 链表中只有一个节点的情况
                head = null;
            } else {
                Node node = head;
                while (node.getNext() != toDelete) { // 找到倒数第二个节点
                    node = node.getNext();
                }
                node.setNext(null);
            }
        }
    }
}
