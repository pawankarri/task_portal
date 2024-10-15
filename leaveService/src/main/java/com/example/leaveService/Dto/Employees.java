package com.example.leaveService.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employees {


    private Integer id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private String role;
    @JsonIgnore
    private boolean enabled;
    @JsonIgnore
    private String username;
    @JsonIgnore
    private boolean credentialsNonExpired;
    @JsonIgnore
    private boolean accountNonExpired;
    @JsonIgnore
    private boolean accountNonLocked;
    @JsonIgnore
    private List<Authority> authorities;
}
