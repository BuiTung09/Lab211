/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Task;
import entity.TaskType;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author win
 */
public class TaskInputer {

    public static Task input() {
        //NGAY HIEN TAI
        Date currentDate = new Date();
        //DATE MIN CAN BE INPUT
        Calendar calendar = Calendar.getInstance();
        calendar.set(1950, Calendar.JANUARY, 01);
        Date minDate = calendar.getTime();
        String requirementName = Validator.getString("Requirement Name: ",
                "Invalid!", "[A-Za-z0-9\\s]+");
        TaskType taskType = TaskType.getTaskTypeByID(Validator.getInt("Please enter 1->4\n"
                + "ID  Name\n"
                + "1.Code\n"
                + "2.Test\n"
                + "3.Design\n"
                + "4.Review \n"
                + "Enter your choice: ", "Just be 1->4", "Invalid!", 1, 4));
        Date date = Validator.getDate("Date: ",
                "Error range! Not exceed current Date !",
                "Invalid! Format dd-mm-yyyy", "dd-MM-yyyy",
                minDate, currentDate);
        double planFrom;
        while (true) {
            planFrom = Validator.getDouble("From:",
                    "Just be between form 8 -> 17.0",
                    "Please enter real number!",
                    8, 17);
            if (planFrom * 10 % 5 == 0) {
                break;
            } else {
                System.out.println("Must be x.0 or x.5");
            }
        }
        double planTo;
        while (true) {
             planTo = Validator.getDouble("To:",
                    "Just be large than " + (planFrom + 0.5) + " and less than 17.5",
                    "Please enter real number!", (planFrom + 0.5), 17.5);
            if (planFrom * 10 % 5 == 0) {
                break;
            } else {
                System.out.println("Must be x.0 or x.5");
            }
        }
        String assignee = Validator.getString("Assignee: ",
                "Invalid!", "[A-Za-z0-9\\s]+");
        String reviewer = Validator.getString("Reviewer: ",
                "Invalid!", "[A-Za-z0-9\\s]+");
        //Gan ID mac dinh la 1 ,no se tu tang thoi :D
        return new Task(1,taskType, requirementName, date, planFrom, planTo, assignee, reviewer);
    }
}
