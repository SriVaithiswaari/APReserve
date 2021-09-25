import java.util.ArrayList;

public class Airplane {


    public int determinecapacity(ArrayList<Integer[][]> listOfSeatMatrix) {
        int capacity =0;
        for(int rowNumber=0;rowNumber<listOfSeatMatrix.size();rowNumber++){
            capacity += listOfSeatMatrix.get(rowNumber).length*listOfSeatMatrix.get(rowNumber)[0].length;
        }
        return capacity;

    }

    // 1000 - A , 1001 - W , 1002 - M
     ArrayList<Integer[][]> determineIfSeatIsWindowOrMiddleOrAisle(ArrayList<Integer[][]> listOfSeatMatrix) {

        int noOfRows, noOfColumns , index;

        for (index =0; index< listOfSeatMatrix.size(); index++){
            if (index == 0){
                for (noOfColumns = 0; noOfColumns < listOfSeatMatrix.get(index)[0].length; noOfColumns++) {
                    for (noOfRows = 0; noOfRows < listOfSeatMatrix.get(index).length; noOfRows++) {
                        if (noOfColumns == 0) {listOfSeatMatrix.get(index)[noOfRows][noOfColumns] = 1001;}
                        else if (noOfColumns == listOfSeatMatrix.get(index)[0].length- 1) {
                            listOfSeatMatrix.get(index)[noOfRows][noOfColumns] = 1000;
                        } else listOfSeatMatrix.get(index)[noOfRows][noOfColumns] = 1002;

                    }
                }
            }

            else if (index == listOfSeatMatrix.size() -1){
                for (noOfColumns = 0; noOfColumns < listOfSeatMatrix.get(index)[0].length; noOfColumns++) {
                    for (noOfRows = 0; noOfRows < listOfSeatMatrix.get(index).length; noOfRows++) {
                        if (noOfColumns == 0) listOfSeatMatrix.get(index)[noOfRows][noOfColumns] = 1000;
                        else if (noOfColumns == listOfSeatMatrix.get(index)[0].length- 1) {
                            listOfSeatMatrix.get(index)[noOfRows][noOfColumns] = 1001;
                        } else listOfSeatMatrix.get(index)[noOfRows][noOfColumns] = 1002;

                    }
                }
            }

            else {
                for (noOfColumns = 0; noOfColumns < listOfSeatMatrix.get(index)[0].length; noOfColumns++) {
                    for (noOfRows = 0; noOfRows < listOfSeatMatrix.get(index).length; noOfRows++) {
                        if (noOfColumns == 0 || noOfColumns == listOfSeatMatrix.get(index)[0].length - 1) listOfSeatMatrix.get(index)[noOfRows][noOfColumns] = 1000;
                        else listOfSeatMatrix.get(index)[noOfRows][noOfColumns] = 1002;

                    }
                }
            }
        }
        return listOfSeatMatrix;
    }




     ArrayList<Integer[][]> fillpassangers(int passangercount, ArrayList<Integer[][]> listOfSeatMatrix) {

        int flightCapacity = determinecapacity(listOfSeatMatrix);

        int passengerNumber = 1;
        int index,noOfRows, noOfColumns,seatflag=1000;

        do {
            for (index = 0; index < listOfSeatMatrix.size(); index++) {
                for (noOfRows = 0; noOfRows < listOfSeatMatrix.get(index).length; noOfRows++) {
                    for (noOfColumns = 0; noOfColumns < listOfSeatMatrix.get(index)[0].length && passengerNumber <= passangercount; noOfColumns++) {
                        if(passengerNumber <= flightCapacity) {
                            if (listOfSeatMatrix.get(index)[noOfRows][noOfColumns] == seatflag) {
                                listOfSeatMatrix.get(index)[noOfRows][noOfColumns] = passengerNumber;
                                passengerNumber++;
                            }
                        }
                        else System.out.println("Seat is not allocated from Passenger Number " + passengerNumber + " as flight capacity is " + flightCapacity);
                    }
                }
            }
            seatflag++;
        } while(passengerNumber<=passangercount && passengerNumber <=flightCapacity && seatflag <= 1002);
        return listOfSeatMatrix;
    }

}








