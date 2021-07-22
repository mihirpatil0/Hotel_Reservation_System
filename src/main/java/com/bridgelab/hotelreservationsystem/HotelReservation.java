package com.bridgelab.hotelreservationsystem;

import java.util.ArrayList;
import java.util.List;

/*********************************************************************************
 * @author mihir
 *
 * This class holdes all the methods that defines hotel reservation system project.
 *
 * @since 19-July-2021
 *********************************************************************************/

public class HotelReservation
{
    //ArrayList will used to store different hotels
    public List<HotelDetails> hotelList;

    //Constructor
    public HotelReservation()
    {
        this.hotelList = new ArrayList<>();
    }

    /**
     * Name : addHotel
     *
     * Description : Adding hotel into list.
     *
     * Algorithm : Adding hotelDetails object that holds all the information of hotels
     * into list.
     *
     * @param hotel : HotelDetails object.
     * @return : true or false.
     *
     * Modification : First commit 19-July-2021.
     */
    public boolean addHotel(HotelDetails hotel)
    {
        if(hotelList.add(hotel))
        {
            return true;
        }
        return false;
    }
}
