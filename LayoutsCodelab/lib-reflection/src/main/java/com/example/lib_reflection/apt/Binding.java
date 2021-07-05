package com.example.lib_reflection.apt;

import android.app.Activity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Binding {
    //通过反射处理
    public static void bind(Activity activity) {
        for (Field declaredField : activity.getClass().getDeclaredFields()) {
            BindView bindView = declaredField.getAnnotation(BindView.class);
            if (bindView != null) {
                try {
                    declaredField.setAccessible(true);
                    declaredField.set(activity, activity.findViewById(bindView.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void bind2(Activity activity) {
        try {
            Class<?> bindingClass = Class.forName(activity.getClass().getCanonicalName() + "Binding");
            Constructor<?> constructor = bindingClass.getDeclaredConstructor(activity.getClass());
            constructor.newInstance(activity);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
