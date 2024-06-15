package com.ceos_19.vote.common.enumSet;

import lombok.Getter;

@Getter
public enum ErrorType {
    ALREADY_EXIST(400,"해당 아이디는 사용할 수 없습니다"),
    NOT_VALID_TOKEN(400, "토큰이 유효하지 않습니다."),
    DUPLICATED_USERNAME(400, "중복된 username 입니다."),
    NOT_MATCHING_INFO(400, "회원을 찾을 수 없습니다."),
    NOT_MATCHING_PASSWORD(400, "비밀번호가 일치하지 않습니다."),
    NOT_FOUND_USER(400, "사용자가 존재하지 않습니다."),
    NOT_FOUND(400,"해당 데이터가 존재하지 않습니다" ),
    LOGIN_FAIL(400, "로그인에 실패하였습니다. 아이디 OR 비밀번호를 확인해주세요"),
    NOT_FOUND_TOPIC(400, "해당 Topic이 존재하지 않습니다."),
    NOT_FOUND_VOTINGOPTION(400, "Voting Option이 존재하지 않습니다."),
    NOT_FOUNT_VOTE(400,"아직 해당 주제에 투표한 사람이 없습니다."),
    INSUFFICIENT_VOTINGOPTION(400, "최종 결과를 내기에는 투표자가 아직 부족합니다")
    ;


    private int code;
    private String message;

    //  Error Type 생성자 생성
    ErrorType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
