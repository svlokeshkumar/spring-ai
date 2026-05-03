package com.lokeshtech.ollama.ollama.controller;

import com.lokeshtech.ollama.ollama.service.MultiModelChatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("multimodel/api")
public class MultiModelChatController {

    @Autowired
    private MultiModelChatServices multiModelChatServices;

    @GetMapping("/chat/openai")
    public String openAIChat(String message){
        return multiModelChatServices.chatWithOpenAILLM(message);
    }

    @GetMapping("/chat/ollama")
    public String ollamaChat(String message){
        return multiModelChatServices.chatWithOllamaLLM(message);
    }
}

