package lesson_2026_05_15;
import java.util.*;
class Payment {
    private FoodItem[] fi = new FoodItem[100];
    private int fiCount;
    private static double foodTax = 0.2;  // 20% sales tax added to all food prices

    private DrinkItem[] di = new DrinkItem[100];
    private int diCount;
    private static double drinkTax = 0.1; // 10% sales tax added to all drink prices

    public Payment() {
        fiCount = 0;
        diCount = 0;
    }

    public DrinkItem getDi(int x) {
        return di[x];
    }

    public FoodItem getFi(int x) {
        return fi[x];
    }

    public int getDiCount() {
        return diCount;
    }

    public int getFiCount() {
        return fiCount;
    }

    public double getDrinkTax() {
        return drinkTax;
    }

    public static double getFoodTax() {
        return foodTax;
    }

    public void addFoodItem(FoodItem foodItem) {
        fi[fiCount] = foodItem;
        fiCount++;
    }

    public void addDrinkItem(DrinkItem drinkItem){
        di[diCount] = drinkItem;
        diCount++;
    }

    public static double findPrice(Item[] pl, String c) {
        int i = 0;
        while (i < pl.length) {
            if (pl[i].getCode().equals(c)) {
                return pl[i].getPrice();
            }
            i++;
        }
        return 0.0;
    }

    public double calculateBill(Item[] pl) {
        double total = 0.0;

        for (int i = 0; i < fiCount; i++) {
            double price = findPrice(pl, fi[i].getItemCode());
            total += price * fi[i].getQuantity() * (1 + foodTax);
        }

        for (int i = 0; i < diCount; i++) {
            double price = findPrice(pl, di[i].getItemCode());
            total += price * di[i].getQuantity() * (1 + drinkTax);
        }

        return total;
    }
}

class Item {
    private String code; // item code
    private String name; // item name
    private double price; // unit price before tax

    void setName(String name) {
        this.name = name;
    }

    void setCode(String code) {
        this.code = code;
    }

    void setPrice(double price) {
        this.price = price;
    }

    String getCode() {
        return code;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }


}

class FoodItem {
    private String itemCode;
    private int quantity;

    public FoodItem(String x, int y) {
        itemCode = x;
        quantity = y;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemCode(String x) {
        itemCode = x;
    }

    public void setQuantity(int x) {
        quantity = x;
    }
}

class DrinkItem {
    private String itemCode;
    private int quantity;

    public DrinkItem(String x, int y) {
        itemCode = x;
        quantity = y;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemCode(String x) {
        itemCode = x;
    }

    public void setQuantity(int x) {
        quantity = x;
    }
}

public class Restaurant {
    public static void changePrice(LinkedList<Item> priceLL, String code, double newPrice) {
        boolean found = false;
        for (int i = 0; i < priceLL.size(); i++) {
            if (priceLL.get(i).getCode().equals(code)) {
                priceLL.get(i).setPrice(newPrice);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item with code " + code + " not found.");
        }
    }

    public static void main(String[] args) {
        Payment[] tables = new Payment[50];
        tables[1] = new Payment();
        tables[2] = new Payment();
        FoodItem a = new FoodItem("f102", 2);
        FoodItem b = new FoodItem("f100", 1);
        DrinkItem c = new DrinkItem("d102", 3);
        tables[1].addFoodItem(a);
        tables[1].addFoodItem(b);
        tables[2].addDrinkItem(c);
        tables[2].addDrinkItem(new DrinkItem("d103",1));
        System.out.println(tables[1].getFiCount());
        System.out.println(Payment.getFoodTax());
        System.out.println(tables[2].getDi(1).getItemCode());
        System.out.println(tables[40].getFiCount()+tables[40].getDiCount());
        System.out.println(tables[2].getFi(2).getItemCode());
    }
}
