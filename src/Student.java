public class Student {

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSurnameandName() {
        return surname + " " + name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }
    

    private int ID; //ID is a unique integer with 6 digits
    private String name;
    private String surname; //Name and surname are strings and their combination is unique.
    private int age; //Age is an integer in the range [10, 100]
    private double GPA; //GPA is a real value that is in the range [0, 4].

    public Student(int ID, String name, String surname, int age, double GPA){
        this.ID=ID;
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.GPA=GPA;
    }
}
