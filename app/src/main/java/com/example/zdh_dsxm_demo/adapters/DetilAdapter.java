package com.example.zdh_dsxm_demo.adapters;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdh_dsxm_demo.R;
import com.example.zdh_dsxm_demo.base.BaseAdapter;
import com.example.zdh_dsxm_demo.bean.DetilListBean;

import java.util.List;

public class DetilAdapter extends BaseAdapter {
    public DetilAdapter(List list) {
        super(list);
    }

    @Override
    protected int getLayout() {
        return R.layout.detil_adapter;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position, Object o) {
        ImageView img = (ImageView) holder.getView(R.id.detilImg);
        TextView title = (TextView) holder.getView(R.id.detilTitle);
        TextView price = (TextView) holder.getView(R.id.detilPrice);
        DetilListBean.DataBeanX.GoodsListBean list = (DetilListBean.DataBeanX.GoodsListBean) this.list.get(position);
        Glide.with(context).load(list.getList_pic_url()).into(img);
        title.setText(list.getName());
        price.setText(list.getRetail_price());
    }
}
