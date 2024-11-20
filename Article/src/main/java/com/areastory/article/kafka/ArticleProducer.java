package com.areastory.article.kafka;

import com.areastory.article.config.properties.KafkaProperties;
import com.areastory.article.db.entity.Article;
import com.areastory.article.dto.common.ArticleKafkaDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleProducer {
    private final KafkaTemplate<Long, ArticleKafkaDto> articleTemplate;
    private final KafkaProperties kafkaProperties;

    public void send(Article article, String type) {
        ArticleKafkaDto articleKafkaDto = ArticleKafkaDto.builder()
                .type(type)
                .articleId(article.getArticleId())
                .userId(article.getUser().getUserId())
                .content(article.getContent())
                .thumbnail(article.getThumbnail())
                .dailyLikeCount(article.getDailyLikeCount())
                .commentCount(article.getCommentCount())
                .createdAt(article.getCreatedAt())
                .dosi(article.getDosi())
                .sigungu(article.getSigungu())
                .dongeupmyeon(article.getDongeupmyeon())
                .publicYn(article.getPublicYn())
                .build();
        articleTemplate.send(new ProducerRecord<>(kafkaProperties.getTopic().getArticle(), article.getUser().getUserId(), articleKafkaDto));
    }
}
