import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AirplaneSeatReservationTest {

    static ArrayList<Integer[][]> listOfSeatMatrices = new ArrayList<>();
    static Airplane airplane = new Airplane();

    ArrayList<Integer[][]> getListOfSeatMatrices(){
     ArrayList<Integer[][]> listOfSeatMatrices = new ArrayList<>();
     listOfSeatMatrices.add(new Integer[2][3]);
     listOfSeatMatrices.add(new Integer[2][4]);
     listOfSeatMatrices.add(new Integer[3][3]);
     listOfSeatMatrices.add(new Integer[6][3]);

     return listOfSeatMatrices;
   }

    @Test
    void when_listOfSeatMatrices_is_passed_return_AirplaneCapacity(){
        Assertions.assertEquals(airplane.determinecapacity(getListOfSeatMatrices()),41);
    }

    @Test
    void when_specific_listOfSeatMatrices_is_passed_check_00cell_of_Zerothmatrix_is_Window(){
      listOfSeatMatrices = airplane.determineIfSeatIsWindowOrMiddleOrAisle(getListOfSeatMatrices());
        Assertions.assertEquals(1001,listOfSeatMatrices.get(0)[0][0]);
    }

    @Test
    void when_specific_listOfSeatMatrices_is_passed_check_00cell_of_firstmatrix_is_Aisle(){
        listOfSeatMatrices = airplane.determineIfSeatIsWindowOrMiddleOrAisle(getListOfSeatMatrices());
        Assertions.assertEquals(1000,listOfSeatMatrices.get(1)[0][0]);
    }

    @Test
    void when_specific_listOfSeatMatrices_is_passed_check_01cell_of_secondmatrix_is_Middle(){
        Airplane airplane = new Airplane();
        listOfSeatMatrices = airplane.determineIfSeatIsWindowOrMiddleOrAisle(getListOfSeatMatrices());
        Assertions.assertEquals(1002,listOfSeatMatrices.get(2)[0][1]);
    }


/*    [[19, 27, 1], [20, 28, 2]]
            [[3, 29, 30, 4], [5, 0, 0, 6]]
            [[7, 0, 8], [9, 0, 10], [11, 0, 12]]
            [[13, 0, 21], [14, 0, 22], [15, 0, 23], [16, 0, 24], [17, 0, 25], [18, 0, 26]]*/
    @Test
    void Fill_passengers_in_row_orderof_Aisle_Window_Middle(){
        Airplane airplane = new Airplane();
        listOfSeatMatrices = airplane.fillpassangers(30,airplane.determineIfSeatIsWindowOrMiddleOrAisle(getListOfSeatMatrices()));
        Assertions.assertEquals(7, listOfSeatMatrices.get(2)[0][0]);
        Assertions.assertEquals(14, listOfSeatMatrices.get(3)[1][0]);
        Assertions.assertEquals(28, listOfSeatMatrices.get(0)[1][1]);
        Assertions.assertEquals(30, listOfSeatMatrices.get(1)[0][2]);

    }




 }
