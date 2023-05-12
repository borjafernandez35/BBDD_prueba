package edu.upc.eetac.dsa.util;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHelper {
    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String[] sFields = new String[fields.length];
        int i=0;

        for (Field f: fields) sFields[i++]=f.getName();

        return sFields;

    }


    public static void setter(Object object, String property, Object value) throws IntrospectionException {

        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(property, object.getClass());
            Method setter = pd.getWriteMethod();
            try {
                setter.invoke(object,value);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

    }
        // Method // invoke




    public static Object getter(Object object, String property) {

        try {
            PropertyDescriptor pd = new PropertyDescriptor(property, object.getClass());
            Method getter = pd.getReadMethod();
            Object f = getter.invoke(object);
            return f;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            e.printStackTrace();
            return null;
        }
    }

        // Method // invoke


    }

