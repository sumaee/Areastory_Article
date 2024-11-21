package com.areastory.article.db.repository.support;

import com.areastory.article.dto.common.ArticleDto;
import com.areastory.article.dto.common.UserDto;
import com.areastory.article.dto.request.ArticleReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleSupportRepository {
    List<ArticleDto> findAll(ArticleReq articleReq, Pageable pageable);

    ArticleDto findById(Long userId, Long articleId);

    Page<UserDto> findAllLike(Long userId, Long articleId, Pageable pageable);

    List<ArticleDto> findMyLikeList(Long userId, Pageable pageable);


    List<ArticleDto> findAllFollowArticleList(Long userId, Pageable pageable);
}
