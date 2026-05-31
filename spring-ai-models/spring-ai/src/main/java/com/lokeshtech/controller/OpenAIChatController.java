package com.lokeshtech.controller;

import com.lokeshtech.service.MessageRolesDemoServices;
import com.lokeshtech.service.OpenAIChatService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("openapi/api")
public class OpenAIChatController {

    private final OpenAIChatService openAIChatService;
    private final MessageRolesDemoServices messageRolesDemoServices;

    public OpenAIChatController(OpenAIChatService openAIChatService, MessageRolesDemoServices messageRolesDemoServices) {
        this.openAIChatService = openAIChatService;
        this.messageRolesDemoServices = messageRolesDemoServices;
    }

    @GetMapping("/chat")
    public String chat(String message){
        return openAIChatService.chatWithOpenAILLM(message);
    }

    @GetMapping("/checkPolicy")
    public String checkInsurancePolicy(@RequestParam String message){
        return messageRolesDemoServices.checkPolicyv2(message);
    }


    @GetMapping("/checkPolicyv3")
    public ChatResponse checkInsurancePolicyV3(@RequestParam String message){
        return messageRolesDemoServices.checkPolicyv3(message);
    }

    @GetMapping("/guide")
    public String guideUser(@RequestParam String topic,String level,int points){
        return messageRolesDemoServices.guideme(topic, level, points);
    }
}
