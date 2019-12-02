package mooc.vandy.java4android.shapes.logic;

import mooc.vandy.java4android.shapes.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG =
            Logic.class.getName();

    /*
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough)
     */
    private OutputInterface mOut;

    /**
     * These are the numeric values that you will receive from the
     * User Interface and use in your calculations.
     */
    private static double mRadius = 0;
    private static double mLength = 0;
    private static double mWidth = 0;
    private static double mHeight = 0;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    @Override
    public void process() {
        // Get which calculation should be computed.  Do not worry
        // about the specifics of this right now.
        Shapes shapeForCalculations = mOut.getShape();

        // Store the values returned by the User Interface.
        mLength = mOut.getLength();
        mWidth = mOut.getWidth();
        mHeight = mOut.getHeight();
        mRadius = mOut.getRadius();

        // Determine which calculation to process right now.  Again,
        // do not worry about the specifics of how this works for now.
        switch (shapeForCalculations) {
            case Box:
                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " by "
                        + mHeight
                        + " box has a volume of: ");
                mOut.println(""
                        + String.format("%.2f",
                        boxVolume(mLength, mWidth, mHeight)));
                mOut.println("");

                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " by "
                        + mHeight
                        + " box has a surface area of: ");
                mOut.println(""
                        + String.format("%.2f",
                        boxSurfaceArea(mLength, mWidth, mHeight)));
                mOut.println("");
                // If you are paying attention, you will notice that
                // there is no 'break;' here like there is in other
                // places, meaning that if 'Box' was selected, it will
                // run the two sets of print statements above and the
                // two statements below until the 'break;' statement.
            case Rectangle:
                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " rectangle has a perimeter of: ");
                mOut.println("" + String.format("%.2f",
                        rectanglePerimeter(mLength, mWidth)));
                mOut.println("");

                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " rectangle has area of: ");
                mOut.println("" + String.format("%.2f", rectangleArea(mLength, mWidth)));
                mOut.println("");
                break;
            case Sphere:
                mOut.print("A sphere with radius " + mRadius + " has a volume of: ");
                mOut.println("" + String.format("%.2f", sphereVolume(mRadius)));
                mOut.println("");

                mOut.print("A sphere with radius " + mRadius + " has surface area of: ");
                mOut.println("" + String.format("%.2f", sphereSurfaceArea(mRadius)));
                mOut.println("");
                // Same here as with 'Box' above. If 'Sphere' is picked, it will run the
                // two sets of print statements above and the two below until the 'break;'
            case Circle:
                mOut.print("A circle with radius " + mRadius + " has a perimeter of: ");
                mOut.println("" + String.format("%.2f", circleCircumference(mRadius)));
                mOut.println("");

                mOut.print("A circle with radius " + mRadius + " has area of: ");
                mOut.println("" + String.format("%.2f", circleArea(mRadius)));
                mOut.println("");
                break;
            case Triangle:
                mOut.print("A right triangle with base "
                        + mLength
                        + " and height "
                        + mWidth + " has a perimeter of: ");
                mOut.println(""
                        + String.format("%.2f", rightTrianglePerimeter(mLength,
                        mWidth)));
                mOut.println("");

                mOut.print("A right triangle with base "
                        + mLength
                        + " and height "
                        + mWidth
                        + " has area of: ");
                mOut.println(""
                        + String.format("%.2f", rightTriangleArea(mLength,
                        mWidth)));
                mOut.println("");
                break;
            default:
                break;
        }
    }

    public static double rectangleArea(double mLength, double mHeight) {
        double ractangle = (mLength * mHeight);
        return ractangle;
    }

    public static double rectanglePerimeter(double mWidth, double mHeight) {
        double perimeter = 2 * (mWidth + mHeight);
        return perimeter;
    }

    public static double circleArea(double mRadius) {
        double areacircle = (Math.PI * Math.pow(mRadius, 2));
        return areacircle;
    }

    public static double circleCircumference(double mRadius) {
        double circumference = (2 * Math.PI * mRadius);
        return circumference;
    }

    public static double rightTriangleArea(double mLength, double mWidth) {
        double areaTriangle = (mWidth * 0.5) * mLength;
        return areaTriangle;
    }

    public static double rightTrianglePerimeter(double mLength, double mWidth) {
        double righTriPer = mWidth + mLength + Math.hypot(mWidth, mLength);
        return righTriPer;
    }

    public static double boxVolume(double mLength, double mWidth, double mHeight) {
        double volumeBox = (mLength * mWidth * mHeight);
        return volumeBox;
    }

    public static double boxSurfaceArea(double mLength, double mWidth, double mHeight) {
        double surfaceAreabox = (2 * (mHeight * mWidth) + 2 * (mHeight * mLength) + 2 * (mWidth * mLength));
        return surfaceAreabox;
    }

    public static double sphereVolume(double mRadius) {
        double sphereV = ((4.0 / 3.0) * Math.PI * Math.pow(mRadius, 3));
        return sphereV;
    }

    public static double sphereSurfaceArea(double mRadius) {
        double areasphere = (4 * Math.PI * Math.pow(mRadius, 2));
        return areasphere;
    }
}
