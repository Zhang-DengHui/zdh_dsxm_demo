package com.example.zdh_dsxm_demo.model;

import com.example.zdh_dsxm_demo.bean.CatalogListBean;
import com.example.zdh_dsxm_demo.bean.CatalogTabBean;
import com.example.zdh_dsxm_demo.bean.DetilListBean;
import com.example.zdh_dsxm_demo.bean.DetilTabBean;
import com.example.zdh_dsxm_demo.bean.IndexBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApi {


    //主页数据接口
    @GET("index")
    Flowable<IndexBean> getIndexData();

    //获取分类导航数据接口
    @GET("catalog/index")
    Flowable<CatalogTabBean> getCatalogTabData();

    //获取列表选中的数据
    @GET("catalog/current")
    Flowable<CatalogListBean> getCatalogList(@Query("id") int id);

    //获取分类详情页Tab数据
    @GET("goods/category")
    Flowable<DetilTabBean> getDetilTab(@Query("id") int id);

    //获取分类详情页列表数据
    @GET("goods/list")
    Flowable<DetilListBean> getDetilList(@Query("categoryId") int id, @Query("page") int page, @Query("size") int size);

}
