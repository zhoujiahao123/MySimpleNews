package example.com.mysimplenews.presenter.newspresenter;

import example.com.mysimplenews.model.newsmodel.NewsModel;
import example.com.mysimplenews.presenter.BasePresenter;
import example.com.mysimplenews.ui.view.NewsView;

/**
 * Created by ASUS-NB on 2017/3/3.
 */

public abstract class NewsPresenter extends BasePresenter<NewsView,NewsModel> {
    public abstract void loadNews(String type);
}
