import java.lang.reflect.Type;

public class UtilsJSON {
    public static int getTypeOutputData(Class cl)
    {
        if(cl == String.class)
            return 1;
        if(cl.isPrimitive() || cl == Integer.class || cl == Byte.class || cl == Long.class
                || cl == Boolean.class || cl == Character.class || cl == Float.class || cl == Double.class)
            return 2;
        if(cl.isArray())
            return 3;
        else
            return 4;
    }
}
