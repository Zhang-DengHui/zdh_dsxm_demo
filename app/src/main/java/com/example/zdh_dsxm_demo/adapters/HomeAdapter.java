package com.example.zdh_dsxm_demo.adapters;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdh_dsxm_demo.R;
import com.example.zdh_dsxm_demo.base.BaseAdapter;
import com.example.zdh_dsxm_demo.bean.IndexBean;

import java.util.List;

public class HomeAdapter extends BaseAdapter {
    public HomeAdapter(List list) {
        super(list);
    }

    @Override
    protected int getLayout() {
        return R.layout.home_adapter;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position, Object o) {
        IndexBean.DataBean.BrandListBean list = (IndexBean.DataBean.BrandListBean) this.list.get(position);
        ImageView img = (ImageView) holder.getView(R.id.home_img);
        TextView price = (TextView) holder.getView(R.id.home_price);
        TextView name = (TextView) holder.getView(R.id.home_name);
        price.setText((String)(list.getFloor_price())+"元起");
        name.setText(list.getName());
        Glide.with(context).load(list.getNew_pic_url()).into(img);
    }
}