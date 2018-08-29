package ru.innopolis.stc12.homework.io;

public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.save(new Employee("Masha", 20, 20000, Job.JUNIOR));
        employee.save(new Employee("Sasha", 25, 35000, Job.JUNIOR));
        employee.save(new Employee("Petya", 30, 60000, Job.MIDDLE));
        employee.save(new Employee("Vasya", 50, 80000, Job.SENIOR));
//
//        employee.delete(new Employee("Vasya", 50, 80000, Job.SENIOR));
//        employee.delete(new Employee("Vas3", 38, 60000, Job.JUNIOR));
//        System.out.println(employee.getByName("Masha"));
//        System.out.println(employee.getByJob(Job.SENIOR));
//        employee.changeAllWork(Job.SENIOR,Job.JUNIOR);
//        employee.saveOrUpdate(new Employee("Vasya", 100, 1, Job.MIDDLE));
//        employee.delete(new Employee("Vasya", 50, 80000, Job.SENIOR));
    }
}
