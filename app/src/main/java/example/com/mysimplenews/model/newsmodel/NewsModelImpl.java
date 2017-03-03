package example.com.mysimplenews.model.newsmodel;

import android.provider.ContactsContract;
import android.provider.SyncStateContract;
import android.util.Log;

import example.com.mysimplenews.config.Constants;
import example.com.mysimplenews.model.data.NewsInfo;
import example.com.mysimplenews.presenter.newspresenter.OnNewsCallBackListner;
import example.com.mysimplenews.util.ApiUtil;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ASUS-NB on 2017/1/21.
 */

public class NewsModelImpl implements NewsModel {

    @Override
    public void loadNews(String type, final OnNewsCallBackListner listner) {
        ApiUtil.newInstance(Constants.path)
                .loadNews(type,"cd6f63aca9759092dac67543050661f1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listner.onFailed(e);
                    }

                    @Override
                    public void onNext(NewsInfo newsInfo) {
                        Log.e("TAG",newsInfo.getReason().toString()+newsInfo.getResult().getData().get(0).getTitle());
                        listner.onSucceed(newsInfo);
                    }
                });
    }

    @Override
    public void loadNewsDetails() {

    }
}
