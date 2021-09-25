import java.util.ArrayList;
import java.util.Arrays;

public class OPConsole {

    public void printOutput(ArrayList<Integer[][]> listOfSeatMatrix) {

        int index,rowNumber,columnNumber;
        for (index = 0; index < listOfSeatMatrix.size(); index++) {
            for (rowNumber = 0; rowNumber < listOfSeatMatrix.get(index).length; rowNumber++) {
                for (columnNumber = 0; columnNumber < listOfSeatMatrix.get(index)[0].length ; columnNumber++) {
                    if(listOfSeatMatrix.get(index)[rowNumber][columnNumber] >= 1000) {
                        listOfSeatMatrix.get(index)[rowNumber][columnNumber] = 0;
                    }
                }
            }
        }
        System.out.println("After Seat Allocation");
        for (Integer[][] eachSeatMatrix: listOfSeatMatrix){
            System.out.println(Arrays.deepToString(eachSeatMatrix));
        }
    }
}
