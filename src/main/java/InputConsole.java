import java.util.ArrayList;
import java.util.Scanner;

public class InputConsole {

    public  ArrayList<Integer[][]> getSeatMatrix() {

        ArrayList<Integer[][]> listOfSeatMatrices = new ArrayList<>();
        int noOfSeatMatrix;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Seat Matrices: ");
        noOfSeatMatrix = sc.nextInt();

        int noOfRows, noOfColumns;

        for(int i=0; i< noOfSeatMatrix ; i++){
            System.out.print("Enter the number of rows & columns in SeatMatrix " + i + ": ");
            noOfRows = sc.nextInt();
            noOfColumns = sc.nextInt();
            listOfSeatMatrices.add(new Integer[noOfRows][noOfColumns]);
        }

        return listOfSeatMatrices;
    }
}
