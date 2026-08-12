/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import utils.Validator;

/**
 *
 * @author win
 */
public class BMICalculator {

    private double height;
    private double weight;
    private double bmi;
    public BMICalculator(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public BMICalculator() {
    }

    public double getBmi() {
        return bmi;
    }

    public BMI calculateBMI() {
        bmi = weight / (height * height);
        if (bmi < 19) {
            return BMI.UNDER_STANDARD;
        } else if (bmi < 25) {
            return BMI.STANDARD;
        } else if (bmi < 30) {
            return BMI.OVER_WEIGHT;
        } else if (bmi < 40) {
            return BMI.FAT;
        } else {
            return BMI.VERY_FAT;
        }
    }

    public void input() {
        weight = Validator.getDouble("Enter Weight(kg): ", 
                "Just be >0", "BMI is digit", Double.MIN_VALUE,
                Double.MAX_VALUE);
        height = Validator.getDouble("Enter Height(cm): ",
                "Just be >0", "BMI is digit", Double.MIN_VALUE,
                Double.MAX_VALUE);
        
        height=height/100;
    }
}
