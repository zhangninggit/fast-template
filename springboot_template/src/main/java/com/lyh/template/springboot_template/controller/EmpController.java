package com.lyh.template.springboot_template.controller;

import com.lyh.template.springboot_template.common.util.Result;
import com.lyh.template.springboot_template.entity.Emp;
import com.lyh.template.springboot_template.common.exception.GlobalException;
import com.lyh.template.springboot_template.service.EmpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Emp)表控制层
 *
 * @author makejava
 * @since 2020-04-28 19:56:50
 */
@RestController
@RequestMapping("emp")
public class EmpController {
    /**
     * 服务对象
     */
    @Resource
    private EmpService empService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Result selectOne(Integer id) {
        Emp emp = this.empService.queryById(id);
        if (id == null) {
            throw new NullPointerException();
        }
        if (id == -1) {
            throw new GlobalException("参数异常", 400);
        }
        if (emp == null) {
            throw new GlobalException("未查询到结果，请确认输入是否正确");
        }
        return Result.ok().data("items", emp).message("查询成功");
    }

}