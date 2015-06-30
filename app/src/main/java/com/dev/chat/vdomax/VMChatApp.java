package com.dev.chat.vdomax;

import android.app.Application;
import android.util.Log;

import com.dev.chat.vdomax.handler.ApiBus;
import com.dev.chat.vdomax.handler.ApiHandler;
import com.dev.chat.vdomax.handler.ApiService;
import com.parse.Parse;
import com.parse.PushService;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by Adisorn on 9/3/2558.
 */
public class VMChatApp extends Application{
    public static String IMAGE_ENDPOINT = "https://www.vdomax.com/";
    String userToken = "eyJpdiI6IlorM2g2WFFoaitOc0hwSDZLb2hkXC9RPT0iLCJ2YWx1ZSI6ImxGVTJ0R0JkaGR0VW5oZkhaVFFQdVZiT1lvXC94VUxGc0JkS1VFZUFGVTVTQ1dpd3J4dGYzYlFnYURaY0pHdWpJNGVEZ3d2Umk5NjlFMXdtTlM4NXF4M2VwY3lWdzFWN0FMbVBTR2o4bHhqR0NHXC82NU5GeGoyazNKZ2U1TVFzbUFCaEk0NndTWEZ3RjlUd0o0YkVtT21nPT0iLCJtYWMiOiIyZmRmZmQ1ZmUyNzk4NzIyZTViYzA0MmEyMTI4MTZhMGMwZGFkM2M4YzUzMjc3YmYyNDQ1NWQyYWQ0OWM3NTY2In0";
    String  ENDPOINT = "http://api.vdomax.com/1.0";
    ApiHandler apiHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        apiHandler = new ApiHandler(this , buildApi() , ApiBus.getInstance());
        apiHandler.registerForEvents();

        Parse.initialize(this, "f3BJWwfjsWAMChh6KE5DpI3nWasUdWy9UH6ZGH0M", "PAckyxpaUd5oPkV0qlie9ewd4qgq1A4iDfcPBAOu");
        PushService.setDefaultPushCallback(this,MainActivity.class);
    }
    ApiService buildApi() {

        Log.e("HEY!", "after post");

        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(ENDPOINT)

                .setRequestInterceptor(new RequestInterceptor() {
                    @Override public void intercept(RequestFacade request) {
                        request.addHeader("X-Auth-Token" ,userToken );
                        //request.addQueryParam("p1", "var1");
                        //request.addQueryParam("p2", "");
                    }
                })

                .build()
                .create(ApiService.class);
    }


}
