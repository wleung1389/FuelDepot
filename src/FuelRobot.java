public interface FuelRobot {
    int getCurrentIndex();
    boolean isFacingRight();
    void changeDirection();
    void moveForward(int numLocs);
}
