/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.ManagerSalaryHistory;
import bo.ManagerWorker;
import entity.SalaryHistory;
import entity.SalaryStatus;
import entity.Worker;
import java.util.Date;
import utils.Validator;

/**
 *
 * @author win
 */
public class Controller {

    private ManagerSalaryHistory salaryHistory;
    private ManagerWorker workers;

    public Controller() {
        this.salaryHistory = new ManagerSalaryHistory();
        this.workers = new ManagerWorker();
    }

    public Worker addWorker() throws Exception {
        String id = Validator.getString("Enter id: ", "Invalid!", "[Ww]\\d+").toUpperCase();
        String name = Validator.getString("Enter Name: ", "Invalid!", "[A-Za-z\\s]+");
        int age = Validator.getInt("Enter age: ", "age >= 18 and <=50 !", "Invalid!", 18, 50);
        double salary = Validator.getDouble("Enter Salary: ", "salary must be > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
        String workLocation = Validator.getString("Enter work location: ", "Invalid!", "[A-Za-z0-9\\s]+");
        Worker worker = new Worker(id, name, age, salary, workLocation);
        if (workers.add(worker)) {
            return worker;
        }
        throw new Exception("Add fail");
    }

    public Worker upSalary() throws Exception {
        if (workers.getList().isEmpty()) {
            throw new Exception("List is empty!");
        }
        String code = Validator.getString("Enter id: ", "Invalid!", "[Ww]\\d+");
        double amount = Validator.getDouble("Enter Salary: ", "salary must be > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
        Worker worker = workers.changeSalary(SalaryStatus.UP, code, amount);
        if (salaryHistory.addSalaryHistory(new SalaryHistory(worker, worker.getSalary(), SalaryStatus.UP, new Date()))) {
            return worker;
        }
        throw new Exception("Can not up salary");
    }

    public Worker downSalary() throws Exception {
        if (workers.getList().isEmpty()) {
            throw new Exception("List is empty!");
        }
        String code = Validator.getString("Enter id: ", "Invalid!", "[Ww]\\d+");
        double amount = Validator.getDouble("Enter Salary: ", "salary must be > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
        Worker worker = workers.changeSalary(SalaryStatus.DOWN, code, amount);
        if (salaryHistory.addSalaryHistory(new SalaryHistory(worker, worker.getSalary(), SalaryStatus.DOWN, new Date()))) {
            return worker;
        }
        throw new Exception("Can not down salary");
    }

    public void showHistorySalary() {
        String result = salaryHistory.toString();
        if (result == null) {
            System.out.println("History Salary is empty");
        } else {
            System.out.println(result);
        }
    }

    public void saveWorkersToFile() {
        try {
            workers.saveFile("worker.dat");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveHistoryToFile() {
        try {
            salaryHistory.saveFile("history.dat");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void readFile() {
        try {
            workers.readFile("worker.dat");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            salaryHistory.readFile("history.dat");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
