package example.com.mysimplenews.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import example.com.mysimplenews.R;

/**
 * Created by ASUS-NB on 2017/3/2.
 */

public class NewsListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NewsAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_listnews,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeLayout);
        swipeRefreshLayout.setOnRefreshListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        //可以降低内存的使用
        recyclerView.setHasFixedSize(true);
        mAdapter = new NewsAdapter();
        return rootView;
    }

    @Override
    public void onRefresh() {

    }



    class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class ItemViewHolder extends RecyclerView.ViewHolder{

            public ItemViewHolder(View itemView) {
                super(itemView);
            }
        }

        class FooterViewHolder extends RecyclerView.ViewHolder{

            public FooterViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
