package com.zerobase.Store_Table_Reservation.exception;

import com.zerobase.Store_Table_Reservation.exception.customException.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 이미 사용중인 ID 에 대한 예외 처리
     */
    @ExceptionHandler(IdAlreadyUsedException.class)
    public ResponseEntity<ErrorResponse> handleIdAlreadyUsedException(IdAlreadyUsedException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 회원가입 중 ID 값이 null 일때 예외 처리
     */
    @ExceptionHandler(IdNotNullException.class)
    public ResponseEntity<ErrorResponse> handleIdNotNullException(IdNotNullException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 회원정보를 찾지 못했을때 예외 처리
     */
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMemberNotFoundException(MemberNotFoundException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 회원의 ID 와 비밀번호가 일치하지 않을때 예외 처리
     */
    @ExceptionHandler(MemberPasswordNotMatchException.class)
    public ResponseEntity<ErrorResponse> handleMemberPasswordNotMatchException(MemberPasswordNotMatchException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * ID 값으로 조회한 가게 정보가 존재하지 않을때 예외 처리
     */
    @ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStoreNotFoundException(StoreNotFoundException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 등록된 가게의 점장과 요청한 사용자가 다를경우 예외 처리
     */
    @ExceptionHandler(StoreMemberNotMatchException.class)
    public ResponseEntity<ErrorResponse> handleStoreMemberNotMatchException(StoreMemberNotMatchException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 사용자가 선택한 시간에 이미 예약이 차있을경우 예외처리
     */
    @ExceptionHandler(AlreadyReservedException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyReservedException(AlreadyReservedException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 예약 내역이 존재하지 않을 경우 예외처리
     */
    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleReservationNotFoundException(ReservationNotFoundException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 예약 시간과 사용자 도착시간이 유효하지않을때 (도착시간이 늦었을때) 예외처리
     */
    @ExceptionHandler(ReservationTimeInvalidException.class)
    public ResponseEntity<ErrorResponse> handleReservationTimeInvalidException(ReservationTimeInvalidException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 예약한 유저와 리뷰를 쓰려는 유저가 같지 않을때 예외처리
     */
    @ExceptionHandler(ReservationMemberNotMatchException.class)
    public ResponseEntity<ErrorResponse> handleReservationMemberNotMatchException(ReservationMemberNotMatchException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 유저가 방문하지 않은 (노쇼) 예약건에 리뷰를 작성하려할때 예외처리
     */
    @ExceptionHandler(ReservationNoShowException.class)
    public ResponseEntity<ErrorResponse> handleReservationNoShowException(ReservationNoShowException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 리뷰 수정,삭제 시에 리뷰내용이 존재하지 않을때 예외처리
     */
    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleReviewNotFoundException(ReviewNotFoundException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 리뷰 작성자와 수정하는 유저가 다를시 예외처리
     */
    @ExceptionHandler(ReviewMemberNotMatchException.class)
    public ResponseEntity<ErrorResponse> handleReviewMemberNotMatchException(ReviewMemberNotMatchException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 해당 가게의 점장, 리뷰작성자 외 사람이 리뷰를 삭제하려할때 예외처리
     */
    @ExceptionHandler(ReviewDeleteRejectedException.class)
    public ResponseEntity<ErrorResponse> handleReviewDeleteRejectedException(ReviewDeleteRejectedException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
