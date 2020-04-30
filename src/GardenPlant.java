public class GardenPlant extends Plant {

    private double occupiedArea;

    public GardenPlant(String name, double height, int lifeExpectancy, double occupiedArea) {
        super(name, height, lifeExpectancy);
        this.occupiedArea = occupiedArea;
    }

    public double getOccupiedArea() {
        return occupiedArea;
    }
}
