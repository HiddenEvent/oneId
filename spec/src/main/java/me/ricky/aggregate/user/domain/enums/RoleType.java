package me.ricky.aggregate.user.domain.enums;


import me.ricky.aggregate.common.enums.EnumModel;

public enum RoleType implements EnumModel {
    SYSTEM("시스템"),
    ADMIN("관리자"),
    USER("사용자");
    ;
    private final String statusMsg;

    RoleType(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return statusMsg;
    }
}
