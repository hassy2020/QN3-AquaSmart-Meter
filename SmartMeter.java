public class SmartMeter {
    // Encapsulated private fields
    private String meterId;
    private double creditBalance;
    private boolean valveOpen;

    public SmartMeter(String meterId, double openingBalance) {
        this.meterId = meterId;
        this.creditBalance = openingBalance;
        this.valveOpen = true; // Default state
    }

    public double loadToken(double amount) {
        if (amount > 0) {
            this.creditBalance += amount;
            this.valveOpen = true; // Re-opens valve on reload
        }
        return this.creditBalance;
    }

    public boolean recordConsumption(double litres) {
        double cost = litres * 50; // Cost is UGX 50 per Litre

        if (this.creditBalance >= cost) {
            this.creditBalance -= cost;
            if (this.creditBalance <= 0) {
                this.creditBalance = 0;
                this.valveOpen = false; // Close valve if empty
            }
            return true;
        } else {
            this.creditBalance = 0;
            this.valveOpen = false;
            return false; // Block consumption
        }
    }

    public double getCreditBalance() { return creditBalance; }
    public boolean isValveOpen() { return valveOpen; }
}