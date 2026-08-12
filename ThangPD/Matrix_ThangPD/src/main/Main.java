package main;

import constants.Constants;
import constants.Message;
import controller.MatrixController;
import dto.MatrixRequestDTO;
import utils.Validation;
import java.util.Scanner;

/**
 * Chứa work flow chính, chỉ làm việc với Validation và Controller.
 * Scanner chỉ được sử dụng ở đây.
 */
public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final MatrixController CONTROLLER = new MatrixController();

    public static void main(String[] args) {
        while (true) {
            int choice = getValidInt(Message.MENU, Message.ERROR_MENU_RANGE,
                    Message.ERROR_NOT_INTEGER, Constants.MIN_MENU_CHOICE, Constants.MAX_MENU_CHOICE);

            Constants.MenuChoice menuChoice = Constants.MenuChoice.fromCode(choice);
            if (menuChoice == null) {
                continue;
            }

            switch (menuChoice) {
                case ADDITION:
                    CONTROLLER.handleAddition(buildRequest(choice));
                    break;
                case SUBTRACTION:
                    CONTROLLER.handleSubtraction(buildRequest(choice));
                    break;
                case MULTIPLICATION:
                    CONTROLLER.handleMultiplication(buildRequest(choice));
                    break;
                case QUIT:
                    System.exit(0);
                    break;
            }
        }
    }

    private static MatrixRequestDTO buildRequest(int choice) {
        MatrixRequestDTO request = new MatrixRequestDTO();
        request.setChoice(choice);
        request.setMatrix1Data(inputMatrixData(1));
        request.setMatrix2Data(inputMatrixData(2));
        return request;
    }

    private static int[][] inputMatrixData(int matrixNumber) {
        int rows = getValidInt(Message.enterRow(matrixNumber), Message.ERROR_DIMENSION_RANGE,
                Message.ERROR_NOT_INTEGER, Constants.MIN_DIMENSION, Constants.MAX_DIMENSION);
        int cols = getValidInt(Message.enterCol(matrixNumber), Message.ERROR_DIMENSION_RANGE,
                Message.ERROR_NOT_INTEGER, Constants.MIN_DIMENSION, Constants.MAX_DIMENSION);

        int[][] data = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = getValidInt(Message.enterElement(matrixNumber, i + 1, j + 1),
                        Message.ERROR_DIMENSION_RANGE, Message.ERROR_NOT_INTEGER,
                        Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return data;
    }

    /**
     * Đọc input từ Scanner (chỉ Main mới được làm việc này),
     * dùng Validation (utils) để kiểm tra tính hợp lệ.
     */
    private static int getValidInt(String prompt, String rangeErrorMsg,
            String formatErrorMsg, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine();

            if (!Validation.isInteger(input)) {
                System.out.println(formatErrorMsg);
                continue;
            }

            int value = Integer.parseInt(input.trim());
            if (!Validation.isInRange(value, min, max)) {
                System.out.println(rangeErrorMsg);
                continue;
            }

            return value;
        }
    }
}
