package com.zn.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zn.common.util.Result;
import com.zn.entity.UserInfo;
import com.zn.service.IUserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangning
 * @since 2021-12-05
 */
@RestController
@RequestMapping()
public class UserInfoController {

    @Resource
    private IUserInfoService userInfoService;

    @GetMapping("getUserPage")
    public Result getUsers(@RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "1") Integer currentPage,
                           @RequestParam(defaultValue = "") String search){


        QueryWrapper<UserInfo> wapper = new QueryWrapper<>();
        wapper.like("name",search);
        Page<UserInfo> userInfoPage = userInfoService.getBaseMapper()
                .selectPage(new Page<UserInfo>(currentPage, pageSize), wapper);

        return Result.ok().data("data",userInfoPage);
    }
}

