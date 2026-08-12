package controller;

import constants.Message;
import dto.MatrixRequestDTO;
import dto.MatrixResponseDTO;
import services.MatrixServices;
import view.MatrixView;

/**
 * Controller - nhận input (RequestDTO) từ Main, điều hướng hoạt động
 * của Services và View. Chỉ import DTO, View, Services.
 */
public class MatrixController {

    private final MatrixServices matrixServices;
    private final MatrixView matrixView;

    public MatrixController() {
        this.matrixServices = new MatrixServices();
        this.matrixView = new MatrixView();
    }

    public void handleAddition(MatrixRequestDTO request) {
        handle(request, Message.TITLE_ADDITION, Message.OP_ADD);
    }

    public void handleSubtraction(MatrixRequestDTO request) {
        handle(request, Message.TITLE_SUBTRACTION, Message.OP_SUBTRACT);
    }

    public void handleMultiplication(MatrixRequestDTO request) {
        handle(request, Message.TITLE_MULTIPLICATION, Message.OP_MULTIPLY);
    }

    private void handle(MatrixRequestDTO request, String title, String operatorSymbol) {
        MatrixResponseDTO response = new MatrixResponseDTO();
        response.setTitle(title);
        response.setOperatorSymbol(operatorSymbol);
        try {
            var matrix1 = matrixServices.buildMatrix(request.getMatrix1Data());
            var matrix2 = matrixServices.buildMatrix(request.getMatrix2Data());
            var result = switch (operatorSymbol) {
                case Message.OP_ADD ->
                    matrixServices.add(request.getMatrix1Data(), request.getMatrix2Data());
                case Message.OP_SUBTRACT ->
                    matrixServices.subtract(request.getMatrix1Data(), request.getMatrix2Data());
                case Message.OP_MULTIPLY ->
                    matrixServices.multiply(request.getMatrix1Data(), request.getMatrix2Data());
                default ->
                    throw new Exception("Unsupported operator");
            };
            response.setSuccess(true);
            response.setMatrix1(matrix1);
            response.setMatrix2(matrix2);
            response.setResult(result);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        matrixView.display(response);
    }
}
