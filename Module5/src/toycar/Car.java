package toycar;

//import  java.util.ArrayList;

public class Car {
    private final String DofP; // DofP - Date of Production is constant
    private String engineType;
    private int maxSpeed;
    private int accelerationTime;
    private int passengerCapacity;
    private int passengerQtity;
    private int presentSpeed;
    private CarWheel[] wheels;
    private CarDoor[] doors;

    // constructor with production date
    public Car(String DofP){
        this.DofP=DofP;
        String engineType = "unknown";
        maxSpeed = 0;
        accelerationTime = 0;
        passengerCapacity = 0;
        passengerQtity = 0;
        presentSpeed = 0;

        wheels = new CarWheel[4];
        for (int i=0; i<4; i++){
            wheels[i] = new CarWheel();
        }

        doors = new CarDoor[4];
        for (int i=0; i<4; i++) {
            doors[i] = new CarDoor();
        }
    }

    //constructor with all fields apart from doors and wheels
    public Car(String DofP,
               String engineType,
               int maxSpeed,
               int accelerationTime,
               int passengerCapacity,
               int passengerQtity,
               int presentSpeed) {

        this.DofP = DofP;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.accelerationTime = accelerationTime;
        this.passengerCapacity = passengerCapacity;
        this.passengerQtity = passengerQtity;
        this.presentSpeed = presentSpeed;

        wheels = new CarWheel[4];
        for (int i=0; i<4; i++){
            wheels[i] = new CarWheel();
        }

        doors = new CarDoor[4];
        for (int i=0; i<4; i++) {
            doors[i] = new CarDoor();
        }
    }

    //to change current speed
    public void changeSpeed(int value){
        if ((presentSpeed+value)>maxSpeed){
            presentSpeed = maxSpeed;
        }else{
            presentSpeed = presentSpeed+value;
        }
    }

    //get in one passenger
    public void  onePassengerIn (){
        if (passengerCapacity>passengerQtity){
            passengerQtity++;
        }
    }

    //get out one passenger
    public  void onePassengerOut (){
        if (passengerQtity>0){
            passengerQtity--;
        }else{
            System.out.println("Car is already empty!");
        }
    }

    //get out everybody
    public void getoutAllPassengesr () {
        if (passengerQtity != 0){
            passengerQtity=0;
        }
    }

    //get car door by its index
    public CarDoor getDoor(int ind){
            return doors[ind];
    }

    //get car wheel by its index
    public CarWheel getWheel(int ind){
        return  wheels[ind];
    }

    //take out all wheels
    public void removeAllWheels(){
        wheels = new CarWheel[0];
    }

    //add wheels in quantity of x (all new)
    public void addX_wheels(int x){
        int oldArrLen = wheels.length;
        CarWheel[] arr = new CarWheel[oldArrLen];
        for (int i=0; i<oldArrLen; i++){
            arr[i] = wheels[i];
        }
        int newArrLen = oldArrLen+x;
        wheels = new CarWheel[newArrLen];
        for (int i=0; i<oldArrLen; i++){
            wheels[i] = arr[i];
        }
        for (int i = oldArrLen; i<newArrLen; i++){
            wheels[i] = new CarWheel();
        }
    }

    //calculate present speed. Speed function depends on state of wheels:
    //State of worst wheel*max speed of new car
    //And will be 0 if there is noneone in the car
    public double getPresentSpeed(){
        if(passengerQtity==0){
            return 0;
        }else{
            double wheelIndex = wheels[0].getTireState();
            for (int i=1; i<wheels.length; i++){
                if (wheelIndex > wheels[i].getTireState()){
                    wheelIndex = wheels[i].getTireState();
                }
            }
            return wheelIndex*maxSpeed;
        }
    }

    //peinting info about object: all fields to be printed
    public void print (){
        System.out.println("\nInfo about Car:");
        System.out.printf("Date produced: %s\n", DofP);
        System.out.printf("Engine type: %s\n", engineType);
        System.out.printf("Max speed of new car: %d, real max speed: %f\n", maxSpeed, getPresentSpeed());
        System.out.printf("Acceleration time: %d\n", accelerationTime);
        System.out.printf("Passenger capacity: %d\n", passengerCapacity);
        System.out.printf("Present passenger quantity: %d\n", passengerQtity);
        //printing wheels info
        if (wheels.length > 0){
            for (int i=0; i<wheels.length; i++){
                wheels[i].print();
            }
        }else{
            System.out.println("No wheels installed.");
        }
        for (int i=0; i<doors.length; i++){
            doors[i].print();
        }
    }

}
