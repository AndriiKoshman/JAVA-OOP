package homeworks.lesson3;

import java.util.Comparator;

public class Student extends Human {

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

    public static Comparator<Student> secondNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {

            if(o1 == null){
                return 1;
            }
            if(o2 == null){
                return -1;
            }
            return o1.getSecondName().compareTo(o2.getSecondName());
        }
    };

    public static Comparator<Student> ageComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {

            if(o1 == null){
                return 1;
            }
            if(o2 == null){
               return -1;
            }
            return o1.getAge() - o2.getAge();
        }
    };

    public static Comparator<Student> firstNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {

            if(o1 == null){
                return 1;
            }
            if(o2 == null){
                return -1;
            }
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    };

    @Override
    public String toString() {
        return "Student [" + super.toString() + " univer=" + univer + ", group=" + group + "]";
    }
}

