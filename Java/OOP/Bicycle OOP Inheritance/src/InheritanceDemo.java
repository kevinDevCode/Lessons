public class InheritanceDemo
{
    public static void main(String[] args)
    {
        MountainBike mountainBike = new MountainBike(2,30,13);
        System.out.println("the gear is: " + mountainBike.gear);
        System.out.println("the initial speed is: " + mountainBike.speed);
        System.out.println("the seat height is: " + mountainBike.seatHeight);

        //function applyBrake
        mountainBike.applyBrake(3);
        System.out.println("afeter applying Brake is: " + mountainBike.speed);
    }
}
