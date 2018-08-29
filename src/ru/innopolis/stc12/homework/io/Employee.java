package ru.innopolis.stc12.homework.io;

import java.io.*;
import java.util.*;

public class Employee implements Serializable {
    private String name;
    private int age;
    private int salary;
    private Job job;

    private File filepath = new File("employee.dat");
    private ArrayList<Employee> list = new ArrayList<>();

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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public boolean save(Employee employee) {
        saveOrUpdate(employee);
        return true;
    }

    public boolean delete(Employee employee) {
        read();
        if (list != null) {
            list.remove(employee);
            write(list);
            return true;
        }
        return false;
    }

    public Employee getByName(String name) {
        read();
        if (list != null) {
            for (Employee e : list) {
                if (e.getName().equals(name)) {
                    return e;
                }
            }
        }
        return null;
    }

    public List<Employee> getByJob(Job job) {
        ArrayList<Employee> employeeByJob = new ArrayList<>();
        read();
        if (list != null) {
            for (Employee e : list) {
                if (e.getJob().equals(job)) {
                    employeeByJob.add(e);
                }
            }
        }
        return employeeByJob;
    }

    public boolean saveOrUpdate(Employee employee) {
        if (filepath.exists() && filepath != null && filepath.length() != 0) {
            read();
            if (list != null) {
                Employee e = getByName(employee.getName());
                if (e != null) {
                    list.remove(e);
                }
            }
        }
        list.add(employee);
        write(list);
        return true;
    }

    public boolean changeAllWork(Job oldJob, Job newJob) {
        read();
        if (list != null) {
            for (Employee e : list) {
                if (e.getJob().equals(oldJob)) {
                    e.setJob(newJob);
                }
            }
            write(list);
            return true;
        }
        return false;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                salary == employee.salary &&
                Objects.equals(name, employee.name) &&
                job == employee.job;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, job);
    }

    private void read() {
        list = null;
        if (filepath.exists() && filepath != null) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filepath))) {
                list = (ArrayList<Employee>) objectInputStream.readObject();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void write(ArrayList<Employee> employee) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath))) {
            objectOutputStream.writeObject(employee);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
