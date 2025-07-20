package com.example.Healthcare.service.implementation;

import com.example.Healthcare.service.OpenAIService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenAIServiceImpl implements OpenAIService {

    private static final String OPENAI_API_KEY = "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"; 
    private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    @Override
    public String processQuery(String userQuery) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(OPENAI_API_KEY);

            Map<String, Object> message = new HashMap<>();
            message.put("role", "user");
            message.put("content", userQuery);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "gpt-3.5-turbo");
            requestBody.put("messages", List.of(message));

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(OPENAI_URL, entity, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());

            return root.path("choices").get(0).path("message").path("content").asText();

        } catch (Exception e) {
            return "Error communicating with OpenAI: " + e.getMessage();
        }
    }
}
