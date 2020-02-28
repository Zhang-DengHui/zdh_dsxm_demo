package com.example.zdh_dsxm_demo.presenter;

import com.example.zdh_dsxm_demo.base.BasePresenter;
import com.example.zdh_dsxm_demo.bean.CatalogListBean;
import com.example.zdh_dsxm_demo.bean.CatalogTabBean;
import com.example.zdh_dsxm_demo.component.CommonSubscriber;
import com.example.zdh_dsxm_demo.contract.FenLeiContract;
import com.example.zdh_dsxm_demo.model.HttpManager;
import com.example.zdh_dsxm_demo.utils.RxUtils;

public class FenLeiPresenter extends BasePresenter<FenLeiContract.View> implements FenLeiContract.Presenter {

    @Override
    public void getsort() {
        addSubscribe(HttpManager.getMyApi().getCatalogTabData()
                .compose(RxUtils.<CatalogTabBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CatalogTabBean>(mView){

                    @Override
                    public void onNext(CatalogTabBean catalogTabBean) {
                        if(catalogTabBean.getErrno() == 0){
                            mView.getsortData(catalogTabBean);
                        }
                    }
                }));
    }

    @Override
    public void getFenLeiData(int id) {
        addSubscribe(HttpManager.getMyApi().getCatalogList(id)
                .compose(RxUtils.<CatalogListBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CatalogListBean>(mView){

                    @Override
                    public void onNext(CatalogListBean catalogListBean) {
                        if(catalogListBean.getErrno() == 0){
                            mView.getFenLei(catalogListBean);
                        }
                    }
                }));
    }
}