package com.dev.chat.vdomax.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Adisorn on 3/3/2558.
 */
public class Utils {
    public static View inflastLayout(Context context , int layout_Id){
        View view;
        LayoutInflater inflater = (LayoutInflater)   context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout_Id, null);
        return view;
    }
}
