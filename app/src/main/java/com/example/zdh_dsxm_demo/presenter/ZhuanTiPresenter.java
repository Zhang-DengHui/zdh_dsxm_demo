package com.example.zdh_dsxm_demo.presenter;

import com.example.zdh_dsxm_demo.base.BasePresenter;
import com.example.zdh_dsxm_demo.bean.IndexBean;
import com.example.zdh_dsxm_demo.component.CommonSubscriber;
import com.example.zdh_dsxm_demo.contract.ZhuanTiContract;
import com.example.zdh_dsxm_demo.model.HttpManager;
import com.example.zdh_dsxm_demo.utils.RxUtils;

public class ZhuanTiPresenter extends BasePresenter<ZhuanTiContract.View> implements ZhuanTiContract.Presenter {
    @Override
    public void getZhuanTiData() {
        addSubscribe(HttpManager.getMyApi().getIndexData()
                .compose(RxUtils.<IndexBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IndexBean>(mView){

                    @Override
                    public void onNext(IndexBean result) {
                        mView.getZhuanTi(result);
                    }
                }));
    }
}
