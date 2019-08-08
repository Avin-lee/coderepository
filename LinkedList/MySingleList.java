// 不带头非循环单链表的实现：
public class MySingleList implements ILinked {

    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    public MySingleList(){
        this.head = null;
    }
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
        }else{
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    // 判断index的合法性：
    private void checkIndex(int index){
        if(index < 0 || index > getLength()){
            throw new UnsupportedOperationException("index不合法！");
        }
    }
    // 找到index-1的位置并返回该节点位置的引用
    private Node searchIndex(int index){
        int count = 0;
        Node cur = this.head;
        while(count < index - 1){
            count++;
            cur = cur.next;
        }
        return cur;
    }
    @Override
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        if(index == 0){
            addFirst(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    // 查找key的前驱节点
    private Node searchPre(int key){
        Node cur = this.head;
        if(cur.data == key){
            return this.head;
        }
        while(cur.next != null){
            if(cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    @Override
    public int remove(int key) {
        int oldData = 0;
        Node pre = searchPre(key);
        if(pre == null){
            throw new UnsupportedOperationException("不存在key节点！");
        }
        if(pre == this.head && this.head.data == key){
            oldData = pre.data;
            this.head = this.head.next;
            return oldData;
        }
        oldData = pre.next.data;
        pre.next = pre.next.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        if(this.head == null){
            throw new UnsupportedOperationException("链表为空！");
        }
        Node cur = this.head;
        if(cur.data == key){
            this.head = cur.next;
        }
        while(cur.next != null){
            if(cur.next.data == key){
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
    }

    @Override
    public int getLength() {
            Node cur = this.head;
            int count = 0;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        if(this.head == null){
            throw new UnsupportedOperationException("链表为空！");
        }
        while(this.head != null){
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;
        }
    }
    public Node reverseList(){
        Node cur = this.head;                // Node cur = this.head;
        Node pre = null;                     // Node pre = null;
        Node reverseHead = null;             // Node reverseHead = null;
        while(cur != null){                  // while(cur != null){
            Node curNext = cur.next;         //     Node curNext = cur.next;
            if(curNext == null){             //     if(curNext == null){
                reverseHead = cur;           //         reverseHead = cur;
            }                                //     }
            cur.next = pre;                  //     cur.next = pre;
            pre = cur;                       //     pre = cur;
            cur = curNext;                   //     cur = curNext;
        }                                    // }
        return reverseHead;                  // return reverseHead;
    }
    public static void show(Node reverseHead){
        Node cur = reverseHead;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public  Node middleNode(){
        Node cur = this.head;
        int count = 0;
        while(count != getLength()/2){
            count++;
            cur = cur.next;
        }
        return cur;
    }
    public Node findKthToTail(int k){
        Node fast = this.head;
        Node slow = this.head;
        if(k <= 0 || k > getLength() || fast == null){
            System.out.println("请输入合法节点");
            return null;
        }
        int count = 0;
        while(count < k-1){
            count++;
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node partition(int x){
        Node oneStart = null;
        Node oneEnd = null;
        Node twoStart = null;
        Node twoEnd = null;
        Node pHead = this.head;
        while (pHead != null){
            if(pHead.data < x){
                if(oneStart == null){
                    oneStart = pHead;
                    oneEnd = pHead;
                }else{
                    oneEnd.next = pHead;
                    oneEnd = pHead;
                }
            }else{
                if(twoStart == null){
                    twoStart = pHead;
                    twoEnd = pHead;
                }else{
                    twoEnd.next = pHead;
                    twoEnd = pHead;
                }
            }
            pHead = pHead.next;
        }
        if(oneEnd == null){
            return twoStart;
        }
        oneEnd.next = twoStart;
        return oneStart;
    }
    public void createCycle(){
        Node cur = this.head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }
    public boolean hasCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public Node detectCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        slow = this.head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
            }
        return slow;
    }

    public Node deleteDuplication(){
        Node newHead = new Node(-1);
        Node tmpHead = newHead;
        Node cur = this.head;
        while (cur != null) {
            if(cur.next != null &&
                    cur.data == cur.next.data) {
                //cur所指向的节点是一个重复的节点
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
                //cur--->
                newHead.next = cur;
                //在这个地方应该串起---》 2 2 3 3
            }else {
                //没有找到重复的节点
                newHead.next = cur;
                newHead = cur;
                cur = cur.next;
            }
        }
        return tmpHead.next;
    }
    public boolean chkPalindrome(){
        if(this.head == null) {
            return false;
        }else if(this.head.next == null) {
            return true;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node p = slow.next;
        Node pNext = p.next;
        while(p != null) {
            p.next = slow;
            slow = p;
            p = pNext;
            if(p != null) {
                pNext = p.next;
            }
        }
        while(head != slow) {
            if(head.data != slow.data) {
                return false;
            }
            if(head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public void createCut(Node headA,Node headB){
        headA.next.next = headB.next.next;
    }

    public Node getIntersectionNode(Node headA, Node headB){
        Node pLong = headA;
        Node pShort = headB;
        int lenA = 0;
        while(pLong != null) {
            lenA++;
            pLong = pLong.next;
        }
        int lenB = 0;
        while(pShort != null) {
            lenB++;
            pShort = pShort.next;
        }
        pLong = headA;
        pShort = headB;

        int myLen = lenA-lenB;

        if(myLen < 0) {
            pLong = headB;
            pShort = headA;
            myLen = lenB-lenA;
        }
        for (int i = 0; i < myLen; i++) {
            pLong = pLong.next;
        }

        //起点相同了
        while (pLong != null && pShort != null && pLong != pShort) {
            pLong = pLong.next;
            pShort = pShort.next;
        }
        if(pLong == pShort && pLong != null && pShort != null){
            return pLong;
        }
        return null;
    }

    public Node mergeTwoLists(Node headA,Node headB){
        Node newHead = new Node(-1);
        Node tmpHead = newHead;
        while(headA != null && headB != null) {
            if(headA.data >= headB.data) {
                newHead.next = headB;
                newHead = headB;
                headB = headB.next;
            }else {
                newHead.next = headA;
                newHead = headA;
                headA = headA.next;
            }
        }
        if(headA != null) {
            newHead.next = headA;
        }
        if(headB != null) {
            newHead.next = headB;
        }
        return tmpHead.next;
    }

    public static void main(String[]args){
        // 单链表的测试：
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(5);
        mySingleList.addFirst(4);
        mySingleList.addFirst(3);
        mySingleList.addFirst(2);
        mySingleList.addFirst(1);
        mySingleList.addFirst(0);
        mySingleList.addLast(6);
        mySingleList.addLast(7);
        mySingleList.display();
        //Node node = mySingleList.middleNode();
        //System.out.println(node.data);
        //Node node1 = mySingleList.findKthToTail(3);
        //System.out.println(node1.data);
        mySingleList.createCycle();
        System.out.println(mySingleList.hasCycle());
        Node node2 = mySingleList.detectCycle();
        System.out.println(node2.data);
        //mySingleList.addLast(0);
        //mySingleList.addLast(0);
        //mySingleList.display();
        //mySingleList.addIndex(7,-1);
        //mySingleList.display();
        //System.out.println(mySingleList.remove(-1));
        //mySingleList.display();
        //mySingleList.removeAllKey(0);
        //mySingleList.display();
        //System.out.println(mySingleList.contains(7));
        //System.out.println(mySingleList.getLength());
        //mySingleList.clear();
        //mySingleList.display();
        //MySingleList.Node res = mySingleList.reverseList();
        //show(res);

    }
}
