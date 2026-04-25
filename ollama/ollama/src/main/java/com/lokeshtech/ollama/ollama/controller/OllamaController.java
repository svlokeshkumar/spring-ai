package com.lokeshtech.ollama.ollama.controller;

import com.lokeshtech.ollama.ollama.service.OllamaServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ollama/api")
public class OllamaController {
    private final OllamaServices ollamaServices;

    public OllamaController(OllamaServices ollamaServices) {
        this.ollamaServices = ollamaServices;
    }

    @GetMapping("/chat")
    public String chat(String message){
        return ollamaServices.chatWithOpenAILLM(message);
    }
}
