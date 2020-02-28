package com.example.zdh_dsxm_demo.adapters;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdh_dsxm_demo.R;
import com.example.zdh_dsxm_demo.base.BaseAdapter;
import com.example.zdh_dsxm_demo.bean.IndexBean;

import java.util.List;

public class JjAdapter extends BaseAdapter {
    public JjAdapter(List list) {
        super(list);
    }

    @Override
    protected int getLayout() {
        return R.layout.jj_adapter;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position, Object o) {
        ImageView img = (ImageView) holder.getView(R.id.jjImg);
        TextView title = (TextView) holder.getView(R.id.jjTitle);
        TextView price = (TextView) holder.getView(R.id.jjPrice);
        IndexBean.DataBean.CategoryListBean.GoodsListBean list = (IndexBean.DataBean.CategoryListBean.GoodsListBean) this.list.get(position);
        Glide.with(context).load(list.getList_pic_url()).into(img);
        title.setText(list.getName());
        price.setText("￥"+(String) list.getRetail_price());
    }
}
