package HighQualityMistakes;

import Reflection.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Arrays.stream(clazz.getDeclaredFields())
        .filter(f -> !Modifier.isPrivate(f.getModifiers()))
        .sorted(Comparator.comparing(Field::getName))
        .forEach(f -> System.out.println(f.getName() + " must be private!"));

        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getReturnType() != void.class)
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .forEach(m -> System.out.println(m.getName() + " have be public!"));

        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getReturnType() == void.class)
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .forEach(m -> System.out.println(m.getName() + " have to be private!"));

    }
}
