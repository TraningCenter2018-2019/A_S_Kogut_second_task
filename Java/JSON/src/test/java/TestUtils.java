import org.junit.Assert;
import org.junit.Test;
import testClasses.Student;

public class TestUtils {
    @Test
    public void testGetTypeOutputData()
    {
        Assert.assertEquals(UtilsJSON.getTypeOutputData(int.class),2);
        Assert.assertEquals(UtilsJSON.getTypeOutputData(Boolean.class),2);
        Assert.assertEquals(UtilsJSON.getTypeOutputData(String.class),1);
        Assert.assertEquals(UtilsJSON.getTypeOutputData(int[].class),3);
        Assert.assertEquals(UtilsJSON.getTypeOutputData(Student.class),4);
    }
}
