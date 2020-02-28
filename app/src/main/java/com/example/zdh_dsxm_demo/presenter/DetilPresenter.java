package com.example.zdh_dsxm_demo.presenter;

import com.example.zdh_dsxm_demo.base.BasePresenter;
import com.example.zdh_dsxm_demo.bean.DetilListBean;
import com.example.zdh_dsxm_demo.bean.DetilTabBean;
import com.example.zdh_dsxm_demo.component.CommonSubscriber;
import com.example.zdh_dsxm_demo.contract.SortDetilContract;
import com.example.zdh_dsxm_demo.model.HttpManager;
import com.example.zdh_dsxm_demo.utils.RxUtils;

public class DetilPresenter extends BasePresenter<SortDetilContract.View> implements SortDetilContract.Presenter {
    @Override
    public void getDetilTab(int id) {
        addSubscribe(HttpManager.getMyApi().getDetilTab(id)
                .compose(RxUtils.<DetilTabBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<DetilTabBean>(mView){
                    @Override
                    public void onNext(DetilTabBean detilTabBean) {
                        mView.getDetilTabReturn(detilTabBean);
                    }
                }));
    }

    @Override
    public void getDetilList(int categoryId, int page, int size) {
        addSubscribe(HttpManager.getMyApi().getDetilList(categoryId,page,size)
                .compose(RxUtils.<DetilListBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<DetilListBean>(mView){
                    @Override
                    public void onNext(DetilListBean detilListBean) {
                        mView.getDetilReturn(detilListBean);
                    }
                }));
    }
}