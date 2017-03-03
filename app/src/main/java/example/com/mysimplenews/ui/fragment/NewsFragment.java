package example.com.mysimplenews.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import example.com.mysimplenews.R;

/**
 * Created by ASUS-NB on 2017/3/2.
 */

public class NewsFragment extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyPagerAdapter mAdapter;
    //用于标志新闻的类型
    private static final String NEWS_TOP = "top";
    private static final String NEW_SHEHUI = "shehui";
    private static final String NEWS_GUONEI = "guonei";
    private static final String NEWS_GUOJI = "guoji";
    private static final String NEWS_YULE = "yule";
    private static final String NEWS_TIYU = "tiyu";
    private static final String NEWS_JUNSHI ="junshi";
    private static final String NEWS_KEJI = "keji";
    private static final String NEWS_CAIJING = "caijing";
    private static final String NEWS_SHISHANG = "shishang";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.fragment_news,container,false);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        mAdapter = new MyPagerAdapter(getFragmentManager());
        mAdapter.addFragment(NewsListFragment.newInstance(NEWS_TOP),"头条");
        mAdapter.addFragment(NewsListFragment.newInstance(NEW_SHEHUI),"社会");
        mAdapter.addFragment(NewsListFragment.newInstance(NEWS_GUONEI),"国内");
        mAdapter.addFragment(NewsListFragment.newInstance(NEWS_GUOJI),"国际");
        mAdapter.addFragment(NewsListFragment.newInstance(NEWS_YULE),"娱乐");
        mAdapter.addFragment(NewsListFragment.newInstance(NEWS_TIYU),"体育");
        mAdapter.addFragment(NewsListFragment.newInstance(NEWS_JUNSHI),"军事");
        mAdapter.addFragment(NewsListFragment.newInstance(NEWS_KEJI),"科技");
        mAdapter.addFragment(NewsListFragment.newInstance(NEWS_CAIJING),"财经");
        mAdapter.addFragment(NewsListFragment.newInstance(NEWS_SHISHANG),"时尚");
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return rootView;
    }
    class MyPagerAdapter extends FragmentPagerAdapter{
        private List<String> mFragmentTitle = new ArrayList<>();
        private List<Fragment> mFragment= new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        private void addFragment(Fragment fragment,String title){
            mFragment.add(fragment);
            mFragmentTitle.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitle.get(position);
        }
    }

}
