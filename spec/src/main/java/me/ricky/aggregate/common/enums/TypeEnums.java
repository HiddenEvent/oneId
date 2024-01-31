package me.ricky.aggregate.common.enums;

public enum TypeEnums {
    ;
    public enum RoleType implements EnumModel {
        ANONYMOUS( "일반"),
        NOT_PERMITTED( "미권한"),
        MANAGER( "매니저"),
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
    public enum ProfileType implements EnumModel {
        local( "local"),
        develop( "develop"),
        production( "production"),
        ;
        private final String statusMsg;

        ProfileType(String statusMsg) {
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
    public enum DatabaseType implements EnumModel {
        MYSQL( "mysql"),
        POSTGRE( "postgre"),
        MSSQL( "mssql"),
        ;
        private final String statusMsg;

        DatabaseType(String statusMsg) {
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
}
