package me.ricky.common.json;

public interface JsonSerializable {
    default String toJson() {
        return JsonUtil.toJson(this);
    }
}
