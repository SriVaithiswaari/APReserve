import java.util.ArrayList;
import java.util.Scanner;

public class AirplaneSeatReservationApplication {

    static int noOfPassengers;

    public static void main(String[] args)  {


        Airplane airplane = new Airplane();
        OPConsole opConsole = new OPConsole();
        InputConsole inputConsole = new InputConsole();

        ArrayList<Integer[][]> listOfSeatMatrix = inputConsole.getSeatMatrix();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Passengers: ");
        noOfPassengers = sc.nextInt();
       airplane.determineIfSeatIsWindowOrMiddleOrAisle(listOfSeatMatrix);
        airplane.fillpassangers(noOfPassengers,listOfSeatMatrix);
        opConsole.printOutput(listOfSeatMatrix);
    }
}
