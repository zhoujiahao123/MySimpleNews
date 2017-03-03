package example.com.mysimplenews.util.loader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.io.File;

/**
 * Created by ASUS-NB on 2017/3/3.
 */

public class GlideLoader implements ILoader {
    @Override
    public void loadFile(ImageView target, File file, Option option) {
        load(getRequestManager(target.getContext()).load(file),target,option);
    }

    @Override
    public void loadNet(ImageView target, String url, Option option) {
        load(getRequestManager(target.getContext()).load(url),target,option);
    }

    @Override
    public void loadResource(ImageView target, int resourceId, Option option) {
        load(getRequestManager(target.getContext()).load(resourceId),target,option);
    }

    @Override
    public void clearMemoryCache(Context context) {
        Glide.get(context).clearDiskCache();
    }

    @Override
    public void clearDisCache(Context context) {
        Glide.get(context).clearDiskCache();
    }

    private RequestManager getRequestManager(Context context){
        return Glide.with(context);
    }
    private void load(DrawableTypeRequest request,ImageView target,Option option){
        if(option==null){
            option = Option.defaultOptions();
        }
        if(option.loadingResId!=Option.RES_NONE){
            request.placeholder(option.loadingResId);

        }
        if(option.loadErrorId!=Option.RES_NONE){
            request.error(option.loadErrorId);
        }
        request.crossFade().into(target);
    }
}
