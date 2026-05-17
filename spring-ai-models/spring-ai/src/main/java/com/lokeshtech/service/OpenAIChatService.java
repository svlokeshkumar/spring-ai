package com.lokeshtech.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OpenAIChatService {

    public OpenAIChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    private final ChatClient chatClient;

    public String chatWithOpenAILLM(String message){
        return  chatClient.prompt(message).call().content();
    }
}
