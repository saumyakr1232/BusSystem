package busSystem;

import java.util.ArrayList;
import java.util.Calendar;

import busSystem.models.SmartCard;

public class BusService {

    private static volatile BusService instance = null;

    private static ArrayList<BusJourney> archive = new ArrayList<>();
    private static Calendar calendar = Calendar.getInstance();


    private BusService(){
        if (instance != null){
            throw new RuntimeException("user getInstance() method to create.");
        }

    }

    public static BusService getInstance(){
        if (instance == null){
            synchronized(BusService.class){
                if (instance == null){
                    instance = new BusService();
                }
            }
        }
        return instance;
    }


    public BusJourney startJourney(int startStation, SmartCard card){
        BusJourney busJourney = new BusJourney();
        
        if (card.getBalance() < 10){
            System.out.println("Cann't start journey. Low balance");
            return busJourney;
        }
        busJourney.setStart(startStation);
        busJourney.setCard(card);
        busJourney.setmDay(calendar.get(Calendar.DAY_OF_WEEK));
        busJourney.setmHour(calendar.get(Calendar.HOUR_OF_DAY));

        System.out.println("Jouney started from " + "Station " + startStation + " at " + calendar.getTime().toString() );
        return busJourney;
    }

    public double finishJourney(BusJourney journey, int stop){

        if (journey.getStart() == null || journey.getCard() == null){
            System.out.println("Journey not started yet.");
            return 0;
        }else{
            journey.setStop(stop);
            double fare = calculateFare(journey);
            journey.setFare(fare);
            journey.getCard().withdraw(fare);
            archive.add(journey);
            printBill(journey.getCard().getBalance(), fare);
            return fare;
        }

    }

    private double calculateFare(BusJourney journey){

        double amount = 0;
        int numberOfStops = Math.abs(journey.getStart() - journey.getStop());
        
        if (journey.getmHour() > 23 || journey.getmHour() < 6){
            amount = 0.6 * numberOfStops;
        }else{
            amount = 0.8 * numberOfStops;
        }

        if (numberOfStops > 5){
            amount  = amount - (amount * 0.2);
        }
    
        if (journey.getmDay() == 1 || journey.getmDay() == 7){
            amount = amount - (amount * 0.1);
        }

        if (amount > 10){
            amount = 10;
        }

        return amount;

    }

    public void printBill(double balance, double fare){
        
        System.out.println("Fare = " + fare + "\n" + 
            "Balance = " + balance);

    }
    
    
}
