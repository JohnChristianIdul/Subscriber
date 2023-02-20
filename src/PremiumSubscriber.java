public class PremiumSubscriber extends Subscriber implements Discountable{
    private int premiumYears;

    public PremiumSubscriber(int id, String name, double monthlyFees, int premiumYears){
        super(id, name, monthlyFees);
        this.premiumYears=premiumYears;
    }

    @Override
    public double feeAfterDiscount() {
        if(premiumYears < 4){
            return monthlyFees -= monthlyFees*0.20;
        } else {
            return monthlyFees -= monthlyFees*0.40;
        }
    }

    @Override
    public void display() {
        System.out.println("Basic Subscriber's id: " + id + "\nName: " + name + "\nMonthly Fee: " + monthlyFees + "\nPremium Years: " + premiumYears);
    }

    public String toString(){
        return super.toString() + " " + premiumYears;
    }
}
