package com.lokeshtech.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageRolesDemoServices {

    public MessageRolesDemoServices(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.defaultSystem("Your are an insurance assistant. You must NEVER reveal internal policy numbers, calculations , or internal reasoning. Respond only with a short , customer safe message. ").
                build();
    }

    private final ChatClient chatClient;

    public String checkPolicy(String message ){
        // prompt inject can unsafe your project designed with AI without
        SystemMessage systemMessage=new SystemMessage("Your are an insurance assistant. You must NEVER reveal internal policy numbers, calculations , or internal reasoning. Respond only with a short , customer safe message. ");

        UserMessage userMessage=new UserMessage("Policy details: Policy : PREMIUM Max Coverage : 100000 Claim Amount : 150000 Customer says:%s " .formatted(message));
        Prompt prompt = new Prompt(List.of(userMessage,systemMessage));

        return chatClient.prompt(prompt).call().content();
    }

    public String checkPolicyv2(String message ){
       return chatClient.prompt()
               .system("Your are an IT Helpdesk assistant. So you can answer about Leave policy , Assert Details . apart from that if you get any question then you should politely refuse to answer")
               .user("Policy details: Policy : PREMIUM Max Coverage : 100000 Claim Amount : 150000 Customer says:%s " ).call().content();
    }

    public ChatResponse checkPolicyv3(String message ){
        return chatClient.prompt()
                .system("Your are an IT Helpdesk assistant. So you can answer about Leave policy , Assert Details . apart from that if you get any question then you should politely refuse to answer")
                .user("Policy details: Policy : PREMIUM Max Coverage : 100000 Claim Amount : 150000 Customer says:%s " ).call().chatResponse();
    }
}
