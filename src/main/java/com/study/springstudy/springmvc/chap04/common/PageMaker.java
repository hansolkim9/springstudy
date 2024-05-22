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

    public PageMaker(Page page) {
        this.pageInfo = page;
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

    }



}
