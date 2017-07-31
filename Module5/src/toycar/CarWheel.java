package toycar;

public class CarWheel {
    private double tireState; //from 0(worn out) to 1(new)

    public CarWheel () {
        tireState = 1;
    }

    public CarWheel(double tireState) {
        this.tireState = tireState;
    }

    public void renewTire (){
        tireState = 1;
    }

    public void useTire (double x){    //x range fr 0(no tire/wheel) to 1(brand new)
        if ((tireState - x) < 0){
            tireState = 0;
        }else{tireState -= x;}
    }

    public double getTireState (){
        return tireState;
    }

    public void print (){
        System.out.printf("present tire state: %f\n", tireState);
    }

}
