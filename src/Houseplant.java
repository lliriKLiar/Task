public class Houseplant  extends Plant{

    private IrrigationType irrigationType;

    public Houseplant(String name, double height, int lifeExpectancy, IrrigationType irrigationType) {
        super(name, height, lifeExpectancy);
        this.irrigationType = irrigationType;
    }

    public IrrigationType getIrrigationType() {
        return irrigationType;
    }
}
