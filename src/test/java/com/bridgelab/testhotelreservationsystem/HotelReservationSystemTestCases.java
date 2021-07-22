package com.bridgelab.testhotelreservationsystem;

import com.bridgelab.hotelreservationsystem.HotelDetails;
import com.bridgelab.hotelreservationsystem.HotelReservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
}
