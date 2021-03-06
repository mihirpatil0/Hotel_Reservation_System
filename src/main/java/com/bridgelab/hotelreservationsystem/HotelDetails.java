package com.bridgelab.hotelreservationsystem;

/**
 * @author mihir
 *
 * This class is having attributes that defines hotel name,
 * And thrie rates.
 *
 * @since 19-July-2021
 */
public class HotelDetails
{
    private String hotelName;
    private int weekDaysRatesForRegularCustomers;
    private int weekEndDaysRatesForRegularCustomers;
    private int weekDaysRatesForRewardCustomers;
    private int weekEndDaysRatesForRewardCustomers;
    private int rating;

    public HotelDetails(String hotelName, int weekDaysRatesForRegularCustomers, int weekEndDaysRatesForRegularCustomers, int weekDaysRatesForRewardCustomers, int weekEndDaysRatesForRewardCustomers) {
        this.hotelName = hotelName;
        this.weekDaysRatesForRegularCustomers = weekDaysRatesForRegularCustomers;
        this.weekEndDaysRatesForRegularCustomers = weekEndDaysRatesForRegularCustomers;
        this.weekDaysRatesForRewardCustomers = weekDaysRatesForRewardCustomers;
        this.weekEndDaysRatesForRewardCustomers = weekEndDaysRatesForRewardCustomers;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekDaysRatesForRegularCustomers() {
        return weekDaysRatesForRegularCustomers;
    }

    public void setWeekDaysRatesForRegularCustomers(int weekDaysRatesForRegularCustomers) {
        this.weekDaysRatesForRegularCustomers = weekDaysRatesForRegularCustomers;
    }

    public int getWeekEndDaysRatesForRegularCustomers() {
        return weekEndDaysRatesForRegularCustomers;
    }

    public void setWeekEndDaysRatesForRegularCustomers(int weekEndDaysRatesForRegularCustomers) {
        this.weekEndDaysRatesForRegularCustomers = weekEndDaysRatesForRegularCustomers;
    }

    public int getWeekDaysRatesForRewardCustomers() {
        return weekDaysRatesForRewardCustomers;
    }

    public void setWeekDaysRatesForRewardCustomers(int weekDaysRatesForRewardCustomers) {
        this.weekDaysRatesForRewardCustomers = weekDaysRatesForRewardCustomers;
    }

    public int getWeekEndDaysRatesForRewardCustomers() {
        return weekEndDaysRatesForRewardCustomers;
    }

    public void setWeekEndDaysRatesForRewardCustomers(int weekEndDaysRatesForRewardCustomers) {
        this.weekEndDaysRatesForRewardCustomers = weekEndDaysRatesForRewardCustomers;
    }

    @Override
    public String
    toString() {
        return "HotelDetails{" +
                "hotelName='" + hotelName + '\'' +
                ", weekDaysRatesForRegularCustomers=" + weekDaysRatesForRegularCustomers +
                ", weekEndDaysRatesForRegularCustomers=" + weekEndDaysRatesForRegularCustomers +
                ", weekDaysRatesForRewardCustomers=" + weekDaysRatesForRewardCustomers +
                ", weekEndDaysRatesForRewardCustomers=" + weekEndDaysRatesForRewardCustomers +
                ", rating=" + rating +
                '}';
    }
}
