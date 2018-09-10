package com.jd.alpha.samples.standard.web;

import com.alibaba.fastjson.JSON;
import com.jd.alpha.samples.standard.handler.SkillHandler;
import com.jd.alpha.skill.sdk.entity.request.SkillData;
import com.jd.alpha.skill.sdk.entity.response.SkillResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Index 接口
 *
 * @author cdyangyang18
 */
@Slf4j
@RestController
public class ApiController {

    @Autowired
    private SkillHandler handler;

    @PostMapping(value = "/", produces = {"application/json;charset=UTF-8"})
    public SkillResponse index(@RequestBody String requestBody) {
        log.info("Skill Request Body: {}", requestBody);
        SkillData data = JSON.parseObject(requestBody, SkillData.class);
        SkillResponse response = handler.handle(data);
        log.info("Skill Response: {}", JSON.toJSONString(response));
        return response;
    }

}
