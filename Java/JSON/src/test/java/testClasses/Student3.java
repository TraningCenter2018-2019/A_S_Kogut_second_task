package testClasses;

public class Student3 {
    public String surname;
    public String name;
    public int stipend;
    public  StudentExam[] exams;

    public Student3(String surname,String name,int stipend,StudentExam[] exams)
    {
        this.surname = surname;
        this.name = name;
        this.stipend = stipend;
        this.exams = exams;
    }
}
