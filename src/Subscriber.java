public abstract class Subscriber {
    protected int id = 0;
    protected String name = "";
    protected double monthlyFees = 0.0;

    public Subscriber(int id, String name, double monthlyFees){
        this.id=id;
        this.name=name;
        this.monthlyFees=monthlyFees;
    }

    public abstract void display();
    public String toString(){
        return id + " " + name + " " + monthlyFees;
    }
}
