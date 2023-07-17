package org.example;

public enum SolarSystem {
    // Планети сонячної системи з даними про відстань від попередньої планети, радіусом і попередньою планетою
    MERCURY(0, 2440, null),
    VENUS(108, 6052, MERCURY),
    EARTH(41, 6371, VENUS),
    MARS(78, 3390, EARTH),
    JUPITER(628, 69911, MARS),
    SATURN(1200, 58232, JUPITER),
    URANUS(2700, 25362, SATURN),
    NEPTUNE(2800, 24622, URANUS),
    PLUTO(3100, 1188, NEPTUNE);

    // Зберігання даних
    private final int prevDistance; // відстань від попередньої планети в мільйонах км.
    private final int distanceFromSun; // відстань від сонця в мільйонах км.
    private final int radius; // радіус планети в км.
    private final SolarSystem previous; // попередня планета
    private SolarSystem next; // наступна планета

    // Конструктор з параметрами
    SolarSystem(int prevDistance, int radius, SolarSystem previous) {
        this.prevDistance = prevDistance;
        this.radius = radius;
        this.previous = previous;
        // Обчислення відстані від сонця за допомогою рекурсивного методу
        this.distanceFromSun = calculateDistanceFromSun();
        // Встановлення наступної планети для попередньої за допомогою статичного блоку
        setNextForPrevious();
    }

    static {
        for (SolarSystem planet : SolarSystem.values()) {
            planet.setNextForPrevious();
        }
    }
    // Відстані від сонця
    private int calculateDistanceFromSun() {
        if (previous == null) { // якщо це перша планета, то повертаємо нуль
            return 0;
        } else {
            return prevDistance + previous.calculateDistanceFromSun();
        }
    }
    // Встановлення наступної планети для попередньої
    private void setNextForPrevious() {
        if (previous != null) {
            previous.next = this;
        }
    }
    public int getPrevDistance() {
        return prevDistance;
    }
    public int getDistanceFromSun() {
        return distanceFromSun;
    }
    public int getRadius() {
        return radius;
    }
    public SolarSystem getPrevious() {
        return previous;
    }
    public SolarSystem getNext() {
        return next;
    }
}
