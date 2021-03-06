package comp1110.mse;

/**
 * COMP1110 Mid-Semester Exam, Question 3
 */
public class Q3Plane {

    public String name;
    public int speed;

    /**
     * Constructor
     *
     * @param name The name of the plane
     * @param speed The speed of the plane (in km/h),
     */
    Q3Plane(String name, int speed) {
        this.name = name;
        this.speed = speed;
        // FIXME 3a: complete this constructor
    }

    /** Return the speed of the plane */
    int getSpeed() {
        return this.speed;

//        return 0; // FIXME 3b: complete this method
    }

    /**
     * Reset the speed of the plane according to the argument speed
     * @param speed The new speed of the plane
     */
    void resetSpeed(int speed) {
        this.speed = speed;
        // FIXME 3c: complete this method
    }

    /**
     * Calculate the time to travel the specified distance at the current speed.
     * @param distance The distance (in km)
     * @return The time to travel the distance (in minutes)
     */
    int timeToTravel(int distance) {
        double time = ((double) distance/(double)this.speed)*60;
        int final1 = (int) time;
        return final1;

//        return 0; // FIXME 3f: complete this method
    }

    /**
     * Return a string describing the plane and its speed,
     * in the format
     *    "Plane NAME is travelling S km/h"
     * where NAME is replaced by the plane's name, and S is replaced by
     * the plane's speed.
     *
     * @return A string describing the plane and its speed
     */
    @Override
    public String toString() {
        return "Plane "+ this.name + " is travelling "+ this.speed + " km/h";

//        return "";  // FIXME 3g: complete this method
    }
}
