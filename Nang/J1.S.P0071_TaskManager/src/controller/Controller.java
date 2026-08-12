/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Task;
import entity.TaskType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import utils.Validator;

/**
 *
 * @author win
 */
public class Controller {

    private ArrayList<Task> list;
    private int lastId;

    public Controller() {
        list = new ArrayList<>();
    }

    public ArrayList<Task> getList() {
        return new ArrayList<>(list);
    }

    private boolean isExisted(TaskType taskType, String requirementName, Date date,
            double planFrom, double planTo, String assign, String reviewer) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (Task task : list) {
            if (task.getTaskType().getName().equals(taskType.getName())
                    && task.getRequirementName().equalsIgnoreCase(requirementName)
                    && dateFormat.format(task.getDate()).equalsIgnoreCase(dateFormat.format(date))
                    && task.getPlanFrom() == planFrom && task.getPlanTo() == planTo
                    && task.getAssign().equalsIgnoreCase(assign)
                    && task.getReviewer().equalsIgnoreCase(reviewer)) {
                return true;
            }
        }
        return false;
    }

    //Nhớ là các yêu cầu này , cô yêu cầu thì làm , không thì thôi để tránh dài dòng 
    // Yeu cau them 1: Kiểm tra xem khung thời gian có bị trùng với các nhiệm vụ khác của cùng một người trong cùng ngày không
    //Vi du neu giao việc trong khoảng từ 8 -> 10 h thì không thể giao tiếp từ 9h->10h được 
    private boolean isOverlappingTask(Date date, double planFrom, double planTo, String assign) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (Task task : list) {
            if (task.getAssign().equalsIgnoreCase(assign)
                    && dateFormat.format(task.getDate()).equalsIgnoreCase(dateFormat.format(date))) {
                // Kiểm tra trùng khung thời gian
                if (!(planTo <= task.getPlanFrom() || planFrom >= task.getPlanTo())) {
                    return true;
                }
            }
        }
        return false;
    }

    //Yeu cau them 2:  Kiểm tra xem tổng số giờ làm việc của một người trong ngày có vượt quá 8 tiếng không
    private boolean isOverworked(Date date, double planFrom, double planTo, String assign) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        double totalHours = 0;
        for (Task task : list) {
            if (task.getAssign().equalsIgnoreCase(assign)
                    && dateFormat.format(task.getDate()).equalsIgnoreCase(dateFormat.format(date))) {
                totalHours += task.getPlanTo() - task.getPlanFrom();
            }
        }
        // Tính tổng số giờ làm việc, bao gồm cả nhiệm vụ mới đang được thêm
        totalHours += planTo - planFrom;
        return totalHours > 8;
    }

    public int add() throws Exception {
        Task task = new Task();
        task.input();
        // Kiểm tra xem task đã tồn tại hay chưa
        if (isExisted(task.getTaskType(), task.getRequirementName(), task.getDate(),
                task.getPlanFrom(), task.getPlanTo(), task.getAssign(), task.getReviewer())) {
            throw new Exception("This task is existed!!!");
        }
        // Kiểm tra xem người được giao có nhiệm vụ nào bị trùng khung thời gian hay không
        if (isOverlappingTask(task.getDate(), task.getPlanFrom(), task.getPlanTo(), task.getAssign())) {
            throw new Exception("The assign person already has a task in this time range.");
        }
        // Kiểm tra tổng số giờ làm việc của người đó trong ngày có vượt quá 8 tiếng không
        if (isOverworked(task.getDate(), task.getPlanFrom(), task.getPlanTo(), task.getAssign())) {
            throw new Exception("The assign person will work more than 8 hours in this day.");
        }
        if (list.isEmpty()) {
            lastId = 0;
        } else {
            lastId = list.get(list.size() - 1).getId();
        }
        // Thêm nhiệm vụ mới vào danh sách
        task.setId(++lastId);
        list.add(task);
        return task.getId();
    }

    private int getIndexByID(int id) {
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public void delete() throws Exception {
        int ID = Validator.getInt("Task ID: ", "Invalid!", "Invalid!",
                Integer.MIN_VALUE, Integer.MAX_VALUE);
        int index = getIndexByID(ID);
        if (index == -1) {
            throw new Exception("Candidate does not exist!");
        }
        list.remove(index);
    }

    public void show() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        if (list.isEmpty()) {
            throw new Exception("This list task is empty!");
        }
        String str = String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task task : list) {
            double time = task.getPlanTo() - task.getPlanFrom();
            str += String.format("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskType().getName(),
                    dateFormat.format(task.getDate()),
                    time,
                    task.getAssign(),
                    task.getReviewer()
            );
        }
        System.out.println(str);
    }
}
