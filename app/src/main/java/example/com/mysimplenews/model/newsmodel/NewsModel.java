package example.com.mysimplenews.model.newsmodel;

import example.com.mysimplenews.model.BaseModel;

/**
 * Created by ASUS-NB on 2017/1/21.
 */

public interface NewsModel extends BaseModel{

    void loadNews();

    void loadNewsDetails();
}
