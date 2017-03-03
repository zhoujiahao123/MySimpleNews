package example.com.mysimplenews.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASUS-NB on 2017/3/3.
 */

public class RetrofitUtil  {
    private static Retrofit mInstance;
    public static Retrofit newInstance(String path){
        if(mInstance==null){
            mInstance= new Retrofit.Builder().baseUrl(path).addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return mInstance;
    }
}
