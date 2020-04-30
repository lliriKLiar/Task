public class PlantAlreadyExistsException extends Exception{

    public PlantAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlantAlreadyExistsException(String message) {
        super(message);
    }
}
