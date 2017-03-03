package example.com.mysimplenews.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.com.mysimplenews.R;
import example.com.mysimplenews.model.data.NewsInfo;
import example.com.mysimplenews.model.newsmodel.NewsModel;
import example.com.mysimplenews.model.newsmodel.NewsModelImpl;
import example.com.mysimplenews.presenter.newspresenter.NewsPresenter;
import example.com.mysimplenews.presenter.newspresenter.NewsPresenterImpl;
import example.com.mysimplenews.ui.view.NewsView;
import example.com.mysimplenews.util.loader.GlideLoader;
import example.com.mysimplenews.util.loader.ILoader;
import example.com.mysimplenews.util.loader.LoaderFactory;

/**
 * Created by ASUS-NB on 2017/3/2.
 */

public class NewsListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,NewsView{
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NewsAdapter mAdapter;
    private NewsPresenter newsPresenter;
    //标志目前所处的页数
    private int pageIndex;
    private List<NewsInfo.ResultBean.DataBean> dataBeen = new ArrayList<>();
    //数据
    private List<NewsInfo.ResultBean.DataBean> mData = new ArrayList<>();
    //用于标志当前新闻的类型
    private static String type;
    //获取Loader
    private ILoader loader;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    OnItemClickListener listener;
    public void setOnClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public static NewsListFragment newInstance(String type){
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putString("type",type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getString("type");
        newsPresenter = new NewsPresenterImpl(this,new NewsModelImpl());
        loader = LoaderFactory.getLoader();
    }

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
        recyclerView.setAdapter(mAdapter);
        onRefresh();
        return rootView;
    }

    @Override
    public void onRefresh() {
        Log.e("onRefresh","开始请求新闻");
        pageIndex = 0;
        if(mData!=null){
            mData.clear();
        }
        newsPresenter.loadNews(type);
    }

    @Override
    public void loadNews(String type) {
        newsPresenter.loadNews(type);
    }

    @Override
    public void loadNewsSucceed(NewsInfo newsInfo) {
        if(newsInfo.getReason().equals("成功的返回")){
            int size = newsInfo.getResult().getData().size();

            for(int i=0;i<size;i++){
                dataBeen.add(newsInfo.getResult().getData().get(i));
            }
            mData.clear();
            mData.addAll(dataBeen);
            mAdapter.setData(mData);
        }
    }


    class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        final private  int TYPE_ITEM=0;
        final private int TYPE_FOOTER = 1;
        private List<NewsInfo.ResultBean.DataBean> dataBeen = new ArrayList<>();
        private List<NewsInfo.ResultBean.DataBean> mData = new ArrayList<>();

        public void setData(List<NewsInfo.ResultBean.DataBean> data){
            int size = data.size();
            for(int i=0;i<size;i++){
                dataBeen.add(data.get(i));
            }
            mData.clear();
            mData.addAll(dataBeen);
            this.notifyDataSetChanged();
        }
        @Override
        public int getItemViewType(int position) {
            if(position+1==mData.size()){
                return TYPE_FOOTER;
            }else {
                return TYPE_ITEM;
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_newslist_item,parent,false);
            View view1 = LayoutInflater.from(getContext()).inflate(R.layout.item_newslist_footer,parent,false);
            if(viewType==TYPE_ITEM){
                Log.e("onCreateViewHolder","执行了");
                return new ItemViewHolder(view);

            }else if(viewType ==TYPE_FOOTER){
                Log.e("onCreateViewHolder","执行了oo");
                return new FooterViewHolder(view1);
            }
            Log.e("onCreateViewHolder","执行了"+viewType);
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof ItemViewHolder){
                Log.e("onBindViewHolder","onBindViewHolder");
                ((ItemViewHolder) holder).newsTitle.setText(mData.get(position).getTitle());
                loader.loadNet(((ItemViewHolder) holder).newsImage1,mData.get(position).getThumbnail_pic_s(),null);
                loader.loadNet(((ItemViewHolder) holder).newsImage2,mData.get(position).getThumbnail_pic_s02(),null);
                loader.loadNet(((ItemViewHolder) holder).newsImage3,mData.get(position).getThumbnail_pic_s03(),null);
            }
        }

        @Override
        public int getItemCount() {
            if(mData == null) {
                return 0;
            }
            return mData.size();
        }

        class ItemViewHolder extends RecyclerView.ViewHolder{
            TextView newsTitle;
            ImageView newsImage1,newsImage2,newsImage3;
            public ItemViewHolder(View itemView) {
                super(itemView);
                newsTitle = (TextView) itemView.findViewById(R.id.news_title);
                newsImage1 = (ImageView) itemView.findViewById(R.id.news_image1);
                newsImage2 = (ImageView) itemView.findViewById(R.id.news_image2);
                newsImage3 = (ImageView) itemView.findViewById(R.id.news_image3);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onItemClick(getPosition());
                    }
                });
            }
        }

        class FooterViewHolder extends RecyclerView.ViewHolder{

            public FooterViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
