package example.com.mysimplenews.util.loader;

/**
 * Created by ASUS-NB on 2017/3/3.
 */

public class LoaderFactory {
    public static ILoader loader;
    public static ILoader getLoader(){
        if(loader==null){
            synchronized (LoaderFactory.class){
                if(loader==null){
                    loader = new GlideLoader();
                }
            }
        }
        return loader;
    }
}
