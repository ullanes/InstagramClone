package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
        // set applicationId, and server server based on the values in the back4app settings.
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("QjmEa55ACW24nlYQBn6C75H47aPEqugJzqC4f03p")
                .clientKey("VJmnTrESvLi8vheaEW9WpZzUJykMQ26mSu9QV8S4")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
