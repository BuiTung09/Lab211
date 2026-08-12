/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bill;

public class DiscountBill extends GroceryBill {

    private boolean preferred;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);

        this.preferred = preferred;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }


    @Override
    public void add(Item item) {
        if (item == null) {
            return;
        }
        super.add(item);

        if (preferred && item.getDiscount() > 0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }


    @Override
    public double getTotal() {
        return super.getTotal() - getDiscountAmount();
    }

    public int getDiscountCount() {
        if (!preferred) {
            return 0;
        }

        return discountCount;
    }

    public double getDiscountAmount() {
        if (!preferred) {
            return 0.0;
        }

        return discountAmount;
    }

    public double getDiscountPercent() {
        double originalTotal = super.getTotal();

        if (!preferred || originalTotal == 0) {
            return 0.0;
        }

        return getDiscountAmount() / originalTotal * 100;
    }

    @Override
    public void printReceipt() {
        super.printReceipt();

        System.out.println("============= DISCOUNT INFORMATION =========");
        System.out.println("Preferred customer: "
                + (preferred ? "Yes" : "No"));

        System.out.println("Discounted items: "
                + getDiscountCount());

        System.out.printf("Discount amount: $%.2f%n",
                getDiscountAmount());

        System.out.printf("Discount percent: %.2f%%%n",
                getDiscountPercent());

        System.out.printf("Final total: $%.2f%n",
                getTotal());

        System.out.println("============================================");
    }
}
