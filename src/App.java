import busSystem.BusJourney;
import busSystem.BusService;
import busSystem.models.SmartCard;

public class App {

    public static void main(String[] args) {


        BusService service = BusService.getInstance();

        SmartCard card1 = new SmartCard();
        card1.deposite(100);

        SmartCard card2 = new SmartCard();
        card2.deposite(18);

        // BusJourney journey1 = service.startJourney(2, card1);


        BusJourney journey2 = service.startJourney(15, card2);


        // service.finishJourney(journey1, 8);
        service.finishJourney(journey2, 1);

    }
}
