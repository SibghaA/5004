package com.lastbite.app;

import android.os.Parcel;
import android.os.Parcelable;

public class PlayerPreference implements Parcelable {
    public String name;
    public String cuisine;

    public PlayerPreference(String name, String cuisine) {
        this.name = name;
        this.cuisine = cuisine;
    }

    protected PlayerPreference(Parcel in) {
        name = in.readString();
        cuisine = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(cuisine);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PlayerPreference> CREATOR = new Creator<PlayerPreference>() {
        @Override
        public PlayerPreference createFromParcel(Parcel in) {
            return new PlayerPreference(in);
        }

        @Override
        public PlayerPreference[] newArray(int size) {
            return new PlayerPreference[size];
        }
    };
}