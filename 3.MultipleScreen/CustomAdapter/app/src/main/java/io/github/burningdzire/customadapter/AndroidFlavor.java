package io.github.burningdzire.customadapter;

public class AndroidFlavor {
    private String mVersionName;
    private String mVersionNumber;
    private int mImageResourceId;

    public AndroidFlavor(String name, String version, int imageResourceId) {
        mVersionName = name;
        mVersionNumber = version;
        mImageResourceId = imageResourceId;
    }

    public String getmVersionName() {
        return mVersionName;
    }

    public String getmVersionNumber() {
        return mVersionNumber;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
}
