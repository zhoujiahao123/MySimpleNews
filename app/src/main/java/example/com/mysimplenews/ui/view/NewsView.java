package example.com.mysimplenews.ui.view;

import example.com.mysimplenews.model.data.NewsInfo;

/**
 * Created by ASUS-NB on 2017/1/21.
 */

public interface NewsView extends BaseView {
    void loadNews(String type);

    void loadNewsSucceed(NewsInfo newsInfo);
}
