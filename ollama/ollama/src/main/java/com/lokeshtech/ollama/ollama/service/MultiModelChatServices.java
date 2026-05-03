package com.lokeshtech.ollama.ollama.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class MultiModelChatServices {


    private final ChatClient openAIChatClient;
    private final ChatClient ollamaChatClient;

    public MultiModelChatServices(ChatClient openAIChatClient, ChatClient ollamaChatClient) {
        this.openAIChatClient = openAIChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }

    public String chatWithOpenAILLM(String message){
        return  openAIChatClient.prompt(message).call().content();
    }

    public String chatWithOllamaLLM(String message){
        return  ollamaChatClient.prompt(message).call().content();
    }
}
