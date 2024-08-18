import java.util.*;
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Before sorting : ");
        System.out.println(Arrays.toString(arr));
        QuickSorting(arr);
        System.out.println("After sorting : ");
        System.out.println(Arrays.toString(arr));
    }
    static void QuickSorting(int[] arr){
           QuickSorting(arr,0,arr.length-1);
    }
    static void QuickSorting(int[] arr,int low,int high){
        if(low<high){
            int j = partition(arr, low, high);
            QuickSorting(arr,low,j-1);
            QuickSorting(arr,j+1,high);
        }
    }
    static int partition(int[] arr,int s,int e){
        int pivot = arr[s];
        int i = s;
        int j = e;
        while(i<j){
            while (i<=e&&arr[i]<=pivot) {
                i++;
            }
            while (j>=s&&arr[j]>pivot) {
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if(i>=j){
            int temp = arr[j];
            arr[j] = arr[s];
            arr[s] = temp;
        }
        return j;
    }
}
