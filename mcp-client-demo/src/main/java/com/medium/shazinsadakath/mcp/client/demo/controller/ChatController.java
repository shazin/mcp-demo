package com.medium.shazinsadakath.mcp.client.demo.controller;

import io.modelcontextprotocol.client.McpSyncClient;
import org.slf4j.Logger;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ChatController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ChatController.class);

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder, List<McpSyncClient> mcpSyncClients) {
        this.chatClient = chatClientBuilder
                .defaultToolCallbacks(new SyncMcpToolCallbackProvider(mcpSyncClients))
                .build();
    }

    @GetMapping("")
    public String home() {
        return "index";
    }

    @PostMapping("/generate")
    public List<ModelAndView> generate(@RequestParam String message) {
        log.info("User Message: {}", message);
        String response = chatClient.prompt()
                .user(message)
                .call()
                .content();

        return List.of(
                new ModelAndView("response :: responseFragment",
                        Map.of("response", response)),
                new ModelAndView("todays-message-list :: messageFragment",
                        Map.of("message", message)),
                new ModelAndView("chat-form :: formFragment")
        );
    }
}
