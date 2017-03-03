package example.com.mysimplenews.config;

import example.com.mysimplenews.model.data.NewsInfo;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ASUS-NB on 2017/3/3.
 */

public interface Api {
    @GET("/toutiao/index")
    Observable<NewsInfo> loadNews(@Query("type") String type,@Query("key")String key);
}
