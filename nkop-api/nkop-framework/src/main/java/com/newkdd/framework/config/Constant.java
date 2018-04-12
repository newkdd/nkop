package com.newkdd.framework.config;

/**
 * Created by Mike on 2018/4/12.
 */
public final class Constant {

    public static interface DB{

        public static Long DEFAULT_VERSION = 1l;

        public static  interface DELETED{
            public final Integer YES = 1;
            public final Integer NO = 0;
        }

        public static interface ENABLED{
            public final Integer YES = 1;
            public final Integer NO = 0;
        }
    }
}
