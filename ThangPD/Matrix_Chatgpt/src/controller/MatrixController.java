package controller;

import dto.MatrixRequestDTO;
import dto.MatrixResponseDTO;
import service.MatrixService;
import ui.MatrixView;
import utils.Validator;

/**
 *
 * @author win
 */
public class MatrixController {

    private final MatrixService service;
    private final MatrixView view;

    public MatrixController() {
        service = new MatrixService();
        view = new MatrixView();
    }

    public void run() {
        while (true) {
            int choice = Validator.getInt(
                    "========= Calculator Program =========\n"
                    + "1. Addition Matrix\n"
                    + "2. Subtraction Matrix\n"
                    + "3. Multiplication Matrix\n"
                    + "4. Exit\n"
                    + "Enter your choice: ",
                    "Choice must be from 1 to 4.",
                    "Please enter integer!",
                    1,
                    4);
            switch (choice) {

                case 1:
                case 2:
                case 3:
                    execute(choice);
                    break;

                case 4:
                    return;

            }

        }

    }

    private void execute(int choice) {
        try {
            MatrixRequestDTO request = view.inputMatrix(choice);
            MatrixResponseDTO response = null;

            switch (choice) {
                case 1:
                    response = service.add(request);
                    break;
                case 2:
                    response = service.subtract(request);
                    break;
                case 3:
                    response = service.multiply(request);
                    break;
            }
           view.display(response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}