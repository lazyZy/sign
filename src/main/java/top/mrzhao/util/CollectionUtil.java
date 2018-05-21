package top.mrzhao.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Created by ZY on 2018/3/10.
 */
public class CollectionUtil {
    public static boolean isEmpty(Object collection) {
        if (collection == null) {
            return true;
        }
        if (collection instanceof Collection) {
            return ((Collection) collection).size() <= 0;
        } else if (collection.getClass().isArray()) {
            int length = Array.getLength(collection);
            return length <= 0;
        } else if (collection instanceof Map) {
            return ((Map) collection).size() <= 0;
        }
        return false;
    }

    public static boolean isNotEmpty(Object collection) {
        return !isEmpty(collection);
    }
}
