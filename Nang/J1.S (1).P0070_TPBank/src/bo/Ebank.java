/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import data.Data;
import entity.Account;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import utils.IConstant;

/**
 *
 * @author win
 */
public class Ebank {

    private ResourceBundle bundle;

    public Ebank() {
        setLocate(new Locale("en", "US"));
    }

    public void setLocate(Locale locale) {
        bundle = ResourceBundle.getBundle("resources/Language", locale);
    }

    public String checkAccountNumber(String accountNumber) {
        if (accountNumber.matches(IConstant.ACCOUNT_NUMBER)) {
            return null;
        } else {
            return bundle.getString("accountInvalid");
        }
    }

    public String checkPassword(String password) {
        if (password.matches(IConstant.PASSWORD)) {
            return null;
        } else {
            return bundle.getString("passwordInvalid");
        }
    }

    public String generateCaptcha() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < IConstant.CAPTCHA_LENGTH; i++) {
            captcha.append(characters.charAt(random.nextInt(characters.length())));
        }
        return captcha.toString();
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaInput.trim().isEmpty()) {
            return bundle.getString("captchaInvalid");
        }
        if (captchaGenerate.contains(captchaInput)) {
            return null;
        } else {
            return bundle.getString("captchaInvalid");
        }
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        String accountNumber, password, captchaInput;
        String result;
        //Nhap account
        do {
            System.out.print(bundle.getString("account"));
            accountNumber = sc.nextLine();
            result = checkAccountNumber(accountNumber);
            if (result == null) {
                break;
            } else {
                System.out.println(result);
            }
        } while (true);
        //Nhap password
        do {
            System.out.print(bundle.getString("password"));
            password = sc.nextLine();
            result = checkPassword(password);
            if (result == null) {
                break;
            } else {
                System.out.println(result);
            }
        } while (true);
        //Nhap captcha
        String captchaGenerate = generateCaptcha();
        System.out.println(bundle.getString("captcha") + captchaGenerate);
        do {
            System.out.print(bundle.getString("inputCaptcha"));
            captchaInput = sc.nextLine();
            result = checkCaptcha(captchaInput, captchaGenerate);
            if (result == null) {
                break;
            } else {
                System.out.println(result);
            }
        } while (true);
        //Xac thuc authen
        if (authentication(accountNumber, password)) {
            System.out.println(bundle.getString("loginSuccess"));
        } else {
            System.out.println(bundle.getString("loginFailed"));
        }

    }

    private boolean authentication(String account, String password) {
        for (Account a : Data.listAccount) {
            if (account.equals(a.getAccount()) && password.equals(a.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
