import com.sun.corba.se.impl.interceptors.InterceptorList;

public class SLListMe {
    /** the private keyword is an invaluable signal that
     * certain pieces of code should be
     * ignored (and thus need not be understood) by the end user.
     * private对于外部使用的用户而言是看不到的，用户不知道有个属性叫first
     * public表示公共的，在其他类就可以被访问，private只能是在本类 */

    private IntNode first;
    // 如果IntNode从来不用 SLList定义的东西，可以把这个设置成static
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public SLListMe(int x) {
        first = new IntNode(x, null);
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
        // 此处的first是对应新建立的IntNode的地址（reference）
        /*IntNode addr = new IntNode(x, first);
        first = addr;*/
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        IntNode p = first;
        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x,null);
    }

    // naked 有一个指针在移动
    public static int size(IntNode p){
        if (p.next == null){
            return 1;
        }
        return 1 + size(p.next);
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLListMe L = new SLListMe(3);
        L.addLast(4);
        L.addLast(5);
        L.addFirst(2);
        L.addFirst(1);
        System.out.println(size(L.first));
    }
}