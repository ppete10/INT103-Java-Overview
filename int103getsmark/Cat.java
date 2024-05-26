package Entities;

import java.io.Serializable;

public class Cat implements Serializable {
    private String color;
    private String breed;
    private int age;

    public Cat(String color, String breed, int age) {
        this.color = color;
        this.breed = breed;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Cat: %s,%s,%d",color,breed,age);
    }
}
