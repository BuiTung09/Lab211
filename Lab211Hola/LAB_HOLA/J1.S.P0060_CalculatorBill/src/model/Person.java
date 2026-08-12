/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author win
 */
public class Person {
    private Wallet wallet;
    private int[] bills;

    public Person(int[] bills, Wallet wallet) {
        this.bills = bills;
        this.wallet = wallet;
    }

    public int calcTotal() {
        int total = 0;
        for (int bill : bills) {
            total += bill;
        }
        return total;
    }

    public boolean canPay() {
        return wallet.payMoney(calcTotal());
    }

    public int[] getBills() {
        return bills;
    }
}
