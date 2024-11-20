package com.areastory.article.kafka;

import com.areastory.article.api.service.FollowService;
import com.areastory.article.api.service.UserService;
import com.areastory.article.config.properties.KafkaProperties;
import com.areastory.article.dto.common.FollowKafkaDto;
import com.areastory.article.dto.common.UserKafkaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserListener {
    private final UserService userService;
    private final UserReplyProducer userReplyProducer;
    private final FollowService followService;
    private final KafkaProperties kafkaProperties;

    @KafkaListener(id = "${kafka.group.user}", topics = "${kafka.topic.user}", containerFactory = "userContainerFactory")
    public void userListen(UserKafkaDto userKafkaDto) {
        String type = userKafkaDto.getType();
        if (type.equals(kafkaProperties.getCommand().getInsert())) {
            userService.addUser(userKafkaDto);
            userReplyProducer.send(userKafkaDto.getUserId());
        }else if(type.equals(kafkaProperties.getCommand().getUpdate())){
            userService.updateUser(userKafkaDto);
        }else if(type.equals(kafkaProperties.getCommand().getDelete())){
            userService.deleteUser(userKafkaDto);
        }
    }

    @KafkaListener(id = "${kafka.group.follow}", topics = "${kafka.topic.follow}", containerFactory = "followContainerFactory")
    public void followListen(FollowKafkaDto followKafkaDto) {
        String type = followKafkaDto.getType();
        if(type.equals(kafkaProperties.getCommand().getInsert())){
            followService.addFollow(followKafkaDto);
        }else if(type.equals(kafkaProperties.getCommand().getDelete())){
            followService.deleteFollow(followKafkaDto);
        }
    }
}
