import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class SerializerJSON {

    public static String serializeObjectToJson(Object o) throws IllegalAccessException {
        StringBuilder res = new StringBuilder("{");
        Field[] fields = o.getClass().getDeclaredFields();

        int len = fields.length;
        for (int i = 0; i < len; i++) {

            if(i!=0)
                res.append(",");
            res.append("\"" + fields[i].getName() + "\": ");

            switch (UtilsJSON.getTypeOutputData(fields[i].getType())) {
                case 1: {
                    res.append("\"" + fields[i].get(o) + "\"");
                    break;
                }
                case 2: {
                    res.append(fields[i].get(o));
                    break;
                }
                case 3: {
                    res.append(serializeArrayToJson(fields[i].get(o)));
                    break;
                }
                case 4: {
                    res.append(serializeObjectToJson(fields[i].get(o)));
                    break;
                }
            }
        }
        res.append("}");

        return res.toString();
    }

    public static String serializeArrayToJson(Object array) throws IllegalAccessException {
        StringBuilder res = new StringBuilder("[");
        int length = Array.getLength(array);

        for (int j = 0; j < length; j++) {
            switch (UtilsJSON.getTypeOutputData(Array.get(array, 1).getClass()))
            {
                case 1:
                {
                    if (j != 0)
                        res.append(",");
                    res.append("\"" + Array.get(array, j) + "\"");
                }
                break;
                case 2:
                {
                    if (j != 0)
                        res.append(",");
                    res.append(Array.get(array, j));
                    break;
                }
                case 3:
                {
                    if (j != 0)
                    res.append(",");
                    res.append(serializeArrayToJson(Array.get(array, j)));
                break;
                }
                case 4:
                {
                    if (j != 0)
                        res.append(",");
                    res.append(serializeObjectToJson(Array.get(array, j)));
                    break;
                }
            }
        }

        res.append("]");
        return res.toString();
    }
}
