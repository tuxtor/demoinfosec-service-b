package io.academik.demoinfosec.util;

public enum RolesEnum {
    WEB(Constants.WEB_VALUE),
    MOBILE(Constants.MOBILE_VALUE);

    private String rol;

    public String getRol() {
        return this.rol;
    }

    RolesEnum(String rol) {
        this.rol = rol;
    }

    public static class Constants {
        public static final String WEB_VALUE = "web";
        public static final String MOBILE_VALUE = "mobile";
    }
}
