package controller;

import constants.Message;
import dto.FruitRequestDTO;
import dto.FruitResponseDTO;
import model.OrderItem;
import services.FruitService;
import view.FruitView;
import java.util.ArrayList;
import view.Input;

public class FruitController {

    private FruitService service = new FruitService();
    private FruitView view = new FruitView();

    // 1 create
    public void createFruit() {
        while (true) {
            FruitRequestDTO request = new FruitRequestDTO();
            while (true) {
                String id = Input.inputString("Nhập id: ");
                if (!service.checkFruitIdExist(id)) {
                    request.setFruitId(id);
                    break;
                }
                view.showMessage(Message.TRUNG_ID, true);
            }
            request.setFruitName(Input.inputString("Nhập tên: "));
            request.setPrice(Input.inputDoubleMin("Nhập giá: ", 0));
            request.setQuantity(Input.inputIntMin("Nhập số lượng: ", 0));
            request.setOrigin(Input.inputString("Nhập xuất xứ: "));
            service.createFruit(request);
            view.showMessage(Message.CREATE, false);

            if (!Input.twoOption(Message.CONTINUE, "Y", "N")) {
                break;
            }
        }
    }

    // 2 update fruit
    public void updateFruit() {
        ArrayList<FruitResponseDTO> listFruit = service.getListFruit();
        if (listFruit.isEmpty()) {
            view.showMessage(Message.KHO_RONG, true);
            return;
        }

        while (true) {
            displayFruitList();
            String id = Input.inputString("Nhập Fruit ID cần update (Nhập x để về MENU): ");
            if (id.equals("x")) {
                view.showMessage(Message.HUY_THAO_TAC, false);
                return;
            }

            if (service.checkFruitIdExist(id)) {
                FruitResponseDTO fruitToUpdate = service.getFruitById(id);

                int currentQuantity = fruitToUpdate.getQuantity();
                view.showMessage("-> Số lượng hiện tại của [" + fruitToUpdate.getFruitName() + "] là: " + currentQuantity, false);

                int quantityChange = Input.inputIntMin("Nhập số lượng mới: ", 0);

                service.updateFruitQuantity(id, quantityChange);
                view.showMessage("Đã cập nhật thành công! Số lượng mới: " + (currentQuantity + quantityChange), false);

            } else {
                boolean wantToCreate = Input.twoOption("Fruit ID không tồn tại. Bạn có muốn tạo sản phẩm mới không? Yes(Y) hoặc No(N)", "Y", "N");

                if (wantToCreate) {
                    view.showMessage("--- Chuyển hướng sang Tạo mới sản phẩm ---", false);
                    createFruit();
                    return;
                } else {
                    view.showMessage("Hủy thao tác update. Trở về màn hình chính.", false);
                    return;
                }
            }
        }
    }

    // 3 xem order
    public void viewOrders() {
        // Kiểm tra xem hệ thống đã có đơn hàng nào chưa
        if (service.getListOrder().isEmpty()) {
            view.showMessage(Message.ORDER_RONG, true);
            return;
        }
        view.displayCustomerOrders(service.getListOrder());
    }

    // 4 shopping
    public void shopping() {
        ArrayList<FruitResponseDTO> listFruit = service.getListFruit();
        ArrayList<OrderItem> cart = new ArrayList<>();
        if (listFruit.isEmpty()) {
            view.showMessage(Message.HET_HANG, true);
            return;
        }
        while (true) {
            displayFruitList();
            int choice = Input.inputInt("Chọn loại trái cây cần mua (chọn 0 để thoát hoặc đến thanh toán)", 0, listFruit.size());
            if (choice == 0) {
                break;
            }
            FruitResponseDTO chosenOne = listFruit.get(choice - 1);
            if (chosenOne.getQuantity() == 0) {
                view.showMessage(Message.HET_HANG, true);
                continue;
            }
            view.showMessage("Bạn đã chọn mua: " + chosenOne.getFruitName(), true);
            int buyQuantity = Input.inputInt("Chọn số lượng cần mua (ấn 0 để hủy)", 0, chosenOne.getQuantity());
            if (buyQuantity == 0) {
                view.showMessage(Message.HUY_THAO_TAC, false);
                continue;
            }
            chosenOne.setQuantity(chosenOne.getQuantity() - buyQuantity);
            service.addToCart(cart, chosenOne, buyQuantity);
            view.displayCart(cart);
            if (Input.twoOption(Message.THANH_TOAN, "Y", "N")) {
                break;
            }
        }
        //thanh toán
        processCheckout(cart);
    }

    // Hàm 2: Chuyên xử lý việc chốt đơn hoặc hủy giỏ hàng
    private void processCheckout(ArrayList<OrderItem> cart) {
        if (cart.isEmpty()) {
            view.showMessage(Message.CHUA_MUA, false);
            return;
        }
        view.displayCart(cart);

        boolean wantToCheckout = Input.twoOption("Bạn có thực sự muốn thanh toán giỏ hàng này không? Yes(Y) hoặc No(N)", "Y", "N");

        if (wantToCheckout) {
            String nameCustomer = Input.inputString("Nhập tên của bạn: ").toUpperCase();
            submitOrder(nameCustomer, cart);
        } else {
            // Giao logic hoàn trả kho lại cho Service
            service.rollbackCart(cart);
            view.showMessage(Message.HUY_DON_HANG, false);
        }
    }

    public void displayFruitList() {
        view.displayFruitList(service.getListFruit());
    }

    public void submitOrder(String customerName, ArrayList<OrderItem> cart) {
        service.submitOrder(customerName, cart);
        view.showMessage(Message.THANH_TOAN_THANH_CONG, false);
    }
}
