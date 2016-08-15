package com.demo.hash_map;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月14日 下午2:19:45
 * @version V1.0
 */
public class Demo {

    public static void main(String[] args) {
        Country india = new Country("India", 1000); // 31
        Country japan = new Country("Japan", 10000); // 31

        Country france = new Country("France", 2000); // 95
        Country russia = new Country("Russia", 20000); // 95

        HashMap<Country, String> map = new HashMap<>();
        map.put(india, "Delhi");
        map.put(japan, "Tokyo");
        map.put(france, "Paris");
        map.put(russia, "Moscow");

        Iterator<Country> it = map.keySet().iterator();
        while (it.hasNext()) {
            Country c = it.next();
            String capital = map.get(c);
            System.out.println(c.getName() + "---" + capital);
        }
    }

}
