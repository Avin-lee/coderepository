
//不带头的双向链表：
public class DoubleLinkedList implements IDoubleLinked {
    //节点内部类：
    class Node{
        //节点属性：数据域、节点前驱、节点后继。
        private int data;
        private Node next;
        private Node prev;
        //节点的构造方法： this.data = data; 前驱后继都置空；
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    // 不带头的双向链表的属性：头、尾节点；
    private Node head;
    private Node last;
    // 不带头的双向链表的构造方法：头、尾都置空；
    public DoubleLinkedList(){
        this.head = null;
        this.last = null;
    }
    @Override
    // 头插法：
    // 1.先得到一个要插入的节点数据域为data；
    // 2.如果链表为空，让其头尾节点都指向此节点；
    // 3.如果链表不为空，让node的next指向head，head的前驱指向node，head指向node。
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    @Override
    // 尾插法：
    // 1.先得到一个要插入的节点数据域为data；
    // 2.如果链表为空，让其头尾节点都指向此节点；
    // 3.如果链表不为空，让last的next指向node，node的前驱指向last，last指向node。
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
            //this.last = this.last.next;   //两种方法all欧克
        }
    }
    // （为addIndex（）服务）找到并返回要插入位置的节点：
    private Node searchIndex(int index){
        Node cur = this.head;
        int count = 0;
        while(count < index){
            count++;
            cur = cur.next;
        }
        return cur;
    }
    // （为addIndex（）服务）检查下标是否合法：
    private void checkIndex(int index){
        if(index < 0 || index > getLength()){
            throw new UnsupportedOperationException("下标不合法");
        }
    }
    @Override
    // 给定索引位置插入：
    // 1.用checkIndex（）判断插入的index是否合法；
    // 2.如果要插入位置的index为0的话--->头插法；
    // 3.如果要插入位置为链表的长度的话--->尾插法；
    // 4.用searchIndex（）找到要插入位置index的节点cur；（先绑后边）
    // 让node的next指向cur的prev的next、node的prev指向cur的prev、cur的prev的next指向node、cur的prev指向cur的prev的next；
    public boolean addindex(int index, int data) {
        checkIndex(index);
        if(index == 0){
            addFirst(data);
            return true;
        }
        if(index == getLength()){
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur.prev.next;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = cur.prev.next;
        return true;
    }

    @Override
    // 判断链表是否包含key元素的节点：
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

    @Override
    // 删除链表中第一个出现key元素的节点：
    // 1.定义一个cur节点指向head，进入循环体当cur = null时退出，在循环体内，当cur的data = key时，
    //   定义一个oldData来保存要删除的节点值。并判断：如果该节点是head，则让head指向head的next、head的prev指向null；
    //   如果该节点不是head，让cur的prev的next指向cur的next，并判断：如果cur的next不为null，让cur的next的prev指向cur的prev；
    //   否则：则让last指向cur；
    // 2.在第一个if预计结尾返回要保存的oldData值；
    // 3.在没有进去第一个if语句时就表明这个这个值不是key，要cur = cur.next;
    // 4.如果当while循环走完了还没有return oldData的值得话，证明链表中没有要删除的key值，此时返回 -1 以示没有要删除的key值。
    public int remove(int key) {
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                int oldData = cur.data;
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else{
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{
                        this.last = cur.prev;
                    }
                }
                return oldData;
            }
            cur = cur.next;
        }
        return -1;
    }

    @Override
    // 删除链表中所有出现key元素的节点：
    // 1.定义一个cur节点指向head，进入循环体当cur = null时退出，在循环体内，当cur的data = key时，
    //   定义一个oldData来保存要删除的节点值。并判断：如果该节点是head，则让head指向head的next、head的prev指向null；
    //   如果该节点不是head，让cur的prev的next指向cur的next，并判断：如果cur的next不为null，让cur的next的prev指向cur的prev；
    //   否则：则让last指向cur；
    // 3.在没有进去第一个if语句时就表明这个这个值不是key，要cur = cur.next;
    // 4.如果当while循环走完了的话就证明我们已经删除了所有要删除的key节点了。
    public void removeAllKey(int key) {
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else{
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    @Override
    // 获得链表的长度：
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while(cur != null){
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
    // 把链表清空：
    public void clear() {
        while(this.head.next != null){
            Node cur = this.head.next;
            this.head.next = cur.next;
            cur.prev = null;
        }
        this.head = null;
        this.last = null;
    }
    public static void main(String[]args) throws InterruptedException {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(0);
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(5);
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.getLength());
        doubleLinkedList.addindex(0,-1);
        doubleLinkedList.addindex(7,-1);
        doubleLinkedList.addindex(3,-1);
        doubleLinkedList.remove(0);
        doubleLinkedList.removeAllKey(-1);
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.contains(-3));
        doubleLinkedList.clear();
        doubleLinkedList.display();
    }
}
