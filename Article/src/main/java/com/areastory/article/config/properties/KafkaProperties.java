package com.areastory.article.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {
    private String kafkaUrl;
    private Topic topic;
    private Group group;
    private Type type;
    private Command command;

    @Getter
    @Setter
    public static class Topic {
        private String article;
        private String notification;
        private String user;
        private String follow;
    }

    @Getter
    @Setter
    public static class Group{
        private String user;
        private String follow;
    }
    @Getter
    @Setter
    public static class Type{
        private String comment;
        private String articleLike;
        private String commentLike;
        private String userReply;
    }
    @Getter
    @Setter
    public static class Command {
        private String delete;
        private String update;
        private String insert;
    }

}