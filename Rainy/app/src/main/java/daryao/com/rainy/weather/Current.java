package daryao.com.rainy.weather;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import daryao.com.rainy.R;

/**
 * Created by Darya on 2015-09-27.
 */
public class Current {


    private long mTime;
    private double mTemperature;
    private double mHumdity;
    private double mPrecipChance;
    private String mSummary;
    private String mIcon;
    private String mTimezone;

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public int getIconId(){
        return Forecast.getIconId(mIcon);
    }

    public long getTime() {
        return mTime;
    }

    public String getFormattedTime(){

        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(getTimezone()));
        Date dateTime = new Date(getTime()*1000);
        String timeString = formatter.format(dateTime);
        return timeString;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public int getTemperature() {
        return  (int)mTemperature;
    }

    public void setTemperature(double temperature) {
        mTemperature = (temperature-32)/1.8;
    }

    public double getHumdity() {
        return mHumdity;
    }

    public void setHumdity(double humdity) {
        mHumdity = humdity*100;
    }

    public int getPrecipChance() {
        double precipPercentage = mPrecipChance *100;
        precipPercentage = Math.round(precipPercentage);
        return (int) precipPercentage;
    }

    public void setPrecipChance(double mPrecipChance) {
        this.mPrecipChance = mPrecipChance;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

}
