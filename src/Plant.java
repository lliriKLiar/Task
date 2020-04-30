import java.util.Objects;

public class Plant {

    private String name;
    private double height;
    private int lifeExpectancy;


    public Plant(String name, double height, int lifeExpectancy) {
        this.name = name;
        this.height = height;
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", lifeExpectancy=" + lifeExpectancy +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return Double.compare(plant.height, height) == 0 &&
                lifeExpectancy == plant.lifeExpectancy &&
                Objects.equals(name, plant.name);
    }

    public int hashCode() {
        return Objects.hash(name, height, lifeExpectancy);
    }
}
