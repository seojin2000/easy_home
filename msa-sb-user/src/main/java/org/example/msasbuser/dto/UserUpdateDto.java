package org.example.msasbuser.dto;

import lombok.Data;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * 마이페이지에서 정보 수정 후 DTO
 */
@Data
@ToString
public class UserUpdateDto {
    // @NotNull : 향후 버전에서는 제거될수 있다. 널 허용 x 반드시 세팅하는 강제조항
    @NotNull
    private String password;
    @NotNull
    private String userName;

    private String address;
}
