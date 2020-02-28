package com.example.zdh_dsxm_demo.contract;

import com.example.zdh_dsxm_demo.base.IBaseView;
import com.example.zdh_dsxm_demo.base.IPresenter;
import com.example.zdh_dsxm_demo.bean.IndexBean;

public interface HomeContract {
    interface View extends IBaseView {
        void homeData(IndexBean bean);
    }
    interface Presenter extends IPresenter<View> {
        void getHomeData();
    }
}
