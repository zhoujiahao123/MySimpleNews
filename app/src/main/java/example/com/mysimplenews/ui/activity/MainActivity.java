package example.com.mysimplenews.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.mysimplenews.R;
import example.com.mysimplenews.app.BaseActivity;
import example.com.mysimplenews.model.mainmodel.MainModelImpl;
import example.com.mysimplenews.presenter.mainpresenter.MainPresenter;
import example.com.mysimplenews.presenter.mainpresenter.MainPresenterImpl;
import example.com.mysimplenews.ui.fragment.NewsFragment;
import example.com.mysimplenews.ui.view.MainView;

/**
 * Created by ASUS-NB on 2017/1/21.
 */

public class MainActivity extends BaseActivity implements MainView{
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.activity_main)
    DrawerLayout activityMain;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        showNews();
    }

    private void init(){
        setSupportActionBar(toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        drawerToggle = new ActionBarDrawerToggle(this,activityMain,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerToggle.syncState();
        activityMain.setDrawerListener(drawerToggle);
        setupDrawerContent();
        presenter = new MainPresenterImpl(this,new MainModelImpl());
    }
    private void setupDrawerContent(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                presenter.switchNavigation(item.getItemId());
                item.setChecked(true);
                activityMain.closeDrawers();
                return true;
            }
        });

    }

    @Override
    public void showNews() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new NewsFragment()).commit();
        toolbar.setTitle("新闻");
    }

    @Override
    public void showWeather() {

    }

    @Override
    public void showPhoto() {

    }

    @Override
    public void showAbout() {

    }
}
