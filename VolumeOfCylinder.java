public class VolumeOfCylinder {
    public static final double PI = 3.141592;

    public static void main(String[] args) {
        double radius = 0;
        double height = 0;

        if (args.length > 2) {
            System.out.println("Too many arguments.");
            return;
        }
        try {
            radius = Double.parseDouble(args[0]);
            height = Double.parseDouble(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough arguments.");
            return;
        }

        if (radius < 0) {
            System.out.println("Radius cannot be negative.");
            return;
        } else if (height < 0) {
            System.out.println("Height cannot be negative.");
            return;
        }

        double volume = radius * radius * height * PI;
        String roundedVolume = String.format("%.2f", volume);
        System.out.println("The volume of the cylinder is " + roundedVolume + ".");
    }
}
