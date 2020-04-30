import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyPlants<T extends Plant>{

    private final Map<String, T> plantsMap = new HashMap<>();

    public void add(T plant) throws PlantAlreadyExistsException {
        if (plantsMap.containsKey(plant.getName())) {
            throw new PlantAlreadyExistsException("Такое растение уже есть");
        }
        plantsMap.put(plant.getName(), plant);
    }

    public void removeByName(String name) {
        plantsMap.remove(name);
    }

    public void showAllPlantsSortedByPlantsName() {
        plantsMap.keySet().stream().sorted().forEach(s -> System.out.println(plantsMap.get(s)));
    }

    public List<T> getPlantsByHeightRange(final double minHeihgt, final double maxHeigt) throws WrongRangeException, WrongHeightException {
        if (minHeihgt >= maxHeigt) {
            throw new WrongRangeException("Неверный диапазон высот: минимальная высота больше либо равна максимальной высоте");
        }
        if (minHeihgt <= 0||maxHeigt<=0) {
            throw new WrongHeightException("Высота не может быть меньше либо равна 0");
        }
        return plantsMap.values().stream().filter(t -> t.getHeight() >= minHeihgt && t.getHeight() <= maxHeigt).collect(Collectors.toList());
    }

    public List<T> getPlantByLifeExpectancy(final int lifeExpectancy) throws WrongLifeExpectancyException {
        if (lifeExpectancy <= 0) {
            throw new WrongLifeExpectancyException("Продолжительность жизни неможет быть меньше либо равна 0");
        }
        return plantsMap.values().stream().filter(t -> t.getLifeExpectancy() == lifeExpectancy).collect(Collectors.toList());
    }

    public void savePlantToFile(String plantName, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            T plant = plantsMap.get(plantName);
            String spliterator = ";";
            String outString = ""+plant.getName()+spliterator+plant.getHeight()+spliterator+plant.getLifeExpectancy();
            writer.write(outString);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Plant getPlantFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String inString = reader.readLine();
            String[] splitedInputLine = inString.split(";");
            return new Plant(splitedInputLine[0], Double.parseDouble(splitedInputLine[1]), Integer.parseInt(splitedInputLine[2]));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
