 /** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLList {	
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
			/*System.out.println(size);*/
		}
	} 

	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;

	private static void lectureQuestion() {
		SLList L = new SLList();
		IntNode n = new IntNode(5, null);
	}

	/** Creates an empty SLList. */
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}
	/** sentinel包含一个一定会存在的默认节点作为开始 */
	public SLList(int x) {
		sentinel = new IntNode(0, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	 public SLList(int[] xn) {
		 sentinel = new IntNode(0, null);
		 sentinel.next =  new IntNode(xn[0], null);
		 size = 1;
		 IntNode p = sentinel.next;
		 for(int i = 1; i < xn.length; i++){
			 p.next = new IntNode(xn[i], null);
			 size += 1;
			 p = p.next;
		 }

	 }

 	/** Adds x to the front of the list. */
 	public void addFirst(int x) {
 		sentinel.next = new IntNode(x, sentinel.next);
 		size = size + 1;
 	}

 	/** Returns the first item in the list. */
 	public int getFirst() {
 		return sentinel.next.item;
 	}

 	/** Adds x to the end of the list. */
 	public void addLast(int x) {
 		size = size + 1;
 		IntNode p = sentinel;

 		/* Advance p to the end of the list. */
 		while (p.next != null) {
 			p = p.next;
 		}

 		p.next = new IntNode(x, null);
 	}
 	
 	/** Returns the size of the list. */
 	public int size() {
 		return size;
 	}
	/** Delete the first element in your SLList*/
	public void deleteFirst(){
		sentinel.next = sentinel.next.next;
	}

	public static void main(String[] args) {
 		/* Creates a list of one integer, namely 10 */
 		SLList L = new SLList(15);
 		L.addLast(20);
		L.addLast(30);
		L.addFirst(10);
		L.deleteFirst();
		int[] xn = new int[3];
		xn[0] = 1;
		xn[1] = 2;
		xn[2] = 3;
		SLList Larr = new SLList(xn);
 		System.out.println(Larr.size());
 	}
}