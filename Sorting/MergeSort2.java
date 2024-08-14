// package ADS.Sorting;
import java.util.*;
public class MergeSort2 {
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
        MergeSorting(arr,0,n-1);
        System.out.println("After sorting : ");
        System.out.println(Arrays.toString(arr));
    }
    static void MergeSorting(int[] arr,int low,int high){
        if(low<high){
            int mid = (low + high)/2;
            MergeSorting(arr, low, mid);
            MergeSorting(arr, mid+1, high);
            Merge(arr,low,mid,high);
        }
    }
    static void Merge(int[] arr,int low,int mid,int high){
        int[] merged = new int[(high-low) + 1];
        int k = 0;
        int i = low;
        int j = mid + 1;
        while (i<=mid&&j<=high) {
            if(arr[i]<arr[j]){
                merged[k] = arr[i];
                i = i + 1;
                k = k + 1;
            }else{
                merged[k] = arr[j];
                j = j + 1;
                k = k + 1;
            }
        }
        while(i<=mid){
            merged[k] = arr[i];
            i++;
            k++;
        }
        while(j<=high){
            merged[k] = arr[j];
            j++;
            k++;
        }
        for(int h = 0;h<merged.length;h++){
             arr[low+h] = merged[h];
        }
        // // System.out.println(Arrays.toString(merged));
    }
}
