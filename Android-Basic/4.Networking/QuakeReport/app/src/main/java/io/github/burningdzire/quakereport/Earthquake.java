package io.github.burningdzire.quakereport;

public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;

    public Earthquake(double magnitude, String location, long timeInMilliseconds)
    {
        mMagnitude = magnitude;
        mLocation =location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public double getmMagnitude()
    {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getmTimeInMilliseconds()
    {
        return mTimeInMilliseconds;
    }
}
