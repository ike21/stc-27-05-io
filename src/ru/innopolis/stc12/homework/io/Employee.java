package ru.innopolis.stc12.homework.io;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
    private String name;
    private int age;
    private int salary;
    private Job job;

    public Employee() {

    }

    public Employee(String name, int age, int salary, Job job) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean save(Employee man) {
        return true;
    }

    public boolean delete(Employee man) {
        return true;
    }

    public Employee getByName(String name) {
        return new Employee();
    }

//    public List<Employee> getByJob(Job job) {
//        return new List<>();
//    }

    public boolean saveOrUpdate(Employee man) {
        return true;
    }

    public boolean changeAllWork(Job job, Job job2) {
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", job=" + job +
                '}';
    }
}
