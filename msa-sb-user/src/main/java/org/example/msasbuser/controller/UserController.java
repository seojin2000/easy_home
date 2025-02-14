package org.example.msasbuser.controller;

import org.example.msasbuser.dto.UserDto;
import org.example.msasbuser.dto.UserUpdateDto;
import org.example.msasbuser.service.AddressService;
import org.example.msasbuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * 회원가입, 회원정보수정, 비번수정,...
 */
@RestController
// 게이트웨이에서 연동되어 있음
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    // 에코테스트
    @GetMapping("/echo")
    public ResponseEntity<String> echo() {
        return ResponseEntity.ok("/user~ 에코 테스트");
    }


    // 회원가입
    // post, json 데이터 전달 -> 엔티티, dto 고려하여 구성
    @PostMapping("/signup")
    // ResponseEntity<?>  => 응답을 유연하게 구성 가능함
    public ResponseEntity<String> signup(@RequestBody UserDto userDto) {
        System.out.println("회원가입요청 : " + userDto.toString());

        // 주소 검색
        if (userDto.getAddress() == null || userDto.getAddress().isEmpty()) {
            throw new IllegalArgumentException("주소를 입력해야 합니다.");
        }
        // 주소 검색 API 호출
        String fullAddress = addressService.searchAddress(userDto.getAddress());
        userDto.setAddress(fullAddress);


        // 1. 회원가입처리 -> 비즈니스로직 -> 서비스 해결
        // 2. UserSercvice에 createUser( xxDTO ) -> 레퍼지토리 -> 디비까지 입력 구성 -> 인증메일발송
        userService.createUser( userDto );
        // 3. 응답처리
        return ResponseEntity.ok("회원가입 성공");
    }


    // 이메일 검증 처리 -> 인증메일 처리 -> enable의 값을 f->t
    // GET, /valid, 엑세스토큰없이 전근가능해야함(로그인 전->게이트웨이 수정), 파라미터 token, 입주민 테이블 업데이트
    @GetMapping("/valid")
    public ResponseEntity<String> valid(@RequestParam ("token") String token) {
        try{
            // 입주민 테이블 업데이트
            userService.updateActivate(token);
            return ResponseEntity.ok("이메일 인증 완료. 계정이 활성화 되었습니다.");

        } catch (IllegalArgumentException e) {
            //조작된(만료된) 토큰을 인증 -> 비정상, Bad Request
            return ResponseEntity.status(500).body("서버측 내부 오류 : " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("서버측 내부 오류 : " + e.getMessage());
        }
    }

    // 마이페이지 - 내 정보 조회
    @GetMapping("/mypage")
    public ResponseEntity<UserDto> getMyInfo(@AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        UserDto userDto = userService.getUserInfo(email);
        return ResponseEntity.ok(userDto);
    }

    // 마이페이지 - 내 정보 수정 (닉네임, 아파트 주소)
    @PutMapping("/mypage/update")
    public ResponseEntity<String> updateMyInfo(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody UserUpdateDto userUpdateDto
    ) {
        String email = userDetails.getUsername();
        userService.updateUserInfo(email, userUpdateDto);
        return ResponseEntity.ok("회원 정보가 수정되었습니다.");
    }

    // 마이페이지 - 비밀번호 변경
    @PutMapping("/mypage/password")
    public ResponseEntity<String> updatePassword(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody String newPassword
    ) {
        String email = userDetails.getUsername();
        userService.updatePassword(email, newPassword);
        return ResponseEntity.ok("비밀번호가 변경되었습니다.");
    }
}
