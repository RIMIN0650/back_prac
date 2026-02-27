package org.example.practice.user.model;

import lombok.Builder;
import lombok.Getter;

public class UserDto {

    @Builder
    @Getter
    public static class SignupReq {
        private String email;
        private String name;
        private String password;

        public User toEntity() {
            return User.builder()
                    .email(this.email)
                    .name(this.name)
                    .password(this.password)
                    .build();
        }
    }


}
