package com.example.android.Retrofig2;

public class APIUtils {
    public static final String baseurl = "http://192.168.1.15/GiaSu1/";

    public static DataClient getData() {
        return RetrofigClient.getClient(baseurl).create(DataClient.class);
    }
}
