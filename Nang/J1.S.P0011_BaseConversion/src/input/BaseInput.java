/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package input;

import entity.Base;
import entity.BaseNumber;
import utils.Validator;
import utils.Validator;

/**
 *
 * @author thuha
 */
public class BaseInput {

    private Base base;
    private String number;

    public BaseNumber input() throws Exception {
        int choice = Validator.getInt("1 for Binary, 2 for Decimal, 3 for Hexadecimal\n"
                + "Enter choice: ", "Just 1->3", "Invalid!!", 1, 3);
        switch (choice) {
            case 1:
                base = Base.BIN;
                number = Validator.getString("enter number: ", "Invalid!!!", "[01]+");

                break;
            case 2:
                base = Base.DEC;
                number = Validator.getString("enter number: ", "Invalid!!!", "[0-9]+");

                break;
            case 3:
                base = Base.HEX;
                number = Validator.getString("enter number: ", "Invalid!!!", "[0-9A-F]+");

                break;
            default:
                throw new AssertionError();
        }
        return new BaseNumber(base, number);
    }

}
