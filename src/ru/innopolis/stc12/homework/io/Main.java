package ru.innopolis.stc12.homework.io;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String filename = "people.dat";
        ArrayList<Employee> persons = new ArrayList<>();

        persons.add(new Employee("Vas", 30, 30000, Job.JUNIOR));

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(persons);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        ArrayList<Employee> newPersons = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            newPersons = (ArrayList<Employee>) objectInputStream.readObject();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Employee e : newPersons) {
            System.out.println(e);
        }
    }
}
