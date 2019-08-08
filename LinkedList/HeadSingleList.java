

// 带头循环单链表的实现：
public class HeadSingleList implements ICLinked {
    //节点类
    class Node{
        private int data;
        private Node next;
        public Node(){
            this.data = -1;
        }
        public Node(int data){
            this.data = data;
        }
    }
    private Node head;
    public HeadSingleList(){
        this.head = new Node();
        this.head.next = this.head;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next;
        this.head.next = node;
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        while(cur.next != this.head){
            cur = cur.next;
        }
        node.next = this.head;
        cur.next = node;
    }
    // 找到index-1的位置:
    private Node searchIndex(int index){
        Node cur = this.head;
        int count = 0;
        while(count < index){
            count++;
            cur = cur.next;
        }
        return cur;
    }
    // 判断index的合法性：
    private void checkIndex(int index){
        if(index < 0 || index > getLength()){
            throw new UnsupportedOperationException("下标不合法！");
        }
    }
    @Override
    public boolean addindex(int index, int data) {
        checkIndex(index);
        Node pre = searchIndex(index);
        Node node = new Node(data);
        node.next = pre.next;
        pre.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head.next;
        while(cur != this.head){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //找要删除的节点的前驱节点，如果找不到，返回空
    private Node searchPre(int key){
        Node pre = this.head;
        while(pre.next != this.head){
            if(pre.next.data == key){
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }
    @Override
    public int remove(int key) {
        Node pre = searchPre(key);
        if(pre == null){
            throw new UnsupportedOperationException("没有key这个关键字！");
        }
        int oldData = pre.next.data;
        pre.next = pre.next.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        Node cur = this.head.next;
        Node pre = this.head;
        while(cur != this.head){
            if(cur.data == key){
                pre.next = cur.next;
                cur = cur.next;
                continue;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head.next;
        while(cur != this.head){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head.next;
        while(cur != this.head){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        //防止内存泄露
        while(this.head.next != this.head){
            Node cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }
    public static void main(String[]args){
        HeadSingleList headSingleList = new HeadSingleList();
        headSingleList.addFirst(4);
        headSingleList.addFirst(3);
        headSingleList.addFirst(2);
        headSingleList.addFirst(1);
        headSingleList.addFirst(0);
        headSingleList.addLast(5);
        headSingleList.addLast(6);
        headSingleList.display();
        headSingleList.addindex(0,-1);
        headSingleList.addindex(8,-1);
        headSingleList.addindex(3,-1);
        headSingleList.addindex(5,-1);
        headSingleList.display();
        //System.out.println(headSingleList.remove(1));
        headSingleList.removeAllKey(-1);
        headSingleList.display();
        //System.out.println(headSingleList.contains(6));
        //System.out.println(headSingleList.getLength());
        //headSingleList.clear();
    }
}
