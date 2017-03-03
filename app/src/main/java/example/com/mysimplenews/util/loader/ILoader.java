package example.com.mysimplenews.util.loader;

import android.content.Context;
import android.widget.ImageView;

import java.io.File;

import example.com.mysimplenews.config.Constants;

/**
 * Created by ASUS-NB on 2017/3/3.
 */

public interface ILoader {
    void loadFile(ImageView target,File file,Option option);
    void loadNet(ImageView target,String url,Option option);
    void loadResource(ImageView target,int resourceId,Option option);
    void clearMemoryCache(Context context);
    void clearDisCache(Context context);


    class Option {
        public static final int RES_NONE=-1;
        public int loadingResId = RES_NONE;
        public int loadErrorId = RES_NONE;

        public static Option defaultOptions(){
            return new Option(Constants.loadingResId,Constants.loadErrorResId);
        }

        public Option(int loadingResId,int loadErrorId){
            this.loadErrorId = loadErrorId;
            this.loadingResId = loadingResId;
        }
    }
}
