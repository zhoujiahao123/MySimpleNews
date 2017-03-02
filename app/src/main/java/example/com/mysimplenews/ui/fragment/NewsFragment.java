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

import java.util.List;

import example.com.mysimplenews.R;

/**
 * Created by ASUS-NB on 2017/3/2.
 */

public class NewsFragment extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyPagerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.fragment_news,container,false);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        mAdapter = new MyPagerAdapter(getFragmentManager());
        return rootView;
    }
    class MyPagerAdapter extends FragmentPagerAdapter{
        private List<String> mFragmentTitle;
        private List<Fragment> mFragment;

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
