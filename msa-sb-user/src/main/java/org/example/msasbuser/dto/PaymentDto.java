package org.example.msasbuser.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 결제 요청 정보를 가진 dto
 */
@Data
public class PaymentDto {
    private String pdtId;       // 제품번호
    private String amount;      // 수량
    private String email;       // 주문자, 서버측에서 세팅!! (요청시 누락)
    // 실제는 더 많은 정보가 필요할수 있다
    @Builder
    public PaymentDto(String pdtId, String amount, String email) {
        this.pdtId = pdtId;
        this.amount = amount;
        this.email = email;
    }
}
