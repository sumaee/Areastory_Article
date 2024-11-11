package com.areastory.article.dto.response;

import com.areastory.article.dto.common.ArticleDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ArticleResp {
    // THINK : 게시글이 스크롤 형식이니까 페이지 정보를 줄 필요 없지 않을까...

    // THINK : 한페이지 리미트 사이즈를 반환할 필요? => 필요 없을 거 같음
    private Integer pageSize;
    // TODO : 총 페이지 수 -> 전체 게시글 수 / 한페이지당 게시글 수 (홀수면 +1, 짝수면 그대로) => 필요 없을 거 같음
    private Integer totalPageNumber;
    // FIXME : 게시글 전체 개수를 반환할 필요가 있을까?  => 필요없음
    private Long totalCount;
    // TODO : 현재 페이지 번호 -> 요청값 그대로 사용
    private Integer pageNumber;
    // TODO : 다음 페이지 있는지 없는지 null값으로 프론트에서 대체 가능
    private Boolean nextPage;
    private Boolean previousPage;

    private List<ArticleDto> articles;

}
