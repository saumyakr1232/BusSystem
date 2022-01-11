package busSystem;

public class LowAmountException extends Exception{

    @Override
    public String getMessage() {
        return "Card balance must be greater than 10$";
    }
    
}
