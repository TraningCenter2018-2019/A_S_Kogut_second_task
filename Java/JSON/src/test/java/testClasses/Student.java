package testClasses;

public class Student {
    public String surname;
    public String name;
    public int stipend;
    public StudentExam exam;

    public Student(String surname,String name,int stipend,StudentExam exam)
    {
        this.surname = surname;
        this.name = name;
        this.stipend = stipend;
        this.exam = exam;
    }
}
