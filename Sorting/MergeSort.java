package Sorting;

// package ADS.Sorting;
import java.util.*;
public class MergeSort {
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
        System.out.println("After sorting : ");
        System.out.println( MergeSorting(arr));
    }
    static int[] MergeSorting(int[] arr){
        if(low==high){
           return arr;
        }
        int mid = (0 + (arr.length - 1))/2;
        int[] left = MergeSorting(Arrays.copyOfRange(arr,0, mid+1));
        int[] right = MergeSorting(Arrays.copyOfRange(arr, mid+1, arr.length));
        int[] combined = Merge(left,right);
        return combined;
    }
    static int[] Merge(int[] left,int[] right){
        int[] merged = new int[left.length + right.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i<=mid&&j<=high) {
            if(left[i]<right[j]){
                merged[k] = left[i];
                i = i + 1;
                k = k + 1;
            }else{
                merged[k] = right[j];
                j = j + 1;
                k = k + 1;
            }
        }
        while(i<=mid){
            merged[k] = left[i];
            i++;
            k++;
        }
        while(j<=high){
            merged[k] = right[j];
            j++;
            k++;
        }
        return merged;
    }
}
