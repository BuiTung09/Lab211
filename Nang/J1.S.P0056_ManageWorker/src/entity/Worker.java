/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author win
 */
public final class Worker implements Serializable {

    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLocation;

    public Worker(String id, String name, int age,
            double salary, String workLocation) throws Exception {
        setId(id);
        setName(name);
        setAge(age);
        setSalary(salary);
        setWorkLocation(workLocation);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) throws Exception {
//        if (id.matches("W\\d+")) {
//            this.id = id;
//        } else {
//            throw new Exception("ID must be Wx (x is digit)");
//        }
          if(id == null){
              throw new Exception("Id can not null");
          }
          if(!id.matches("W\\d+")){
              throw new Exception("ID must be Wx(x is digit)");
          }
          this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.matches("[A-Za-z\\s]+")) {
            this.name = name;
        } else {
            throw new Exception("Name must be alphabetic and space!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age >= 18 && age <= 50) {
            this.age = age;
        } else {
            throw new Exception("Age must be 18->50");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws Exception {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new Exception("Salary must be >=0");
        }
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) throws Exception {
        if (workLocation.matches("[A-Za-z0-9\\s]+")) {
            this.workLocation = workLocation;
        } else {
            throw new Exception("Location must be alphabet,digit or space!");
        }
    }

    @Override
    public String toString() {
        return "Worker{" + id + ", " + name + ", " + age + ", " + salary + ", " + workLocation + '}';
    }

}
