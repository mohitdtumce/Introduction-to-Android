package io.github.burningdzire.quakereport;

public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String mUrl;

    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url)
    {
        mMagnitude = magnitude;
        mLocation =location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
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

    public String getmUrl() { return mUrl; }
}
