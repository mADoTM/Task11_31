package ru.vsu.cs.dolzhenkoms.Utils;

import java.util.List;

public class ArrayUtils {
    public static String[] toPrimitive(Object[] array) {
        String[] primitiveArray = new String[array.length];

        for(int i = 0; i < array.length; i++) {
            primitiveArray[i] = array[i].toString();
        }

        return primitiveArray;
    }

    public static String[] toPrimitive(Object[] array, boolean hasEmptyString) {
        String[] primitiveArray = new String[array.length];

        for(int i = 0; i < array.length; i++) {
            if(array[i].toString() == "" && hasEmptyString == false) {
                continue;
            }
            primitiveArray[i] = array[i].toString();
        }

        return primitiveArray;
    }

    public static String[] toPrimitive(List<String> list) {
        String[] stringArray = new String[list.size()];

        for(int i = 0; i < stringArray.length; i++) {
            stringArray[i] = list.get(i);
        }

        return stringArray;
    }

    public static String concatStringArrayToString(String[] array) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if(i != array.length - 1) {
                sb.append("\n");
            }
        }

        return  sb.toString();
    }
}
