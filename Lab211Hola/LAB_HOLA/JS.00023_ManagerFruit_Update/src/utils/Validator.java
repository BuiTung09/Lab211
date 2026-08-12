/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author thuha
 */
public class Validator {
   // khai bao thuoc tinh phai de private de dam bao tinh dong goi
   // vi nó dùng nên dung static để nhanh
   // final hang so ko thang nao co the thay doi dc
   // SCANNER hang so nen vt hoa 
    private static final Scanner SCANNER = new Scanner(System.in);
    public static int getInt(String messageInfo, String messErrorOutOfRange, 
            String messageErrorNumber, int min , int max){
        do {            
            try {
                System.out.print(messageInfo);
                //tranh loi troi lenh convet "1234"-->1234
                int number = Integer.parseInt(SCANNER.nextLine());
                if(number>=min&&number<=max){
                    return number;
                }
                else{
                    System.out.println(messErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
        
    }
    public static double getDouble(String messageInfo, String messErrorOutOfRange, 
         String messageErrorNumber, double min , double max){
        do {            
            try {
                System.out.print(messageInfo);
                double number = Double.parseDouble(SCANNER.nextLine());
                if(number>=min&&number<=max){
                    return number;
                }
                else{
                    System.out.println(messErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
    }
    public static String getString(String messageInfo, String messageError,
            final String REGEX){
        do {            
            try {
                System.out.print(messageInfo);
                //String str = SCANNER.nextLine();
                //nhap se --> SE
                String str = SCANNER.nextLine().toUpperCase();
                if(str.matches(REGEX)){
                    return str;
                }
                else{
                    System.out.println(messageError);
                }
            } catch (Exception e) {
                System.out.println(messageError);
            }
        } while (true);
        
    }
    public static String getString1(String messageInfo, String messageError, final String REGEX){
        do {            
            System.out.print(messageInfo);
            String str = SCANNER.nextLine();
            if(str.matches(REGEX)){
                return str;
            }
            else{
                System.out.println(messageError);
            }
        } while (true);
    }
     public static String getName(String messageInfo, String messageError,
            final String REGEX){
        do {            
            try {
                System.out.print(messageInfo);
                String str = SCANNER.nextLine();
                String arr[]=str.split("\\s+");
                String newStr="";
                if(str.matches(REGEX)){
                    for (int i = 0; i < arr.length; i++) {
                        newStr+=arr[i].substring(0, 1).toUpperCase()+
                           arr[i].substring(1).toLowerCase()+" ";
                    }
                    
                    return newStr.replaceAll("\\s+", " ");
                }
                else{
                    System.out.println(messageError);
                }
            } catch (Exception e) {
                System.out.println(messageError);
            }
        } while (true);
        
    }
     public static Date getDate(String messageInfo, String messageErrorOutOfRange,
      String messageErrorDate , final String REGEX,Date min, Date max){
         SimpleDateFormat dateFormat = new SimpleDateFormat(REGEX);
         dateFormat.setLenient(false);
         do {             
             try {
                 System.out.print(messageInfo);
                 Date date = dateFormat.parse(SCANNER.nextLine());
                 if(date.compareTo(min)>=0&&date.compareTo(max)<=0){
                    return date;
                 }
                 else{
                     System.out.println(messageErrorOutOfRange);
                 }
             } catch (ParseException e) {
                 System.out.println(messageErrorDate);
             }
         } while (true);
     }
}
