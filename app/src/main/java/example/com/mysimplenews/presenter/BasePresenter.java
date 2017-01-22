package example.com.mysimplenews.presenter;

import example.com.mysimplenews.model.BaseModel;
import example.com.mysimplenews.ui.view.BaseView;

/**
 * Created by ASUS-NB on 2017/1/21.
 */

public  class BasePresenter<T extends BaseView,T2 extends BaseModel>{
    T view;
    T2 model;
    void setVM(T view,T2 model){
        this.view = view;
        this.model = model;
    }
}
