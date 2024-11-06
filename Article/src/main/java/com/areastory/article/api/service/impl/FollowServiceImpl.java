package com.areastory.article.api.service.impl;

import com.areastory.article.api.service.FollowService;
import com.areastory.article.db.entity.Follow;
import com.areastory.article.db.entity.FollowPK;
import com.areastory.article.db.entity.UserInfo;
import com.areastory.article.db.repository.FollowRepository;
import com.areastory.article.db.repository.UserRepository;
import com.areastory.article.dto.common.FollowKafkaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Override
    public void addFollow(FollowKafkaDto followKafkaDto) {
        UserInfo followUser = userRepository.findById(followKafkaDto.getFollowUserId()).orElseThrow();
        UserInfo followingUser = userRepository.findById(followKafkaDto.getFollowingUserId()).orElseThrow();
        followRepository.save(new Follow(followUser, followingUser));
    }

    @Override
    public void deleteFollow(FollowKafkaDto followKafkaDto) {
        FollowPK followPK = new FollowPK(followKafkaDto.getFollowUserId(), followKafkaDto.getFollowingUserId());
        followRepository.deleteById(followPK);
    }
}
