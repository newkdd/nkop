package com.newkdd.admin.model.entity;

import com.newkdd.framework.basic.BasicDO;

/**
 * Created by sang on 2017/12/30.
 */
public class ResourceMeta extends BasicDO{

    private boolean keepAlive;
    private boolean requireAuth;

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public boolean isRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
