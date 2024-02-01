package me.ricky.aggregate.user.facade.dto;

import me.ricky.aggregate.user.domain.User;
import me.ricky.aggregate.user.domain.enums.RoleType;

public record OneIdCdo(String email, String password, String name, RoleType userRole) {
    public OneIdCdo(User domain) {
        this(domain.getEmail(), domain.getPassword(), domain.getName(), domain.getRoleType());
    }
}
