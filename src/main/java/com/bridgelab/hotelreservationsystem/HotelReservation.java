package com.bridgelab.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * Name : findCheapestHotel
     *
     * Description : Finding cheapest hotel available as per given provided date.
     *
     * @param startDate
     * @param endDate
     * @return
     *
     * Modification : First commit 19-July-2021.
     */
    public String findCheapestHotel(String startDate,String endDate)
    {
        LocalDate localStartDate = LocalDate.parse(startDate);
        LocalDate localEndDate = LocalDate.parse(endDate);

        if (localStartDate.compareTo(localEndDate) <= 0 && localStartDate.compareTo(LocalDate.now()) >= 0)
        {
            HashMap<String,Integer> hotelPricesList = new HashMap<>();
            while(localStartDate.compareTo(localEndDate) <= 0)
            {
                for (HotelDetails hotel : hotelList)
                {
                    if (localStartDate.getDayOfWeek() == DayOfWeek.SUNDAY|| localStartDate.getDayOfWeek() == DayOfWeek.SATURDAY )
                    {
                        setHotelsAndPrice(hotelPricesList, hotel, hotel.getWeekEndDaysRatesForRegularCustomers());
                    }
                    else
                    {
                        setHotelsAndPrice(hotelPricesList, hotel, hotel.getWeekDaysRatesForRegularCustomers());
                    }
                }
                localStartDate=localStartDate.plusDays(1); //incrementing the days
            }
            int minvalue = hotelPricesList.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).get().getValue();
            List<Map.Entry<String, Integer>> minPricehotel = hotelPricesList.entrySet().stream().filter(price -> price.getValue().equals(minvalue)).collect(Collectors.toList());
            return String.valueOf(minPricehotel);
        }
        else
        {
            System.out.println("Invalid dates");
            return null  ;
        }
    }

    /**
     * Name : setHotelsAndPrice
     *
     * Description : Setting hotels with there priceses.
     *
     * @param hotelPricesList
     * @param hotel
     * @param rate
     *
     * Modification: First commit 19-July-2021.
     */
    private void setHotelsAndPrice(HashMap<String, Integer> hotelPricesList, HotelDetails hotel, int rate)
    {
        if (hotelPricesList.containsKey(hotel.getHotelName()))
        {
            int exsistingAmount =  hotelPricesList.get(hotel.getHotelName());
            exsistingAmount += rate;
            hotelPricesList.put(hotel.getHotelName(), exsistingAmount);
        }
        else
        {
            hotelPricesList.put(hotel.getHotelName(), rate);
        }
    }

    /**
     * Name: ratings
     *
     * Description : Adding rating to respective hotels.
     *
     * @param lakeWood
     * @param rating
     *
     * Modification : First commit 19-July-2021.
     */
    public void setRatingsOfHotel(HotelDetails lakeWood, int rating)
    {
        lakeWood.setRating(3);
    }

    /**
     * Name : cheapestBestRatedHotel
     *
     * Description : As date provided returning best rated cheapest hotel.
     * @param startDate
     * @param endDate
     * @return
     *
     * Modification : First commit 19-July-2021.
     */
    public HashMap<Integer, List<Map.Entry<String, Integer>>> cheapestBestRatedHotel(String startDate, String endDate)
    {
        try
        {
            HashMap<String, Integer> cheapHotelsWithBestRating = new HashMap<String, Integer>();
            List<Map.Entry<String, Integer>> cheapHotels = findCheapestHotel(startDate, endDate);
            for (HotelDetails hotel : hotelList)
            {
                for (Map.Entry<String, Integer> cheapHotel : cheapHotels)
                {
                    if (cheapHotel.getKey().equals(hotel.getHotelName()))
                    {
                        cheapHotelsWithBestRating.put(hotel.getHotelName(),hotel.getRating());
                    }
                }
            }
            int maxRating = cheapHotelsWithBestRating.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
            List<Map.Entry<String, Integer>> maxRatedHotel = cheapHotelsWithBestRating.entrySet().stream().filter(price -> price.getValue().equals(maxRating)).collect(Collectors.toList());
            HashMap<Integer ,List<Map.Entry<String, Integer>>> bestRatedHotels = new HashMap<Integer, List<Map.Entry<String,Integer>>>();
            bestRatedHotels.put(cheapHotels.get(0).getValue(), maxRatedHotel);
            return bestRatedHotels;
        }
        catch (Exception e)
        {
            System.out.println("Invalid dates");
            return null;
        }
    }

    /**
     * Name : getBestRatedHotel
     *
     * Description : Finding highest rated hotel amongst all.
     *
     * @param hotelsWithBestRating
     * @return
     *
     * Modification : First commit 19-July-2021.
     */
    private List<Map.Entry<String, Integer>> getBestRatedHotel(HashMap<String, Integer> hotelsWithBestRating)
    {
        int maxRating = hotelsWithBestRating.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
        List<Map.Entry<String, Integer>> maxRatedHotel = hotelsWithBestRating.entrySet().stream().filter(price -> price.getValue().equals(maxRating)).collect(Collectors.toList());
        return maxRatedHotel;
    }
}
