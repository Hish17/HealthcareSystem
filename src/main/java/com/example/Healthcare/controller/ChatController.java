package com.example.Healthcare.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Healthcare.service.OpenAIService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
  @Autowired
    private OpenAIService openAIService;

    @PostMapping
    public ResponseEntity<String> chat(@RequestBody Map<String, String> body) {
        String query = body.get("query");
        String response = openAIService.processQuery(query);
        return ResponseEntity.ok(response);
    }  
}
