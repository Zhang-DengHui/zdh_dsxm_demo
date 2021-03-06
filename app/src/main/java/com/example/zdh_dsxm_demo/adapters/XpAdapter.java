package com.example.zdh_dsxm_demo.adapters;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdh_dsxm_demo.R;
import com.example.zdh_dsxm_demo.base.BaseAdapter;
import com.example.zdh_dsxm_demo.bean.IndexBean;

import java.util.List;

public class XpAdapter extends BaseAdapter {
    public XpAdapter(List list) {
        super(list);
    }

    @Override
    protected int getLayout() {
        return R.layout.xp_adapter;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position, Object o) {
        ImageView img = (ImageView) holder.getView(R.id.xpImg);
        TextView title = (TextView) holder.getView(R.id.xpTitle);
        TextView price = (TextView) holder.getView(R.id.xpPrice);
        IndexBean.DataBean.NewGoodsListBean bean = (IndexBean.DataBean.NewGoodsListBean) list.get(position);
        Glide.with(context).load(bean.getList_pic_url()).into(img);
        title.setText(bean.getName());
        price.setText("￥"+bean.getRetail_price());
    }
}