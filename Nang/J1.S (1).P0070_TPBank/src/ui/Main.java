/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bo.Ebank;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Tuan Tran
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        while (true) {
            Ebank ebank = new Ebank();
            int choice = getInt("-------Login Program-------\n"
                    + "1. Vietnamese\n"
                    + "2. English\n"
                    + "3. Exit\n"
                    + "Please choice one option:", "Must be 1->3", "Invalid!", 1, 3);
            switch (choice) {
                case 1:
                    ebank.setLocate(new Locale("vi", "VN"));
                    break;
                case 2:
                    ebank.setLocate(new Locale("en", "US"));
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
            ebank.login();
        }
    }

    public static int getInt(String messageInfo, String messsageErrorOutOfRange,
            String messageErrorNumber, int min, int max) {
        Scanner SCANNER = new Scanner(System.in);
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println(messsageErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
    }
}
