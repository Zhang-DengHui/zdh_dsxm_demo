package com.example.zdh_dsxm_demo.presenter;

import com.example.zdh_dsxm_demo.base.BasePresenter;
import com.example.zdh_dsxm_demo.bean.IndexBean;
import com.example.zdh_dsxm_demo.component.CommonSubscriber;
import com.example.zdh_dsxm_demo.contract.HomeContract;
import com.example.zdh_dsxm_demo.model.HttpManager;
import com.example.zdh_dsxm_demo.utils.RxUtils;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{

    @Override
    public void getHomeData() {
        addSubscribe(HttpManager.getMyApi().getIndexData()
                .compose(RxUtils.<IndexBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IndexBean>(mView){

                    @Override
                    public void onNext(IndexBean result) {
                        mView.homeData(result);
                    }
                }));
    }
}
