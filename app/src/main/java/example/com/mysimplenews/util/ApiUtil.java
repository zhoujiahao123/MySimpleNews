package example.com.mysimplenews.util;

import example.com.mysimplenews.config.Api;

/**
 * Created by ASUS-NB on 2017/3/3.
 */

public class ApiUtil  {
    private static Api mInstance;
    public static Api newInstance(String path){
        if(mInstance == null){
            mInstance = RetrofitUtil.newInstance(path).create(Api.class);
        }
        return mInstance;
    }
}
