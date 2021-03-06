/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.github.obullxl.jeesite.web.enums;

import org.apache.commons.lang.StringUtils;

import com.github.obullxl.lang.enums.EnumBase;

/**
 * 主题多媒体类型
 * 
 * @author obullxl@gmail.com
 * @version $Id: TopicMediaEnum.java, V1.0.1 2014年1月1日 下午4:56:18 $
 */
public enum TopicMediaEnum implements EnumBase {
    //
    TEXT(1, "T", "文本"),
    //
    IMAGE(2, "I", "图+文"),
    //
    ALBUM(3, "A", "相册"),
    //
    ;

    private final int    id;
    private final String code;
    private final String desp;

    private TopicMediaEnum(int id, String code, String desp) {
        this.id = id;
        this.code = code;
        this.desp = desp;
    }

    /**
     * 初始状态
     */
    public static final TopicMediaEnum findDefault() {
        return TEXT;
    }

    public static final TopicMediaEnum findDefault(String code) {
        for (TopicMediaEnum enm : values()) {
            if (StringUtils.equalsIgnoreCase(enm.code(), code)) {
                return enm;
            }
        }

        return TEXT;
    }

    /** 
     * @see com.github.obullxl.lang.enums.EnumBase#id()
     */
    public int id() {
        return this.id;
    }

    /** 
     * @see com.github.obullxl.lang.enums.EnumBase#code()
     */
    public String code() {
        return this.code;
    }

    /** 
     * @see com.github.obullxl.lang.enums.EnumBase#desp()
     */
    public String desp() {
        return this.desp;
    }

}
