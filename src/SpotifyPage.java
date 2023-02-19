public class SpotifyPage {
    private String title;
    private int numOfSubscriber;
    private Subscriber[] subscribe;

    public SpotifyPage(String title, int maxNumSubscribers){
        this.title = title;
        subscribe = new Subscriber[maxNumSubscribers];
    }

    public boolean addSubscriber(Subscriber s){
        try{
        if(numOfSubscriber > subscribe.length){
            return false;
        }

        int checkId = s.id;
        if(numOfSubscriber != 0){
            for(int i = 0; i < subscribe.length; i++){
                if(subscribe[i] != null){
                    if(subscribe[i].id == checkId) {
                        System.out.println("ID must be unique.");
                        return false;
                    }
                }
            }
        }
        subscribe[numOfSubscriber] = s;
        numOfSubscriber++;
        return true;
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Subcriber number is at limit");
            return false;
        }
    }

    public boolean searchByID(int id){
        for(int i=0; i<subscribe.length; i++){
            if(id == subscribe[i].id){
                System.out.println("Subscriber " + subscribe[i].name + " is a " + subscribe[i].getClass().getName());
                return true;
            }
        }
        System.out.println("Subscriber with id " + id + " does not exist");
        return false;
    }

    public void display(){
        for(int i = 0; i < subscribe.length; i++){
            System.out.println("Name: " + subscribe[i].name + "\nType of subscription: " + subscribe[i].getClass().getSimpleName());
        }
    }

    public double totalMonthlyIncome(){
        double total = 0.0;
        for(Subscriber s : subscribe){
            if(s instanceof PremiumSubscriber){
                PremiumSubscriber p = (PremiumSubscriber) s;
                if(p.premiumYears < 4){
                    double minus20Fee = p.monthlyFees - (p.monthlyFees*0.2);
                    total += minus20Fee;
                }
                if(p.premiumYears > 3){
                    double minus40fee = p.monthlyFees - (p.monthlyFees*0.4);
                    total += minus40fee;
                }
            }
            if(s instanceof BasicSubscriber){
                BasicSubscriber b = (BasicSubscriber) s;
                total += b.monthlyFees;
            }
        }
        return total;
    }
}
