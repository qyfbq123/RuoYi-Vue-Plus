package com.aibang.crm.vo;

import lombok.Data;

@Data
public class CaptchaVo {

    private Boolean captchaEnabled = true;

    private String uuid;

    private String img;
}
