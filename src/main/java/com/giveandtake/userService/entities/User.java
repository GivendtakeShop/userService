package com.giveandtake.userService.entities;


import javax.persistence.*;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Builder
public class User extends BaseEntity{
    @NotBlank
    private String userName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phone;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

}
