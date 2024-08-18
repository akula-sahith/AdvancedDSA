import java.util.Scanner;

public class MaxAndMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
           arr[i] = sc.nextInt();  
        }
        int[] ans = findmaxandmin(arr,0,n-1);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    static int[] findmaxandmin(int[] arr, int s, int e) {
       if(s==e){
        int[] ans = new int[2];
        ans[0] = arr[s];
        ans[1] = arr[e];
        return ans;
       }

       if(s==(e-1)){
        int[] ans = new int[2];
        if(arr[s]>arr[e]){
            ans[0] = arr[s];
            ans[1] = arr[e];
        }else{
            ans[0] = arr[e];
            ans[1] = arr[s];
        }
        return ans;
       }

       int mid = (s+e)/2;
       int[] max1 = findmaxandmin(arr, s, mid);
       int[] max2 = findmaxandmin(arr, mid+1, e);

       if(max1[0]<max2[0]){
        max1[0] = max2[0];
       }
       
       if(max1[1]>max2[1]){
        max1[1] = max2[1];
       }

       return max1;
    }
}
