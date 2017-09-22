package homeworks.lesson3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Group implements FindSoldiers{


    private String groupName;
    private Student[] studentsArray = new Student[10];

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

    public Student[] getStudentsArray() {
        return studentsArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group - " + this.groupName);
        sb.append(System.lineSeparator());

        for (int i = 0; i < studentsArray.length; i++) {
            if (studentsArray[i] != null) {
                sb.append((i + 1) + ") " + studentsArray[i]);
            } else {
                sb.append((i + 1) + ") Free");
            }
            sb.append(System.lineSeparator());
        }
        File file = new File("C:/Users/Public/Downloads/ReceivingFolder/Group's list.txt");

        try(FileWriter fW = new FileWriter(file)) {
            fW.write(sb.toString());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }

    public void sortBySecondName() {
        Arrays.sort(studentsArray,Student.secondNameComparator);
    }

    public void sortByAge(){
        Arrays.sort(studentsArray,Student.ageComparator);
    }

   public void sortByFirstName(){
        Arrays.sort(studentsArray,Student.firstNameComparator);
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
            if (studentsArray[i] == student) {
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
            if (studentsArray[i] != null) {
                String formatedFirst = studentsArray[i].getFullName().replaceAll("\\s+", "").toUpperCase();
                String formatedSecond = fullName.replaceAll("\\s+", "").toUpperCase();
                if (formatedFirst.compareTo(formatedSecond) == 0) {
                    System.out.println("--MSG: Student found in the group " + this.groupName + " - " + studentsArray[i]);
                    return;
                }
            }
        }
        System.out.println("--ERROR: Student " + fullName + " not found in the group " + this.groupName);
    }

    // studets dynamic input
    public void dynamicAdding() throws MyException{
       Student dStudent = new Student();
       Scanner input = new Scanner(System.in);
        for (int i = 0; i < studentsArray.length; i++) {
            if (studentsArray[i] == null) {
                studentsArray[i] = dStudent;
                System.out.print("Enter student's first name: ");
                dStudent.setFirstName(input.next());
                System.out.print("Enter student's second name: ");
                dStudent.setSecondName(input.next());
                System.out.print("Enter student's age: ");
                dStudent.setAge(input.nextInt());
                System.out.print("Enter student's sex: ");
                dStudent.setSex(input.next());
                System.out.print("Enter student's University: ");
                dStudent.setUniver(input.next());
                dStudent.setGroup(this.groupName);
                System.out.println("--MSG: Student " + dStudent.getFullName() + " added to the group " + this.groupName);
                return;
            }
        }
        throw new MyException();
    }

    public void sortByParameter() {
        Scanner input = new Scanner(System.in);
        System.out.println("Sort group by (1-first name, 2-last name, 3-age): ");
        int sortBy = input.nextInt();
       switch(sortBy) {

           case 1:
               Arrays.sort(studentsArray, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
                       : a.getFirstName().compareTo(b.getFirstName()));
               break;

           case 2:
               Arrays.sort(studentsArray, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
                       : a.getSecondName().compareTo(b.getSecondName()));
               break;
           case 3:
               Arrays.sort(studentsArray, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
                       : a.getAge() - b.getAge());
               break;
           default:
               break;

       }
    }
}
