package scratches.workers.commander;

import scratches.Vehicle;

public class Printer {
    public static void prf(Vehicle c){
        System.out.printf("%10d",c.getId());
        System.out.printf("%10s",c.getName());
        System.out.printf("%1$10td.%1$tm.%1$ty %1$tH:%1$tM:%1$tS     ",c.getCreationDate());
        System.out.printf("X:%15.3f км",c.getCoordinates().getX());
        System.out.printf("Y:%15.3f км",c.getCoordinates().getY());
        System.out.printf("%15.3f Дж",c.getEnginePower());
        System.out.printf("%15d км",c.getDistanceTravelled());
        try {
            System.out.printf("%15s", c.getType().toString());
        }catch (NullPointerException e){
            System.out.printf("%15s","не названо");
        }
        try {
            System.out.printf("%15s", c.getFuelType().toString());
        }catch (NullPointerException e){
            System.out.printf("%15s","не названо");
        }
        System.out.println();
    }
}
