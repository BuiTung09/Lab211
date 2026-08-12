/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Task;
import entity.TaskType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author win
 */
public class ManagerTask {

    private ArrayList<Task> list;
    private int lastId;

    public ManagerTask() {
        list = new ArrayList<>();
    }

    //Yeu cau co Nang la chi duoc anh xa danh sach ,ko tra ve truc tiep danh sach trong getList
    //Khong duoc khai bao setList
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

    public int add(TaskType taskType, String requirementName, Date date,
            double planFrom, double planTo, String assign, String reviewer) throws Exception {
        // Kiểm tra xem task đã tồn tại hay chưa
        if (isExisted(taskType, requirementName, date, planFrom, planTo, assign, reviewer)) {
            throw new Exception("This task is existed!!!");
        }
        // Kiểm tra xem người được giao có nhiệm vụ nào bị trùng khung thời gian hay không
        if (isOverlappingTask(date, planFrom, planTo, assign)) {
            throw new Exception("The assign person already has a task in this time range.");
        }
        // Kiểm tra tổng số giờ làm việc của người đó trong ngày có vượt quá 8 tiếng không
        if (isOverworked(date, planFrom, planTo, assign)) {
            throw new Exception("The assign person will work more than 8 hours in this day.");
        }
        if(list.isEmpty()){
            lastId=0;
        }else{
            lastId=list.get(list.size()-1).getId();
        }
        // Thêm nhiệm vụ mới vào danh sách
        Task newTask = new Task(++lastId, taskType, requirementName, date, planFrom, planTo, assign, reviewer);
        list.add(newTask);
        return newTask.getId();
    }

    public void deleteTaskById(int id) throws Exception {
        int index = getIndexByID(id);
        if (index == -1) {
            throw new Exception("Candidate does not exist!");
        }
        list.remove(index);
    }

    private int getIndexByID(int id) {
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        if (list.isEmpty()) {
            return null;
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
        return str;
    }

}
