package me.ricky.user.domain.enums;


import me.ricky.common.enums.EnumModel;

public enum RoleType implements EnumModel {
    ANONYMOUS("일반"),
    NOT_PERMITTED("미권한"),
    MANAGER("매니저"),
    ADMIN("관리자"),
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
