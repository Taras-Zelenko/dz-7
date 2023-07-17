package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Дані по планеті " + SolarSystem.EARTH + ":");
        System.out.println("* Радіус планети " + SolarSystem.EARTH + " = " + SolarSystem.EARTH.getRadius() + " км.");
        System.out.println("* Відстань до наступної планети = " + SolarSystem.EARTH.getPrevDistance() + " млн.км.");
        System.out.println("* Відстань планети до Сонця " + SolarSystem.EARTH.getDistanceFromSun() + " млн.км.");
        System.out.println("* Назва наступної планети: " + SolarSystem.EARTH.getNext());
        System.out.println("* Назва попередньої планети: " + SolarSystem.EARTH.getPrevious());
    }
}