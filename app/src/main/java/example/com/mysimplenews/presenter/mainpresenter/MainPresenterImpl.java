package example.com.mysimplenews.presenter.mainpresenter;

import example.com.mysimplenews.R;
import example.com.mysimplenews.model.mainmodel.MainModel;
import example.com.mysimplenews.ui.view.MainView;

/**
 * Created by ASUS-NB on 2017/1/21.
 */

public class MainPresenterImpl extends MainPresenter {
    private MainModel mainModel;
    private MainView mainView;


    public MainPresenterImpl(MainView mainView,MainModel model) {
        setVM(mainView,model);
    }

    @Override
    public void setVM(MainView view, MainModel model) {
        mainModel = model;
        mainView = view;
    }

    @Override
    public void switchNavigation(int id) {
        switch (id){
            case R.id.news:
                mainView.showNews();
                break;
            case R.id.weather:
                mainView.showWeather();
                break;
            case R.id.photo:
                mainView.showPhoto();
                break;
            case R.id.about:
                mainView.showAbout();
                break;
        }
    }


}
