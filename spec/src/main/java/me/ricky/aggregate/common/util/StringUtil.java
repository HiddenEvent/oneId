package me.ricky.aggregate.common.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil extends StringUtils {
    public StringUtil() {
        // TODO document why this constructor is empty
    }

    public static boolean equalsAsPhone(String phone1, String phone2) {
        if (phone1 != null && phone1.contains("-")) {
            phone1 = phone1.replace("-", "");
        }

        if (phone2 != null && phone2.contains("-")) {
            phone2 = phone2.replace("-", "");
        }

        return equalsIgnoreCase(phone1, phone2);
    }
}
