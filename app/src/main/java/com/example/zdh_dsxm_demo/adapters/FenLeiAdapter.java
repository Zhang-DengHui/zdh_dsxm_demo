package com.example.zdh_dsxm_demo.adapters;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdh_dsxm_demo.R;
import com.example.zdh_dsxm_demo.base.BaseAdapter;
import com.example.zdh_dsxm_demo.bean.CatalogItem;

import java.util.List;

public class FenLeiAdapter extends BaseAdapter {
    public FenLeiAdapter(List list) {
        super(list);
    }

    @Override
    protected int getLayout() {
        return R.layout.fenlei_adapter;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position, Object o) {
        ImageView img = (ImageView) holder.getView(R.id.fenleiImg);
        TextView title = (TextView) holder.getView(R.id.fenleiTitle);
        CatalogItem list = (CatalogItem) this.list.get(position);
        Glide.with(context).load(list.img).into(img);
        title.setText(list.name);
    }
}
