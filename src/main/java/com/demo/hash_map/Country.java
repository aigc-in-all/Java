package com.demo.hash_map;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月14日 下午2:17:46
 * @version V1.0
 */
public class Country {
    
    private String name;
    private int population;
    
    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public int hashCode() {
        if (this.name.length() % 2 == 0) {
            return 31;
        } else {
            return 95;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Country other = (Country) obj;
        return name.equalsIgnoreCase(other.getName());
    }

}
