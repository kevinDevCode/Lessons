class MountainBike implements Bicycle_Interface //When you use implements, you will write an interface
{

    private int seatHeight;
    private int gear;
    private int speed;

    public MountainBike(int startHeight, int startGear, int startSpeed)
    {
        this.seatHeight = startHeight;
        this.gear = startGear;
        this.speed = startSpeed;
    }
    @Override
    public void applyBrake(int decrement)
    {
        speed -= decrement;
    }
    @Override
    public void speedUp(int increment)
    {
        speed += increment;
    }

    public int getGear()
    {
        return gear;
    }

    public int getSpeed()
    {
        return speed;
    }
    public int getSeatHeight()
    {
        return seatHeight;
    }

    public void setGear(int newGear)
    {
        this.gear = newGear;
    }
    public void setSpeed(int newSpeed)
    {
        this.speed = newSpeed;
    }
    public void setSeatHeight(int newHeight)
    {
        this.seatHeight = newHeight;
    }

}
