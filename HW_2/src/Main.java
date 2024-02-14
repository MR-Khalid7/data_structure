import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static boolean compare(int[] A, int[] B) {
        return Arrays.equals(A, B);
    }

    static ArrayList<Integer> clone(int[] arr) {
        ArrayList<Integer> prototype = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            prototype.add(arr[i]);
        }
        return prototype;
    }

    static int[] remove(int[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        int[] res = new int[arr.length - 1];
        System.arraycopy(arr, 0, res, 0, index);
        System.arraycopy(arr, index + 1, res, index, arr.length - index - 1);
        return res;
    }


    public static void main(String[] args) {
        Scanner a=new Scanner(System.in);
        int [] arr1={1,2,3,5,23,4,7,1};
        int [] arr2={3,0,4,3,4,7,89,7,6};
        System.out.println(compare(arr1,arr2));
        System.out.println(clone(arr2));
        remove(arr1 , 4);
        for (int j : arr1) {
            System.out.print(j+" ");
        }
    }
}