class MountainBike extends  Bicycle
{
    int seatHeight;

    public MountainBike(int startHeight,int startSpeed, int startGear) {
        super(startSpeed, startGear);
        this.seatHeight = startHeight;
    }

    public void setSeatHeight(int newValueHeight)
    {
        this.seatHeight = newValueHeight;
    }
}
