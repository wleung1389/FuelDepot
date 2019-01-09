import java.util.List;

public class FuelDepot {
    private FuelRobot filler;
    private List<FuelTank> tanks;
    public FuelDepot(FuelRobot r, List<FuelTank> t)
    {
        filler = r;
        tanks = t;
    }
    public int nextTankToFill(int threshold)
    {
        int i = 0;
        int lowestTankFuelIndex = 0;
        int lowestTankFuel = tanks.get(0).getFuelLevel();
        for(FuelTank t : tanks)
        {
            if(t.getFuelLevel() <= threshold && t.getFuelLevel() < lowestTankFuel)
            {
                lowestTankFuelIndex = i;
                lowestTankFuel = t.getFuelLevel();
            }
            i++;
        }
        if(lowestTankFuelIndex != filler.getCurrentIndex()) {
            return lowestTankFuelIndex;
        }
        else
        {
            return filler.getCurrentIndex();
        }
    }
    public void moveToLocation(int locIndex)
    {
        if(0 <= locIndex && locIndex < tanks.size())
        {
            int i = filler.getCurrentIndex();
            if(i > locIndex)
            {
                if(filler.isFacingRight())
                {
                    filler.changeDirection();
                }
                filler.moveForward(i - locIndex);
            }
            if(i < locIndex)
            {
                if(!filler.isFacingRight())
                {
                    filler.changeDirection();
                }
                filler.moveForward(locIndex - i);
            }
        }
    }
}
