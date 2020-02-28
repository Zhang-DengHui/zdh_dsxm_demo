package com.example.zdh_dsxm_demo.dao;

import com.example.zdh_dsxm_demo.db.CollectVo;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

public class DaoSession extends AbstractDaoSession {

    private final DaoConfig collectVoDaoConfig;

    private final CollectVoDao collectVoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        collectVoDaoConfig = daoConfigMap.get(CollectVoDao.class).clone();
        collectVoDaoConfig.initIdentityScope(type);

        collectVoDao = new CollectVoDao(collectVoDaoConfig, this);

        registerDao(CollectVo.class, collectVoDao);
    }

    public void clear() {
        collectVoDaoConfig.clearIdentityScope();
    }

    public CollectVoDao getCollectVoDao() {
        return collectVoDao;
    }

}
