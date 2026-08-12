package view;

import dto.FruitResponseDTO;
import java.util.ArrayList;
import java.util.Hashtable;
import model.Order;
import model.OrderItem;

public class FruitView {

    public void showMessage(String msg, boolean error) {
        if (error == false) {
            System.out.println(msg);
        }
        if (error == true) {
            System.err.println(msg);
        }
    }

    public void displayFruitList(ArrayList<FruitResponseDTO> listFruit) {
        System.out.println("\n--- DANH SÁCH TRÁI CÂY ---");
        System.out.printf("|  %-4s  |  %-5s  |  %-8s  |  %-6s  |    %-10s  |  %-6s  |\n", "Item", "Fruit ID", "Fruit Name", "Quantity", "Origin", "Price");

        for (int i = 0; i < listFruit.size(); i++) {
            FruitResponseDTO f = listFruit.get(i);

            if (f.getQuantity() > 0) {
                System.out.printf("    %-8d %-12s %-15s %-12d %-14s %.2f$\n",
                        (i + 1), f.getFruitId(), f.getFruitName(), f.getQuantity(), f.getOrigin(), f.getPrice());
            }
        }
    }

    // In toàn bộ lịch sử mua hàng của TẤT CẢ khách hàng có trong hệ thống
    public void displayCustomerOrders(Hashtable<String, ArrayList<Order>> listOrder) {
        System.out.println("\n--- TẤT CẢ LỊCH SỬ MUA HÀNG ---");
        for (String customerName : listOrder.keySet()) {
            System.out.println("\nCustomer: " + customerName);

            ArrayList<Order> listBills = listOrder.get(customerName);

            for (int i = 0; i < listBills.size(); i++) {
                Order currentBill = listBills.get(i);

                // In thêm ngày giờ mua hàng
                System.out.println("--- Order " + (i + 1) + " (" + currentBill.getOrderDate() + ") ---");
                System.out.printf("%-10s  | %-7s  | %-5s  | %-5s\n", "Product", "Quantity", "Price", "Amount");

                double totalAmount = 0;
                int itemNo = 1;

                // Duyệt qua danh sách OrderItem trong bill
                for (OrderItem o : currentBill.getOrderItems()) {
                    System.out.printf("%d. %-12s %-10d %.0f$       %.0f$\n",
                            itemNo++, o.getFruitName(), o.getQuantity(), o.getPrice(),
                            o.getAmount());
                            totalAmount += o.getAmount();
                }
                System.out.printf("Total: %.0f$\n", totalAmount);
            }
        }
    }

    // Hiển thị giỏ hàng hiện tại (chứa OrderItem) trước khi chốt đơn
    public void displayCart(ArrayList<OrderItem> cart) {
        System.out.println("GIỎ HÀNG CỦA BẠN");
        System.out.printf("%-10s | %-10s | %-7s | %-7s\n", "Product", "Quantity", "Price", "Amount");
        double totalAmount = 0;

        for (OrderItem o : cart) {
            System.out.printf("%-15s %-10d %.0f$       %.0f$\n",
                    o.getFruitName(), o.getQuantity(), o.getPrice(), o.getAmount());
            totalAmount += o.getAmount();
        }
        System.out.printf("Total: %.0f$\n", totalAmount);
    }
}
