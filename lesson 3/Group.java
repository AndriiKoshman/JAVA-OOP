package com.company;

import java.util.Arrays;

public class Group {


    private String groupName;
    private Student [] studentsArray = new Student[10];

    public Group(String groupName) {
        super();
        this.groupName = groupName;
    }

    public Group() {
        super();
    }

    public String getGroupName() {
        return groupName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group - " + this.groupName);
        sb.append(System.lineSeparator());

        // if >1 student in group then sort group
        int count = 0;
        for(int k = 0; k < studentsArray.length; k++){
            if(studentsArray[k] != null) {
                count++;
            }
        }
        System.out.println(count);
        if (count > 1){
            sortGroup();
        }

        for (int i = 0; i < studentsArray.length; i++) {
            if(studentsArray[i] != null) {
                sb.append((i+1) + ") " + studentsArray[i]);
            } else {
                sb.append((i+1) + ") Free");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void sortGroup (){
        try {
        Student[] sortedArray = studentsArray;
        Arrays.sort(sortedArray);

            for (int i = 0; i < studentsArray.length; i++) {
                if (sortedArray[i] != null) {
                    System.out.println(sortedArray[i].getFullName());
                }
            }
        }
        catch(NullPointerException nE){
            System.out.println(nE.getMessage());
        }
    }

    //add student to the group
    public void addStudent(Student student) throws MyException {
            for (int i = 0; i < studentsArray.length; i++) {
                if (studentsArray[i] == null) {
                    studentsArray[i] = student;
                    student.setGroup(this.groupName);
                    System.out.println("--MSG: Student " + student.getFullName() + " added to the group " + this.groupName);
                    return;
                }
            }
        throw new MyException();
       }

    //remove student from the group
    public void removeStudent(Student student) {
        for (int i = 0; i < studentsArray.length; i++) {
            if(studentsArray[i] == student) {
                studentsArray[i].setGroup(null);
                studentsArray[i] = null;
                System.out.println("--MSG: Student " + student.getFullName() + " removed from group " + this.groupName);
                return;
            }
        }
        System.out.println("--ERROR: Student " + student.getFullName() + " not found in the group " + this.groupName);
    }

    //find student in the group by name
    public void findStudent(String fullName) {
            for (int i = 0; i < studentsArray.length; i++) {
                try {
                    String formatedFirst = studentsArray[i].getFullName().replaceAll("\\s+","").toUpperCase();
                    String formatedSecond = fullName.replaceAll("\\s+","").toUpperCase();
                    if (studentsArray[i] != null && formatedFirst.compareTo(formatedSecond) == 0) {
                        System.out.println("--MSG: Student found in the group " + this.groupName + " - " + studentsArray[i]);
                        return;
                    }
                }
                catch(NullPointerException nE){
                    System.out.println(nE.getMessage());
                }
            }
            System.out.println("--ERROR: Student " + fullName + " not found in the group " + this.groupName);
    }
}
