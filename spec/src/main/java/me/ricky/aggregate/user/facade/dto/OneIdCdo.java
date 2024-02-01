package me.ricky.aggregate.user.facade.dto;

import me.ricky.aggregate.user.domain.enums.RoleType;

public record OneIdCdo(String email, String password, String name, RoleType roleType) {
    public OneIdCdo(UserRequest.Register req) {
        this(req.getEmail(), req.getPassword(), req.getName(), req.getRoleType());
    }
}
