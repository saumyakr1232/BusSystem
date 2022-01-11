import busSystem.BusJourney;
import busSystem.BusService;
import busSystem.models.SmartCard;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        BusService service = BusService.getInstance();

        SmartCard card1 = new SmartCard();
        card1.deposite(100);

        SmartCard card2 = new SmartCard();
        card2.deposite(8);

        BusJourney journey1 = service.startJourney(2, card1);


        BusJourney journey2 = service.startJourney(14, card2);


        service.finishJourney(journey1, 8);
        service.finishJourney(journey2, 1);

    }
}
