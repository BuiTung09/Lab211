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
public class Wallet {
    private int amount;

    public Wallet(int amount) {
        this.amount = amount;
    }

    public boolean payMoney(int total) {
        return amount >= total;
    }

    public int getAmount() {
        return amount;
    }
}
