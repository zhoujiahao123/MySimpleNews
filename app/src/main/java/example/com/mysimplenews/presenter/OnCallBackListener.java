package example.com.mysimplenews.presenter;

/**
 * Created by ASUS-NB on 2017/3/3.
 */

public interface OnCallBackListener  {
    void onSucceed(Object o);

    void onFailed(Throwable throwable);
}
