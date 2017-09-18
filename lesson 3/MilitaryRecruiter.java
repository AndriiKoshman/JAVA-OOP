package homeworks.lesson3;

public class MilitaryRecruiter {
    private String name;
    private int age;

    public MilitaryRecruiter(String name, int age) {
        super();
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "MilitaryRecruiter{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void getAdults(FindSoldiers f){
        Student adults[] = f.getStudentsArray();
        int adultCount = 0;
        for(Student adult :adults){
            if(adult != null && adult.getSex().compareTo("M") == 0 && adult.getAge() > 15){
                System.out.println(adult +"- ready for army's serve");
                adultCount ++;
            }
        }
        if(adultCount<1){
            System.out.println("Nobody is ready for army's serve");
        }
    }
}
