import java.util.Scanner;

public class Triplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int triplet_count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if(arrayContains(arr,sum)){
                    triplet_count++;
                }
            }
        }
        System.out.println(triplet_count);
    }

    static boolean arrayContains(int[] arr,int sum) {
         for (int i = 0; i < arr.length; i++) {
            if(arr[i]==sum){
                return true;
            }
         }
         return false;
       }
    }

