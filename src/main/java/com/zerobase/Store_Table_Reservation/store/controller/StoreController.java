package com.zerobase.Store_Table_Reservation.store.controller;

import com.zerobase.Store_Table_Reservation.reservation.dto.response.ReservationSuccessResponse;
import com.zerobase.Store_Table_Reservation.reservation.dto.response.ReservationVisitedResponse;
import com.zerobase.Store_Table_Reservation.store.dto.request.*;
import com.zerobase.Store_Table_Reservation.store.dto.response.StoreDetailDto;
import com.zerobase.Store_Table_Reservation.store.entity.Store;
import com.zerobase.Store_Table_Reservation.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    /**
     * 가게 업로드 하는 메서드. @PreAuthorize 어노테이션으로 인가작업 진행
     */
    @PostMapping("/upload")
    @PreAuthorize("hasRole('ROLE_PARTNER')") // 파트너 유저만 이 메서드를 이용가능하다.
    public ResponseEntity<String> uploadStore(@RequestBody StoreUploadDto dto) {
        // SecurityContextHolder 에서 인증된 사용자의 ID 를 가져온다.
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Store store = storeService.uploadStore(dto, username);
        return ResponseEntity.ok().body(store.getName() + "가 정상적으로 등록되었습니다.");
    }

    /**
     * 가게 수정 하는 메서드. @PreAuthorize 어노테이션으로 인가작업 진행
     */
    @PutMapping("/modify")
    @PreAuthorize("hasRole('ROLE_PARTNER')") // 파트너 유저만 이 메서드를 이용가능하다.
    public ResponseEntity<String> modifyStore(@RequestBody StoreModifyDto dto) {
        // SecurityContextHolder 에서 인증된 사용자의 ID 를 가져온다.
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Store store = storeService.modifyStore(dto, username);
        return ResponseEntity.ok().body(store.getName() + "가 정상적으로 수정되었습니다.");
    }

    /**
     * 가게 삭제하는 메서드. @PreAuthorize 어노테이션으로 인가작업 진행
     */
    @DeleteMapping("/remove")
    @PreAuthorize("hasRole('ROLE_PARTNER')") // 파트너 유저만 이 메서드를 이용가능하다.
    public ResponseEntity<String> modifyStore(@RequestParam long storeCode) {
        // SecurityContextHolder 에서 인증된 사용자의 ID 를 가져온다.
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        storeService.deleteStore(storeCode, username);
        return ResponseEntity.ok().body("가게 정보가 정상적으로 삭제되었습니다.");
    }

    /**
     * 가게의 상세정보를 조회하는 메서드
     */
    @GetMapping("/detail")
    public ResponseEntity<StoreDetailDto> getStoreDetail(@RequestBody StoreDetailReqeustDto dto) {
        StoreDetailDto storeDetail = storeService.getStoreDetail(dto);
        return ResponseEntity.ok().body(storeDetail);
    }

    /**
     * 가게 예약하는 메서드. 로그인 필수
     */
    @PostMapping("/reservation")
    // 로그인 필수
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_PARTNER')")
    public ResponseEntity<ReservationSuccessResponse> reserveStore(@RequestBody StoreReserveDto dto) {
        // SecurityContextHolder 에서 인증된 사용자의 ID 를 가져온다.
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ReservationSuccessResponse reservationSuccessResponse = storeService.reserveStore(dto,username);
        return ResponseEntity.ok().body(reservationSuccessResponse);
    }

    /**
     * 도착확인 하는 메서드. 고객은 현장에 와서 키오스크로 확인하기 때문에 JWT 사용 불가
     * 현장에서 입력한 memberID 로 예약리스트를 찾는다.
     */
    @PostMapping("/visit")
    public ResponseEntity<ReservationVisitedResponse> arrivalConfirmation(@RequestBody ArrivalConfirmationDto dto) {
        ReservationVisitedResponse response = storeService.arrivalConfirmation(dto);
        return ResponseEntity.ok().body(response);

    }

    public ResponseEntity<String> getStoreList() {
        storeService.getStoreList();
        return ResponseEntity.ok().body("구현중");
    }
}
