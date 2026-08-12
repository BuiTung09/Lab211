/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author win
 */
public enum BMI {
    UNDER_STANDARD("UNDER STANDARD"), STANDARD("STANDARD"),OVER_WEIGHT("OVER WEIGHT"),
    FAT("FAT"),VERY_FAT("VERY FAT");
    private String value;

    private BMI(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
