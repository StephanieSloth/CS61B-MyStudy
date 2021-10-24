public class HW0_exer2 {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int max_num = 0;
        int cnt = 0;
        while(cnt<6){
            if (m[cnt] >max_num){
                max_num =m[cnt];
            }
            cnt = cnt+1;
        }
        return max_num;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
    }
}

