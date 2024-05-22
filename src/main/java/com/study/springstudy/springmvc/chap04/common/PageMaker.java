package com.study.springstudy.springmvc.chap04.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

// 페이지 화면 렌더링에 필요한 정보들을 계산
@Getter @ToString
@EqualsAndHashCode
public class PageMaker {

    // 한 화면에 페이지를 몇개씩 배치할 것인가?
    private static final int PAGE_COUNT = 10;

    // 현재 페이지 정보
    private Page pageInfo;

    // 이전, 다음버튼 활성화 여부
    private boolean prev, next;

    // 총 게시물 수
    private int totalCount;

    public PageMaker(Page page, int totalCount) {
        this.pageInfo = page;
        this.totalCount = totalCount;
        makePageInfo();
    }

    // 페이지 시작번호와 끝번호
    private int begin, end;

    // 페이지 생성에 필요한 데이터를 만드는 알고리즘
    private void makePageInfo() {

        // 1. end 계산
        // 공식 : (올림 (현재 사용자가 위치한 페이지넘버 / 한 화면에 보여줄 페이지 수)) * 한 화면에 보여줄 페이지 수
        this.end = (int) (Math.ceil((double) pageInfo.getPageNo() / PAGE_COUNT) * PAGE_COUNT);

        // 2. begin 계산
        this.begin = this.end - PAGE_COUNT + 1;

        // 3. 마지막 페이지 구간에서 end값 보정
        // 마지막 페이지 번호 구하는 공식
        // 올림(총 게시물 수 / 한 페이지당 배치할 게시물 수)
        int finalPage = (int) Math.ceil((double) totalCount / pageInfo.getAmount());

        // 마지막 구간에서 end값을 finalPage으로 보정
        if (finalPage < this.end) {
            this.end = finalPage;
        }

        // 4. 이전버튼 활성화 여부
        this.prev = begin != 1;

        // 5. 다음버튼 활성화 여부
        this.next = this.end < finalPage;

    }



}
