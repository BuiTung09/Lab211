package services;

import dto.FruitRequestDTO;
import dto.FruitResponseDTO;
import model.Fruit;
import model.Order;
import model.OrderItem;
import repository.FruitRepository;
import java.util.ArrayList;
import java.util.Hashtable;

public class FruitService {

    private FruitRepository repo = new FruitRepository();

    public ArrayList<FruitResponseDTO> getListFruit() {
        ArrayList<FruitResponseDTO> responseList = new ArrayList<>();
        for (Fruit f : repo.getListFruit()) {
            responseList.add(new FruitResponseDTO(
                    f.getFruitId(), f.getFruitName(), f.getPrice(), f.getQuantity(), f.getOrigin()
            ));
        }
        return responseList;
    }

    public Hashtable<String, ArrayList<Order>> getListOrder() {
        return repo.getListOrder();
    }

    // Create
    public void createFruit(FruitRequestDTO request) {
        Fruit fruit = new Fruit(
                request.getFruitId(), request.getFruitName(),
                request.getPrice(), request.getQuantity(), request.getOrigin()
        );
        repo.addFruit(fruit);
    }

    //update
    public void updateFruitQuantity(String fruitId, int newQuantity) {
        for (Fruit f : repo.getListFruit()) {
            if (f.getFruitId().equalsIgnoreCase(fruitId)) {
                f.setQuantity(newQuantity);
                break;
            }
        }
    }

    // mua hàng
    public void deductFruitQuantity(String fruitId, int quantityToDeduct) {
        for (Fruit f : repo.getListFruit()) {
            if (f.getFruitId().equalsIgnoreCase(fruitId)) {
                f.setQuantity(f.getQuantity() - quantityToDeduct);
                break;
            }
        }
    }

    // Trả hàng
    public void restoreFruitQuantity(String fruitId, int quantityToRestore) {
        for (Fruit f : repo.getListFruit()) {
            if (f.getFruitId().equalsIgnoreCase(fruitId)) {
                f.setQuantity(f.getQuantity() + quantityToRestore);
                break;
            }
        }
    }

    // Lưu order
    public void submitOrder(String customerName, ArrayList<OrderItem> cart) {
        Order newOrder = new Order(cart); // Tạo một đối tượng Order chứa ngày giờ và list item
        Hashtable<String, ArrayList<Order>> listOrder = repo.getListOrder();

        if (listOrder.containsKey(customerName)) {
            listOrder.get(customerName).add(newOrder);
        } else {
            ArrayList<Order> listBills = new ArrayList<>();
            listBills.add(newOrder);
            repo.putOrder(customerName, listBills);
        }
    }

    // Xử lý giỏ hàng
    public void addToCart(ArrayList<OrderItem> cart, FruitResponseDTO chosenFruit, int buyQuantity) {

        deductFruitQuantity(chosenFruit.getFruitId(), buyQuantity);

        boolean fruitInCart = false;
        for (OrderItem o : cart) {
            if (o.getFruitId().equalsIgnoreCase(chosenFruit.getFruitId())) 
            {
                o.setQuantity(o.getQuantity() + buyQuantity);
                fruitInCart = true;
                break;
            }
        }

        if (!fruitInCart) {
            cart.add(new OrderItem(chosenFruit.getFruitId(), chosenFruit.getFruitName(), buyQuantity, chosenFruit.getPrice()));
        }
    }

    public void rollbackCart(ArrayList<OrderItem> cart) {
        for (OrderItem o : cart) {
            restoreFruitQuantity(o.getFruitId(), o.getQuantity());
        }
    }

    public boolean checkFruitIdExist(String id) {
        for (Fruit f : repo.getListFruit()) {
            if (f.getFruitId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public FruitResponseDTO getFruitById(String id) {
        for (Fruit f : repo.getListFruit()) {
            if (f.getFruitId().equalsIgnoreCase(id)) {
                // Trả về DTO để Controller hiển thị
                return new FruitResponseDTO(f.getFruitId(), f.getFruitName(), f.getPrice(), f.getQuantity(), f.getOrigin());
            }
        }
        return null; // Trả về null nếu không tìm thấy (dù ta đã check ID tồn tại trước đó rồi)
    }
}
