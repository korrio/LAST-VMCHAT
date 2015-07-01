package com.dev.chat.vdomax;

import android.app.Application;

import com.dev.chat.vdomax.handler.ApiBus;
import com.dev.chat.vdomax.handler.ChatApiHandler;
import com.dev.chat.vdomax.handler.ChatApiService;
import com.dev.chat.vdomax.handler.SocialApiHandler;
import com.dev.chat.vdomax.handler.SocialApiService;
import com.parse.Parse;
import com.parse.PushService;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by Adisorn on 9/3/2558.
 */
public class VMChatApp extends Application{
    public static final String IMAGE_ENDPOINT = "https://www.vdomax.com/";
    public static final String SOCIAL_ENDPOINT = "http://api.vdomax.com/1.0";
    public static final String CHAT_ENDPOINT = "http://chat.vdomax.com:1314";

    String userToken = "eyJpdiI6IlorM2g2WFFoaitOc0hwSDZLb2hkXC9RPT0iLCJ2YWx1ZSI6ImxGVTJ0R0JkaGR0VW5oZkhaVFFQdVZiT1lvXC94VUxGc0JkS1VFZUFGVTVTQ1dpd3J4dGYzYlFnYURaY0pHdWpJNGVEZ3d2Umk5NjlFMXdtTlM4NXF4M2VwY3lWdzFWN0FMbVBTR2o4bHhqR0NHXC82NU5GeGoyazNKZ2U1TVFzbUFCaEk0NndTWEZ3RjlUd0o0YkVtT21nPT0iLCJtYWMiOiIyZmRmZmQ1ZmUyNzk4NzIyZTViYzA0MmEyMTI4MTZhMGMwZGFkM2M4YzUzMjc3YmYyNDQ1NWQyYWQ0OWM3NTY2In0";

    SocialApiHandler socialApiHandler;
    ChatApiHandler chatApiHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        socialApiHandler = new SocialApiHandler(this , buildSocialApi() , ApiBus.getInstance());
        socialApiHandler.registerForEvents();

        chatApiHandler = new ChatApiHandler(this,buildChatApi(),ApiBus.getInstance());
        chatApiHandler.registerForEvents();

        Parse.initialize(this, "j6DTfeUL6JvI9PunllRInpQbUg3dJLCVNTvaAOfY", "VLESF9CjbpiRJ97A1XVllHZuBgO0TJrRJyNA3OL8");
        PushService.setDefaultPushCallback(this,MainActivity.class);
    }
    SocialApiService buildSocialApi() {
        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(SOCIAL_ENDPOINT)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("X-Auth-Token", userToken);

                    }
                })
                .build()
                .create(SocialApiService.class);
    }

    ChatApiService buildChatApi() {
        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(CHAT_ENDPOINT)
                .build()
                .create(ChatApiService.class);
    }




}
