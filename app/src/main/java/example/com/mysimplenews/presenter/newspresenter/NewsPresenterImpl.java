package example.com.mysimplenews.presenter.newspresenter;

import android.util.Log;

import example.com.mysimplenews.model.data.NewsInfo;
import example.com.mysimplenews.model.newsmodel.NewsModel;
import example.com.mysimplenews.ui.view.NewsView;

/**
 * Created by ASUS-NB on 2017/3/3.
 */

public class NewsPresenterImpl extends NewsPresenter implements OnNewsCallBackListner{
    private NewsView view;
    private NewsModel model;
    public NewsPresenterImpl(NewsView view, NewsModel model){
        this.view = view;
        this.model = model;
    }
    @Override
    public void loadNews(String type) {
        model.loadNews(type,this);
    }

    @Override
    public void onSucceed(Object o) {
        if(o instanceof NewsInfo){
            view.loadNewsSucceed((NewsInfo)o);
            Log.e("onSucceed","成功了");
        }
    }

    @Override
    public void onFailed(Throwable throwable) {
        Log.e("onFailed","获取新闻数据的时候失败了");
    }
}
