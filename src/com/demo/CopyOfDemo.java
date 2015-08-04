package com.demo;

import java.util.ArrayList;
import java.util.List;

public class CopyOfDemo {

    public static void main(String[] args) throws Exception {
        List<Person> ps = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ps.add(new Person("name", i, i));
        }

        List<Person> tmp = new ArrayList<>();
        tmp.addAll(ps);

        ps.remove(new Person("name", 3, 3));
//        ps.removeAll(tmp);

        System.out.println(ps);

    }

    protected static String getSql(Object... args) {
        StringBuilder sql = new StringBuilder();
        for (Object arg : args) {
            if (arg != null) {
                sql.append(arg);
            }
        }

        return sql.toString();
    }
}
