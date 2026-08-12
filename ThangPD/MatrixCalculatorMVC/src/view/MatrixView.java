package view;

import constants.Message;
import dto.MatrixResponseDTO;

/**
 * Chứa ResponseDTO, việc hiển thị kết quả xử lý trên console
 * thực hiện ở đây. Không được gọi print ngoài View và Main.
 */
public class MatrixView {

    public void display(MatrixResponseDTO response) {
        System.out.println(response.getTitle());

        if (!response.isSuccess()) {
            System.out.println(response.getErrorMessage());
            return;
        }

        System.out.println(Message.TITLE_RESULT);
        System.out.print(response.getMatrix1().toString());
        System.out.println(response.getOperatorSymbol());
        System.out.print(response.getMatrix2().toString());
        System.out.println(Message.OP_EQUAL);
        System.out.println(response.getResult().toString());
    }
}
