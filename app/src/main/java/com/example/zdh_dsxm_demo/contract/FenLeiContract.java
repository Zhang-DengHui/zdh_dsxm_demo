package com.example.zdh_dsxm_demo.contract;

import com.example.zdh_dsxm_demo.base.IBaseView;
import com.example.zdh_dsxm_demo.base.IPresenter;
import com.example.zdh_dsxm_demo.bean.CatalogListBean;
import com.example.zdh_dsxm_demo.bean.CatalogTabBean;

public interface FenLeiContract {
    interface View extends IBaseView {
        void getsortData(CatalogTabBean catalogTabBean);
        void getFenLei(CatalogListBean catalogListBean);
    }

    interface Presenter extends IPresenter<View> {
        void getsort();
        void getFenLeiData(int id);
    }
}