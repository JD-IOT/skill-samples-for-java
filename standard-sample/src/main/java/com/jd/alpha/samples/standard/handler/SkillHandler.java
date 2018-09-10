package com.jd.alpha.samples.standard.handler;

import com.jd.alpha.skill.sdk.RequestHandler;
import com.jd.alpha.skill.sdk.entity.request.SkillData;
import com.jd.alpha.skill.sdk.entity.response.SkillResponse;
import com.jd.alpha.skill.sdk.entity.response.SkillResponseDetails;
import com.jd.alpha.skill.sdk.entity.response.SkillResponseOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Skill 核心逻辑处理
 *
 * @author cdyangyang18
 */
@Slf4j
@Component
public class SkillHandler extends RequestHandler {

    private static final String WELCOME_MSG = "欢迎使用技能服务";
    private static final String HELP_MSG = "欢迎使用技能服务";
    private static final String CANCEL_MSG = "期待您再次使用";

    @Override
    public SkillResponse onLaunchRequest(SkillData skillData) {
        return SkillResponse.builder()
                .shouldEndSession(false)
                .response(SkillResponseDetails.builder()
                        .output(SkillResponseOutput.builder()
                                .text(WELCOME_MSG)
                                .build())
                        .build())
                .build();
    }

    @Override
    public SkillResponse onIntentRequest(SkillData skillData) {
        try {
            String intentName = skillData.getRequest().getIntent().getName();

            switch (intentName) {
                case "hello":
                    return SkillResponse.builder()
                            .shouldEndSession(true)
                            .response(SkillResponseDetails.builder()
                                    .output(SkillResponseOutput.builder()
                                            .text("Hello World")
                                            .build())
                                    .build())
                            .build();
                default:
                    return SkillResponse.builder()
                            .shouldEndSession(false)
                            .response(SkillResponseDetails.builder()
                                    .output(SkillResponseOutput.builder()
                                            .text("Unknown Intent")
                                            .build())
                                    .build())
                            .build();
            }
        } catch (Exception e) {
            return onCancelIntent(skillData);
        }
    }

    @Override
    public SkillResponse onCancelIntent(SkillData skillData) {
        return SkillResponse.builder()
                .shouldEndSession(false)
                .response(SkillResponseDetails.builder()
                        .output(SkillResponseOutput.builder()
                                .text(CANCEL_MSG)
                                .build())
                        .build())
                .build();
    }

    @Override
    public SkillResponse onHelpIntent(SkillData skillData) {
        return SkillResponse.builder()
                .shouldEndSession(false)
                .response(SkillResponseDetails.builder()
                        .output(SkillResponseOutput.builder()
                                .text(HELP_MSG)
                                .build())
                        .build())
                .build();
    }

    @Override
    public SkillResponse defaultResponse(SkillData skillData) {
        return onHelpIntent(skillData);
    }

}
