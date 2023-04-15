public class InterfaceDemo
{
    public static void  main(String[] args)
    {
        MountainBike mountainBike = new MountainBike(20,10,1);
        System.out.println("the start gear is: " + mountainBike.getGear());
        System.out.println("the start height is: " + mountainBike.getSeatHeight());
        System.out.println("the start Speed is: " + mountainBike.getSpeed());
        mountainBike.setSpeed(30);
        mountainBike.applyBrake(2);
        System.out.println("the new speed is: " + mountainBike.getSpeed());
        mountainBike.speedUp(21);
        System.out.println("the speedUp plus speed is: " + mountainBike.getSpeed());
    }
}
