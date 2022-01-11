package busSystem;

import busSystem.models.SmartCard;

public class BusJourney {
    private Integer start;
    private Integer stop;
    private SmartCard card;
    private int mHour;
    private int mDay;
    private double fare;


    public BusJourney(){

    }

    public double getFare() {
        return fare;
    }
    public void setFare(double fare) {
        this.fare = fare;
    }

    public SmartCard getCard() {
        return card;
    }
    public void setCard(SmartCard card) {
        this.card = card;
    }
    public int getmDay() {
        return mDay;
    }
    public void setmDay(int mDay) {
        this.mDay = mDay;
    }
    public int getmHour() {
        return mHour;
    }
    public void setmHour(int mHour) {
        this.mHour = mHour;
    }
    public Integer getStart() {
        return start;
    }
    public void setStart(Integer start) {
        this.start = start;
    }
    public Integer getStop() {
        return stop;
    }
    public void setStop(Integer stop) {
        this.stop = stop;
    }

    @Override
    public String toString() {
        return "BusJourney={start= " + start + "\n"
            + "Stop= "+ stop;
    }
    
}
