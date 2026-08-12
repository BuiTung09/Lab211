/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Person;
import model.Wallet;
import view.ShoppingView;

/**
 *
 * @author Tuan Tran
 */
public class ShoppingController {
    public void run() {
        ShoppingView view = new ShoppingView();
        System.out.println("======= Shopping program ==========");
        int numberOfBills = view.getNumberOfBills();
        int[] bills = new int[numberOfBills];
        for (int i = 0; i < numberOfBills; i++) {
            bills[i] = view.getBillValue(i);
        }
        int walletAmount = view.getWalletValue();

        Person person = new Person(bills, new Wallet(walletAmount));
        view.showResult(person.calcTotal(), person.canPay());
    }
}