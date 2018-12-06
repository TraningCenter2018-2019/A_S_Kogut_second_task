import org.junit.Assert;
import org.junit.Test;
import testClasses.*;

public class TestSerializerJSON {

    @Test
    public void testSimple() throws IllegalAccessException
    {
        String str = "{\"surname\": \"Когут\",\"name\": \"Александр\",\"stipend\": 3500,\"exam\": {\"subject\": \"Assembler\",\"mark\": 5}}";
        Student student = new Student("Когут","Александр",3500,new StudentExam("Assembler",5));
        String result = SerializerJSON.serializeObjectToJson(student);
        Assert.assertEquals(str,result);
    }

    @Test
    public void testArray() throws IllegalAccessException
    {
        String str = "{\"surname\": \"Когут\",\"name\": \"Александр\",\"stipend\": 3500,\"marks\": [2,4,4]}";
        int[] marks = {2,4,4};

        Student2 student = new Student2("Когут","Александр",3500,marks);
        String result = SerializerJSON.serializeObjectToJson(student);
        Assert.assertEquals(str,result);
    }

    @Test
    public void testArrayClass() throws IllegalAccessException
    {
        String str = "{\"surname\": \"Когут\",\"name\": \"Александр\",\"stipend\": 3500,\"exams\": [{\"subject\": \"Assembler\",\"mark\": 5},{\"subject\": \"OS\",\"mark\": 5}]}";
        StudentExam[] exams = {new StudentExam("Assembler",5),new StudentExam("OS",5)};
        Student3 student = new Student3("Когут","Александр",3500,exams);
        String result = SerializerJSON.serializeObjectToJson(student);
        Assert.assertEquals(str,result);
    }

    @Test
    public void testArrayString() throws IllegalAccessException
    {
        String str = "{\"surname\": \"Когут\",\"name\": \"Александр\",\"stipend\": 3500,\"subjects\": [\"Assembler\",\"OS\"]}";
        String[] exams = {"Assembler","OS"};

        StudentArrayString student = new StudentArrayString("Когут","Александр",3500,exams);
        String result = SerializerJSON.serializeObjectToJson(student);
        Assert.assertEquals(str,result);
    }

    @Test
    public void testSerializeArrays() throws IllegalAccessException
    {
        String str = "[[1,2],[3,4]]";
        int[][] arr = {{1,2},{3,4}};
        Assert.assertEquals(str,SerializerJSON.serializeArrayToJson(arr));
    }

    @Test
    public void testSerializeMultidimensionalArrays() throws IllegalAccessException
    {
        String str = "[[[1,2],[3,4]],[[5,6],[7,8]],[[9,10],[11,12]],[[13,14],[15,16]]]";
        int[][][] arr = {{{1, 2},{3, 4}},{{5, 6},{7, 8}},{{9, 10},{11, 12}},{{13, 14},{15, 16}}};
        Assert.assertEquals(str,SerializerJSON.serializeArrayToJson(arr));
    }
}
