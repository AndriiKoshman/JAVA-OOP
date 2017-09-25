package homeworks.lesson3;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // create 11 students and 1 group
        Student student1 = new Student("Jackie", "Chan",15, "M", "Poplavskiy University");
        Student student2 = new Student("Kurt", "Cobain",16, "M", "Poplavskiy University");
        Student student3 = new Student("John", "Lennon",17, "M", "Poplavskiy University");
        Student student4 = new Student("Russell", "Crowe",15, "M", "Poplavskiy University");
        Student student5 = new Student("Angelina", "Jolie",16, "F", "Poplavskiy University");
        Student student6 = new Student("Tom", "Cruise",17, "M", "Poplavskiy University");
        Student student7 = new Student("Keanu", "Reeves",15, "M", "Poplavskiy University");
        Student student8 = new Student("Adriano", "Celentano",16, "M", "Poplavskiy University");
        Student student9 = new Student("Arnold", "Swarzenegger",17, "M", "Poplavskiy University");
        Student student10 = new Student("Julia", "Roberts",16, "F", "Poplavskiy University");
        Student student11 = new Student("Alex", "Smith",17, "M", "Poplavskiy University");
        Group groupOne = new Group ("Hollywood");

        // check 1st student and group after creation
        System.out.println(student1);
        //System.out.println(groupOne);
        System.out.println();

        //add 10 students to the group and trying to add 11th
        try {
            groupOne.addStudent(student1);
            groupOne.addStudent(student2);

            //add student via input
            groupOne.dynamicAdding();

            groupOne.addStudent(student4);
            groupOne.addStudent(student5);
            groupOne.addStudent(student6);
            groupOne.addStudent(student7);
            groupOne.addStudent(student8);
            groupOne.addStudent(student9);
            groupOne.addStudent(student10);
            groupOne.addStudent(student11);
        }
        catch(MyException e) {
            System.out.println(e.getMessage());
        }

        // check 1st student and group after adding
        System.out.println(student1);
        System.out.println(groupOne);
        System.out.println();

        //remove student from 5th place
        groupOne.removeStudent(student5);

        //trying remove student from that place again
        groupOne.removeStudent(student5);

        //trying remove student from not existing place
        groupOne.removeStudent(student11);
        System.out.println(student5);
        System.out.println(groupOne);
        System.out.println();

        //sorting by parameters
        groupOne.sortByParameter();
        System.out.println(groupOne);


        //find student by name
        groupOne.findStudent("russell crowe");
        System.out.println();

        //get adult studets
        MilitaryRecruiter mihail = new MilitaryRecruiter("Misha", 44);
        mihail.getAdults(groupOne);
        System.out.println(groupOne);

       //create Group from txt file

        File in = new File("C:/Users/Public/Downloads/ReceivingFolder/Group's list.txt");
        Group groupTwo = new Group();

        try {
            Group.createFromTxt(in, groupTwo);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(groupTwo);
    }
}
