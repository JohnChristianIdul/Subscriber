public class BasicSubscriber extends Subscriber{
    private String joinDate;

    public BasicSubscriber(int id, String name, double monthlyFees, String joinDate) {
        super(id, name, monthlyFees);
        this.joinDate = joinDate;
    }

    @Override
    public void display() {
        System.out.println("Basic Subscriber's id: " + id + "\nName: " + name + "\nMonthly Fee: " + monthlyFees + "\nDate Joined: " + joinDate);
    }

    public String toString(){
        return super.toString() + " " + joinDate;
    }
}
