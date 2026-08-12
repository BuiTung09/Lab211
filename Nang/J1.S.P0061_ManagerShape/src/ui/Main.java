/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Circle;
import entity.Rectangle;
import entity.Shape;
import entity.Triangle;
import utils.Validator;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            System.out.println("=====Calculator Shape Program=====");
            double width = Validator.getDouble("Please input side width of Rectangle: ",
                    "Please enter number >0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
            double length = Validator.getDouble("Please input side length of Rectangle: ",
                    "Please enter number >= " + width, "Invalid!", width, Double.MAX_VALUE);
            Shape rectangle = new Rectangle(width, length);
            double radius = Validator.getDouble("Please input radius of Circle:",
                    "Please enter number >0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
            Shape circle = new Circle(radius);
            double sideA = Validator.getDouble("Please input side A of Triangle: ",
                    "Please enter number >0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
            double sideB = Validator.getDouble("Please input side B of Triangle: ",
                    "Please enter number >0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
            double sideC = Validator.getDouble("Please input side C of Triangle: ",
                    "Please enter number >0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
            Shape triangle = new Triangle(sideA, sideB, sideC);
            Shape shapes[] = {rectangle, circle, triangle};
            for (int i = 0; i < shapes.length; i++) {
                shapes[i].printResult();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
