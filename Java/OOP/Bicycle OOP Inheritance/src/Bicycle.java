class Bicycle
{
    //attributes
    protected int gear;
    protected int speed;
    //Methods
    public Bicycle(int startSpeed, int startGear)
    {
        gear = startGear;
        speed = startSpeed;
    }

    public void setGear(int newValueGear)
    {
        gear = newValueGear;
    }

    public void setSpeed(int newValueSpeed)
    {
        speed = newValueSpeed;
    }

    public void applyBrake(int decrementSpeed)
    {
        speed -= decrementSpeed;
    }

    public void speedUp(int incrementSpeed)
    {
        speed += incrementSpeed;
    }

}
