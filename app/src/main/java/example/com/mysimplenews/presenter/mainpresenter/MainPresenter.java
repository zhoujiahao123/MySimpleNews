package example.com.mysimplenews.presenter.mainpresenter;

import example.com.mysimplenews.model.mainmodel.MainModel;
import example.com.mysimplenews.presenter.BasePresenter;
import example.com.mysimplenews.ui.view.MainView;

/**
 * Created by ASUS-NB on 2017/1/21.
 */

public abstract class MainPresenter extends BasePresenter<MainView,MainModel> {
    public abstract void setVM(MainView view,MainModel model);
    public abstract void switchNavigation(int id);
}
