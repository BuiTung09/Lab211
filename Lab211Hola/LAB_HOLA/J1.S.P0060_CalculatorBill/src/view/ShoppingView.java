/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import utils.Validator;

/**
 *
 * @author Tuan Tran
 */
public class ShoppingView {
    public int getNumberOfBills() {
        return Validator.getInt("Input number of bill: ", "Out of range!", "Invalid number!", 1, 100);
    }

    public int getBillValue(int i) {
        return Validator.getInt("Input value of bill " + (i + 1) + ": ", "Out of range!", "Invalid number!", 1, Integer.MAX_VALUE);
    }

    public int getWalletValue() {
        return Validator.getInt("Input value of wallet: ", "Out of range!", "Invalid number!", 1, Integer.MAX_VALUE);
    }

    public void showResult(int total, boolean canPay) {
        System.out.println("\nThis is total of bill: " + total);            
        System.out.println(canPay ? "You can buy it." : "You can’t buy it.");
    }
}

