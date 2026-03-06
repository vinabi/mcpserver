package com.unicorn.store.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.List;
import com.unicorn.store.model.Unicorn;

@Component
public class UnicornTools {
    private final UnicornService unicornService;

    public UnicornTools(UnicornService unicornService) {
        this.unicornService = unicornService;
    }

    @Bean
    public ToolCallbackProvider unicornToolsProvider(UnicornTools unicornTools) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(unicornTools)
                .build();
    }

    @Tool(description = "Create a new unicorn in the unicorn store.")
    public Unicorn createUnicorn(Unicorn unicorn) {
        return unicornService.createUnicorn(unicorn);
    }

    @Tool(description = "Get a list of all unicorns in the unicorn store")
    public List<Unicorn> getAllUnicorns(String... parameters) {
        return unicornService.getAllUnicorns();
    }
}
