package com.bridgelab.testhotelreservationsystem;

import com.bridgelab.hotelreservationsystem.HotelDetails;
import com.bridgelab.hotelreservationsystem.HotelReservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/*******************************
 * @author mihir
 *
 * This is test cases class file.
 *******************************/

public class HotelReservationSystemTestCases
{
    private static HotelDetails lakeWood;
    private static HotelDetails bridgeWood;
    private static HotelDetails ridgeWood;
    private HotelReservation hotelReservation;

    /**
     * Setting hotel details in constructor.
     * passing hotel object to addHotel method to be added in list.
     */
    @BeforeAll
    public static void addHotelInformation()
    {
        com.bridgelab.hotelreservationsystem.HotelReservation hotelReservation = new HotelReservation();
        lakeWood = new HotelDetails("LakeWood", 110, 80, 90, 80);
        hotelReservation.addHotel(lakeWood);
        bridgeWood = new HotelDetails("BridgeWood", 160, 110, 60, 50);
        hotelReservation.addHotel(bridgeWood);
        ridgeWood = new HotelDetails("RidgeWood", 220, 100, 150, 40);
        hotelReservation.addHotel(ridgeWood);
    }

    @Test
    public void givenHotelDetail_whenProper_shouldReturnTrue()
    {
        hotelReservation = new HotelReservation();
        lakeWood = new HotelDetails("LakeWood", 110, 80, 90, 80);
        boolean isTrue = hotelReservation.addHotel(lakeWood);
        Assertions.assertTrue(isTrue);
    }
    @Test
    public void getCheapestHotel_whenDatesProper_shouldReturnLakewood()
    {
        hotelReservation = new HotelReservation();
        lakeWood = new HotelDetails("Lakewood",110 , 80, 90, 80);
        hotelReservation.addHotel(lakeWood);
        bridgeWood = new HotelDetails("Bridgewood",160 , 110, 60, 50);
        hotelReservation.addHotel(bridgeWood);
        ridgeWood = new HotelDetails("Ridgewood",220 , 100, 150, 40);
        hotelReservation.addHotel(ridgeWood);
        Assertions.assertEquals("Lakewood",hotelReservation.findCheapestHotel("2021-07-24","2021-07-25"));
    }
    @Test
    public void getCheapestHotel_whenDatesProvidedWrong_shouldReturnWrongInput()
    {
        hotelReservation = new HotelReservation();
        lakeWood = new HotelDetails("Lakewood",110 , 80, 90, 80);
        hotelReservation.addHotel(lakeWood);
        bridgeWood = new HotelDetails("Bridgewood",160 , 110, 60, 50);
        hotelReservation.addHotel(bridgeWood);
        ridgeWood = new HotelDetails("Ridgewood",220 , 100, 150, 40);
        hotelReservation.addHotel(ridgeWood);
        Assertions.assertEquals("Wrong Input",hotelReservation.findCheapestHotel("2020-07-25","2020-07-24"));
    }
    @Test
    public void getWeekEndRates_whenLakewood_shouldReturn80()
    {
        hotelReservation = new HotelReservation();
        lakeWood = new HotelDetails("Lakewood",110 , 80, 90, 80);
        hotelReservation.addHotel(lakeWood);
        bridgeWood = new HotelDetails("Bridgewood",160 , 110, 60, 50);
        hotelReservation.addHotel(bridgeWood);
        ridgeWood = new HotelDetails("Ridgewood",220 , 100, 150, 40);
        hotelReservation.addHotel(ridgeWood);
        Assertions.assertEquals(90,hotelReservation.hotelList.get(0).getWeekDaysRatesForRewardCustomers());
    }
    @Test
    public void getCheapestHotel_whenWeekDayAndWeekEnd_shouldReturnLakewoodAndBridgewood()
    {
        hotelReservation = new HotelReservation();
        lakeWood = new HotelDetails("Lakewood",110 , 80, 90, 80);
        hotelReservation.addHotel(lakeWood);
        bridgeWood = new HotelDetails("Bridgewood",160 , 110, 60, 50);
        hotelReservation.addHotel(bridgeWood);
        ridgeWood = new HotelDetails("Ridgewood",220 , 100, 150, 40);
        hotelReservation.addHotel(ridgeWood);
        String cheapestHotel =  hotelReservation.findCheapestHotel("2021-07-23","2021-07-24");
        Assertions.assertEquals("Bridgewood",cheapestHotel.get(0).getKey());
        Assertions.assertEquals("Lakewood",cheapestHotel.get(1).getKey());
    }
}
