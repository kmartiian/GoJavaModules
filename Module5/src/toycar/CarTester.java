package toycar;

public class CarTester {
    public static void main(String[] args){

        //for class CarWheel
        CarWheel wheelLeftFwd = new CarWheel();
        CarWheel wheelLeftAft = new CarWheel(1);
        CarWheel wheelRightFwd = new CarWheel(0.8);
        CarWheel wheelRightAft = new CarWheel(0.8);

        wheelLeftFwd.print();
        wheelRightAft.print();

        wheelRightFwd.useTire((0.2));
        wheelRightFwd.print();
        wheelLeftFwd.renewTire();
        wheelLeftFwd.print();

        double averTireState = (wheelLeftAft.getTireState()
                +wheelLeftFwd.getTireState()
                +wheelRightAft.getTireState()
                +wheelRightFwd.getTireState())/4;
        System.out.println(averTireState);

        wheelRightFwd.useTire(0.8);
        wheelRightFwd.print();
        wheelRightFwd.renewTire();
        wheelRightFwd.print();

        //----------------------------------------------------------------
        //for class CarDoors:
        CarDoor leftDoor = new CarDoor();
        CarDoor rightDoor = new CarDoor("opned", "closed");

        leftDoor.print();
        if (leftDoor.getDoorState() != "opened"){
            leftDoor.openDoor();
        }
        leftDoor.print();
        if (leftDoor.getDoorState() != "opened"){
            leftDoor.openDWindow();
        }
        leftDoor.print();

        rightDoor.print();

        //----------------------------------------------------------------
        //for class Car
        Car myCar = new Car("2009");
        Car herCar = new Car("2017",
                "Diesel", 200,
                12, 4,
                0,0 );
        Car hisCar = new Car("1999",
                "Gasoline", 310,
                6, 2,
                1,120 );

        //myCar.addX_wheels(4);
        myCar.onePassengerIn();
        myCar.onePassengerIn();
        myCar.onePassengerIn();
        myCar.changeSpeed(120);
        myCar.removeAllWheels();
        myCar.print();

        herCar.getDoor(1).openDoor();
        herCar.onePassengerIn();
        herCar.changeSpeed(60);
        herCar.removeAllWheels();
        herCar.addX_wheels(1);
        herCar.print();

        hisCar.getWheel(1).useTire(0.999);
        hisCar.getDoor(0).openDoor();
        hisCar.getDoor(2).openDWindow();
        hisCar.getDoor(1).openDoor();
        hisCar.getDoor(3).openDWindow();
        hisCar.onePassengerIn();
        hisCar.onePassengerIn();
        hisCar.onePassengerIn();
        hisCar.getDoor(0).closeDoor();
       // hisCar.getDoor(2).closeDWindow();
        hisCar.getoutAllPassengesr();

        hisCar.print();

        //hisCar.print();
    }
}
