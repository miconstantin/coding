package com.mhp.coding.challenges.dependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class AsynchronousSpringEventsConfig {

    @Bean(name = "applicationEventMultiCaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMultiCaster = new SimpleApplicationEventMulticaster();
        eventMultiCaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMultiCaster;
    }
}
