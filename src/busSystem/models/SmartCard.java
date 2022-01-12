package busSystem.models;

import busSystem.LowAmountException;

public class SmartCard {

    private String id;
    private double balance = 0;
    

    public SmartCard(){
        this.id = String.valueOf(System.currentTimeMillis());
        
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public double getBalance() {
        return balance;
    }
    
    public void withdraw(double amount){
        if (this.balance < amount){
            System.out.println("not enough balnace");
            return;
            
        }else{
            this.balance -= amount;
        
        }
    }

    public void deposite(double amount){
        this.balance += amount;
    }

    @Override
    public String toString() {
        return  "SmartCard{id:" + id + "\n"
                 + "balance :" + balance + "}";
    }

    
    
}
