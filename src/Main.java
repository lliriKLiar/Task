import java.io.File;

public class Main {

    public static void main(String[] args) {
        Houseplant plant = new Houseplant("Кактус",2.2,4,IrrigationType.OFTEN);
        Houseplant plant1 = new Houseplant("Орхидея",7.7,4,IrrigationType.RARE);
        GardenPlant plant2 = new GardenPlant("Яблоня",5.5,4,58);
        GardenPlant plant3 = new GardenPlant("Малина",3.3,2,42);
        MyPlants<Plant> myPlants = new MyPlants<>();
        try {
            myPlants.add(plant);
            myPlants.add(plant1);
            myPlants.add(plant2);
            myPlants.add(plant3);
            myPlants.getPlantByLifeExpectancy(4).forEach(System.out::println);
            System.out.println("--------");
            myPlants.getPlantsByHeightRange(3D, 6D).forEach(System.out::println);
            System.out.println("--------");
            myPlants.showAllPlantsSortedByPlantsName();
            myPlants.removeByName("Кактус");
            System.out.println("--------");
            myPlants.showAllPlantsSortedByPlantsName();
            myPlants.savePlantToFile("Малина",new File("C:\\Users\\Суууупа\\Desktop\\Test.txt"));
            System.out.println("--------");
            System.out.println(myPlants.getPlantFromFile(new File("C:\\Users\\Суууупа\\Desktop\\Test.txt")));
        } catch (PlantAlreadyExistsException e) {
            e.printStackTrace();
        } catch (WrongLifeExpectancyException e) {
            e.printStackTrace();
        } catch (WrongRangeException e) {
            e.printStackTrace();
        } catch (WrongHeightException e) {
            e.printStackTrace();
        }
    }

}
