package me.ricky.aggregate.common.util;

import lombok.extern.slf4j.Slf4j;
import me.ricky.aggregate.common.enums.EnumModel;
import me.ricky.aggregate.common.enums.EnumValue;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class EnumUtil {
    public List<EnumValue> toEnumValues(Class<? extends EnumModel> e) {
        return Arrays
                .stream(e.getEnumConstants())
                .map(EnumValue::new)
                .collect(Collectors.toList());
    }
    /* 특정포맷 사용시 */
    public List<EnumValue> toEnumKeyValues(Class<? extends EnumModel> e) {
        return Arrays
                .stream(e.getEnumConstants())
                .map(enumModel -> new EnumValue(enumModel.getKey(), enumModel.getValue()))
                .collect(Collectors.toList());
    }
}
