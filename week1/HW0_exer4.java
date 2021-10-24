public class HW0_exer4 {
    public static void windowPosSum(int[] a, int n) {
        /** your code here */
        for (int i = 0; i < a.length; i += 1) {
            if(a[i]<0)  continue;
            for(int j = 1;j<=n;j+=1) {
                if (i+j>=a.length) break;
                else a[i] +=a[i + j];
            }
        }
    }

    public static void main(String[] args) {
//        int[] a = {1, 2, -3, 4, 5, 4};
//        int n = 3;
        // Should print 4, 8, -3, 13, 9, 4
        int[] a = {1, -1, -1, 10, 5, -1};
        int n = 2;
        //we’d get {-1, -1, -1, 14, 4, -1}
        windowPosSum(a, n);


        System.out.println(java.util.Arrays.toString(a));



    }
}