package homeworks.lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public Student[] getStudentsArray() {
        return studentsArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group = " + "\"" + this.groupName + "\"");
        sb.append(System.lineSeparator());

        for (int i = 0; i < studentsArray.length; i++) {
            if (studentsArray[i] != null) {
                sb.append((i + 1) + ") " + studentsArray[i]);
            } else {
                sb.append((i + 1) + ") Free");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public void saveList() {

        String list = toString();
        File file = new File("C:/Users/Public/Downloads/ReceivingFolder/" + this.groupName  + "'s list.txt");

        try(FileWriter fW = new FileWriter(file)) {
            fW.write(list);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
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

    public static void createFromTxt(File in, Group group) throws IOException{
       if(in != null){
           String str = "";
           Pattern p = Pattern.compile("\"([^\"]*)\"");
           ArrayList<String> matches = new ArrayList<String>();
           String match = "";
           try(BufferedReader bR = new BufferedReader(new FileReader(in))){

               for(;(str = bR.readLine()) != null;){

                  Matcher m = p.matcher(str);

                  while(m.find()){
                          match = m.group(1);
                          matches.add(match);
                  }
                  if(matches.size() < 2 && matches.size() != 0){
                      group.setGroupName(matches.get(0) + " 2");
                  }else if(matches.size() != 0) {
                      group.addStudent(new Student(matches.get(0), matches.get(1), Integer.parseInt(matches.get(2)), matches.get(3), matches.get(4)));
                  }

                   matches.clear();
               }

           }catch(IOException e){
               throw e;
           } catch (MyException e) {
               e.printStackTrace();
           }
       }
    }
}
