package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("d7NSGzdIiBDdpNOh2tNaRyWo9ehhdzwWkamEYepD")
                .clientKey("ggRgkXdjLg5yXGhFqB74GrwCTZ6qHZvOUWpZZDmO")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
