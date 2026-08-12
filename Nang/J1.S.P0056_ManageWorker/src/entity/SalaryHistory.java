/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author win
 */
public class SalaryHistory implements Comparable<SalaryHistory>, Serializable {

    private Worker worker;
    private double salaryUpdate;
    private SalaryStatus status;
    private Date date;

    public SalaryHistory(Worker worker, double salaryUpdate, SalaryStatus status, Date date) throws Exception {
        setWorker(worker);
        setSalaryUpdate(salaryUpdate);
        setStatus(status);
        setDate(date);
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) throws Exception {
        if (worker != null) {
            this.worker = worker;
        } else {
            throw new Exception("Worker can not null!");
        }
    }

    public SalaryStatus getStatus() {
        return status;
    }

    public void setStatus(SalaryStatus status) throws Exception {
        if (status != null) {
            this.status = status;
        } else {
            throw new Exception("Status can not null!");
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) throws Exception {
        if (date != null) {
            this.date = date;
        } else {
            throw new Exception("Date can not null!");
        }
    }

    public double getSalaryUpdate() {
        return salaryUpdate;
    }

    public void setSalaryUpdate(double salaryUpdate) throws Exception {
        if (salaryUpdate >= 0) {
            this.salaryUpdate = salaryUpdate;
        } else {
            throw new Exception("salaryUpdate must be >=0");
        }
    }

    @Override
    public String toString() {
        return "SalaryHistory{" + worker.getId() + ", " + salaryUpdate + ", " + status + ", " + date + '}';
    }

    @Override
    public int compareTo(SalaryHistory o) {
       // return worker.getId().compareTo(o.worker.getId());
       return worker.getId().compareTo(o.worker.getId());
    }

}
