import java.util.*;
class Item{
    double weight;
    double profit;
    double weightprofit_ratio;
    public Item(double weight,double profit){
        this.weight = weight;
        this.profit = profit;
        this.weightprofit_ratio = (this.profit / this.weight);
    }
}
public class KnapSack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of objects : ");
        int object_count = sc.nextInt();
        Item[] objects = new Item[object_count];
        System.out.println("Enter capacity of KnapSack : ");
        int m = sc.nextInt();
        System.out.println("Enter the objects details : ");
        for(int i = 0;i<object_count;i++){
            System.out.println("Enter weight : ");
            double wght = sc.nextDouble();
            System.out.println("Enter profit : ");
            double prft = sc.nextDouble();
            objects[i] = new Item(wght, prft);
        }
        for (Item item : objects){
            System.out.println("{" + item.weight + " " + item.profit + " " + item.weightprofit_ratio + "}");
         }
         System.out.println();
        bubblesort(objects);
        for (Item item : objects){
            System.out.println("{" + item.weight + " " + item.profit + " " + item.weightprofit_ratio + "}");
        }
        System.out.println();
        int ans = (int)fractionalKnapsack(objects,m);
        System.out.println(ans);
    }
    static double fractionalKnapsack(Item[] objects,int m){
        double totalProfit = 0;
        double current_capacity = 0;
        int remainingCapacity = m;
        for (Item item : objects) {
            if (remainingCapacity == 0) {
                break;
            }
            
            if (item.weight <= remainingCapacity) {
                // Take the whole item
                totalProfit += item.profit;
                remainingCapacity -= item.weight;
            } else {
                // Take the fraction of the item
                totalProfit += item.profit * (remainingCapacity/item.weight);
                remainingCapacity = 0; // Knapsack is full
            }
        }
        return totalProfit;
    }
    static void bubblesort(Item[] items){
        for (int i = 0; i < items.length-1; i++) {
            for (int j = 1; j < items.length-i; j++) {
                if(items[j].weightprofit_ratio>items[j-1].weightprofit_ratio){
                    Item temp = items[j];
                    items[j]  = items[j-1];
                    items[j-1] = temp;
                }
            }
        }
    }
}