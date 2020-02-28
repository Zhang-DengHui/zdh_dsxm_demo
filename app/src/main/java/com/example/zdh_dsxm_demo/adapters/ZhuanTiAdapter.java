package com.example.zdh_dsxm_demo.adapters;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdh_dsxm_demo.R;
import com.example.zdh_dsxm_demo.base.BaseAdapter;
import com.example.zdh_dsxm_demo.bean.IndexBean;

import java.util.List;

public class ZhuanTiAdapter extends BaseAdapter {
    public ZhuanTiAdapter(List list) {
        super(list);
    }

    @Override
    protected int getLayout() {
        return R.layout.zhuanti_adapter;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position, Object o) {
        ImageView img = (ImageView) holder.getView(R.id.zhuantiImg);
        TextView subtitle = (TextView) holder.getView(R.id.zhuantiSubtitle);
        TextView title = (TextView) holder.getView(R.id.zhuantiTitle);
        TextView price = (TextView) holder.getView(R.id.zhuantiPrice);
        price.setText("0元起");
        IndexBean.DataBean.TopicListBean zhuantiList = (IndexBean.DataBean.TopicListBean) list.get(position);
        subtitle.setText(zhuantiList.getSubtitle());
        title.setText(zhuantiList.getTitle());
        Glide.with(context).load(zhuantiList.getItem_pic_url()).into(img);
    }
}
