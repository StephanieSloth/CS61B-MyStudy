public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion!用递归 */
    public int size() {
        if (rest == null) {
            return 1;
        }
        /**到这步之后就去执行size(),直到有值返回
        返回size()的值，返回几次加几个1 */
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the ith item of this IntList. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    public static IntList incrList(IntList L, int x) {
        /* 新建一个链表 */
        if (L == null){
            return null;
        }
        IntList head = new IntList(L.first + x,null);
        IntList Q = head;
        while (L.rest != null){
            L = L.rest;
            Q.rest = new IntList(L.first + x,null);
            Q = Q.rest;
        }
        return head;
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        IntList temp = L; // 复制一个reference，改动原本的链表
        while (temp != null){
            temp.first += x;
            temp = temp.rest;
         }
        return L;
    }


    /** We want to add a method to IntList so that if 2 numbers in a row are the same,
     * we add them together and  make one large node.
     * For example:
     * 1 -> 1 -> 2 -> 3 becomes 2 -> 2 -> 3 which becomes 4 -> 3*/
    public void addAdjacent(){
        IntList p = this;
        while (p.rest != null) {
            if (p.first == p.rest.first){
                p.first += p.rest.first;
                p.rest = p.rest.rest;
            } else {
                p = p.rest;
            }
        }
    }


    public static void dSquareList(IntList L) {
        while (L != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(3, null);
        L = new IntList(2, L);
        L = new IntList(1, L);
        L = new IntList(1, L);
        L = new IntList(3, L);
        L.addAdjacent();
        System.out.println(L.iterativeSize());
        System.out.println(L.get(1));
        System.out.println(incrList(L, 3));
        System.out.println(dincrList(L, 3));
        //IntList origL = IntList.of(1, 2, 3);
        //dSquareList(origL);
        // origL is now (1, 4, 9)
    }
}