package com.company;

public class Student extends Human implements Comparable<Student> {

    private String univer;
    private String group;

    public Student(String firstName, String secondName, int age, String sex, String univer) {
        super(firstName, secondName, age, sex);
        this.univer = univer;
    }

    public Student() {
        super();
    }

    public String getUniver() {
        return univer;
    }

    public void setUniver(String univer) {
        this.univer = univer;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int compareTo(Student student) {
        return this.getSecondName().compareTo(student.getSecondName());
    }

        @Override
    public String toString() {
        return "Student [" + super.toString() + " univer=" + univer + ", group=" + group + "]";
    }
}
