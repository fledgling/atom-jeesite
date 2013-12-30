/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.github.obullxl.jeesite.web.xhelper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.obullxl.jeesite.dal.dao.RightDAO;
import com.github.obullxl.jeesite.dal.dao.UserRgtDAO;
import com.github.obullxl.jeesite.dal.dto.RightDTO;
import com.github.obullxl.jeesite.web.enums.UserRightEnum;
import com.github.obullxl.lang.user.UserContextUtils;
import com.github.obullxl.lang.xhelper.AbstractXHelper;

/**
 * 权限X工具
 * 
 * @author obullxl@gmail.com
 * @version $Id: RgtXHelper.java, V1.0.1 2013年12月16日 上午9:30:18 $
 */
@Component("rgtXHelper")
public class RgtXHelper extends AbstractXHelper {

    /** 权限DAO */
    @Autowired
    private RightDAO   rightDAO;

    /** 用户权限DAO */
    @Autowired
    private UserRgtDAO userRgtDAO;

    /**
     * 查询权限
     */
    public RightDTO find(long id) {
        return this.rightDAO.find(id);
    }

    /**
     * 查询权限
     */
    public RightDTO find(String code) {
        return this.rightDAO.findCode(code);
    }

    /**
     * 获取所有权限
     */
    public List<RightDTO> findAll() {
        return this.rightDAO.findAll();
    }

    /**
     * 判断权限码是否在枚举中
     */
    public boolean isRgtEnum(String code) {
        return (UserRightEnum.findByCode(code) != null);
    }

    /**
     * 新建Set对象
     */
    public static Set<String> newSet(String... args) {
        if (args == null || args.length < 1) {
            return new HashSet<String>();
        }

        return new HashSet<String>(Arrays.asList(args));
    }

    /**
     * 新建Set对象
     */
    public static Set<String> newSet(UserRightEnum... rgts) {
        Set<String> rtns = new HashSet<String>();
        if (rgts != null && rgts.length > 0) {
            for (UserRightEnum rgt : rgts) {
                rtns.add(rgt.code());
            }
        }

        return rtns;
    }

    /**
     * 用户管理权限
     */
    public static boolean isUserManage() {
        return UserContextUtils.isRight(newSet(UserRightEnum.RGT_USER_MANAGE, UserRightEnum.RGT_USER_CREATE, UserRightEnum.RGT_USER_UPDATE, UserRightEnum.RGT_USER_DELETE));
    }

    /**
     * 获取用户所有权限
     */
    public List<RightDTO> findUserRgts(String uname) {
        return this.rightDAO.findUserRgts(uname);
    }

    /**
     * 判断是否为集合中权限
     */
    public boolean isRgtSet(String rgtCode, List<RightDTO> rights) {
        for (RightDTO right : rights) {
            if (StringUtils.equals(rgtCode, right.getCode())) {
                return true;
            }
        }

        return false;
    }

}
