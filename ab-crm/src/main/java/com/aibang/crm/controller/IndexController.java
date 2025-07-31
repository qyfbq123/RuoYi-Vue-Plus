package com.aibang.crm.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.SpringUtils;
import org.dromara.common.core.utils.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SaIgnore
@RequiredArgsConstructor
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return StringUtils.format("欢迎使用{}管理系统。", SpringUtils.getApplicationName());
    }
}
