package com.company;

public class Human {

    private String firstName;
    private String secondName;
    private int age;
    private String sex;

    public Human(String firstName, String secondName, int age, String sex) {
        super();
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.sex = sex;
    }

    public Human() {
        super();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName(){
        return secondName;
    }

    public String getFullName(){
        return firstName + " " + secondName;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(){
        this.firstName = firstName;
    }

    public void setSecondName(){
        this.secondName = secondName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(){
        this.sex = sex;
    }

    public String toString() {
        return "First name= " + firstName + ", Second name= " + secondName + ", age= " + age + ", sex= " + sex;
    }
}
