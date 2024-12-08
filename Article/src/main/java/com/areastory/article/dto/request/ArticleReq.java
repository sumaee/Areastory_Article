package com.areastory.article.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ArticleReq {
    private Long userId;
    private String dosi;
    private String sigungu;
    private String dongeupmyeon;

    @Builder
    public ArticleReq(Long userId, String dosi, String sigungu, String dongeupmyeon) {
        this.userId = userId;
        this.dosi = dosi;
        this.sigungu = sigungu;
        this.dongeupmyeon = dongeupmyeon;
    }

    @Override
    public String toString() {
        if (sigungu == null) {
            return dosi;
        } else if (dongeupmyeon == null) {
            return dosi + ":" + sigungu;
        }

        return dosi + ":" + sigungu + ":" + dongeupmyeon;
    }
}
