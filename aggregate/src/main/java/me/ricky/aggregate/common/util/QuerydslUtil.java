//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.ricky.aggregate.common.util;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.*;
import me.ricky.aggregate.common.StringUtil;
import me.ricky.aggregate.common.util.CollectionUtil;
import org.apache.commons.lang3.Range;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class QuerydslUtil {
    public QuerydslUtil() {
        // TODO document why this constructor is empty
    }

    public static BooleanExpression eqIfNotNull(StringPath target, String value) {
        return StringUtil.isEmpty(value) ? null : target.eq(value);
    }

    public static BooleanExpression eqAnyIfNotNull(StringPath target, StringPath target2, String value) {
        return StringUtil.isEmpty(value) ? null : target.eq(value).or(target2.eq(value));
    }

    public static BooleanExpression eqIfNotNull(NumberPath target, String value) {
        return StringUtil.isEmpty(value) ? null : target.eq(value);
    }

    public static BooleanExpression eqIfNotNull(NumberPath target, Integer value) {
        return Objects.isNull(value) ? null : target.eq(value);
    }

    public static BooleanExpression eqIfNotNull(BooleanPath target, Boolean value) {
        return value == null ? null : target.eq(value);
    }

    public static BooleanExpression eqIfNotNull(EnumPath target, Enum value) {
        return value == null ? null : target.eq(value);
    }

    public static BooleanExpression containsIfNotNull(SimplePath target, String value) {
        return StringUtil.isEmpty(value) ? null : Expressions.stringOperation(Ops.STRING_CAST, new Expression[]{target}).contains(value);
    }

    public static BooleanExpression containsIfNotNull(StringPath target, String value) {
        return StringUtil.isEmpty(value) ? null : target.contains(value);
    }

    public static BooleanExpression likeIfNotNull(StringPath target, String value) {
        return StringUtil.isEmpty(value) ? null : target.like("%" + value + "%");
    }

    public static BooleanExpression likeIfNotNull(StringPath target, String value, char escape) {
        return StringUtil.isEmpty(value) ? null : target.like("%" + value + "%", escape);
    }

    public static BooleanExpression likeIfNotNull(SimplePath target, String value) {
        return StringUtil.isEmpty(value) ? null : Expressions.stringOperation(Ops.STRING_CAST, new Expression[]{target}).like("%" + value + "%");
    }

    public static BooleanExpression likeIfNotNull(SimplePath target, String value, char escape) {
        return StringUtil.isEmpty(value) ? null : Expressions.stringOperation(Ops.STRING_CAST, new Expression[]{target}).like("%" + value + "%", escape);
    }

    public static BooleanExpression likeIfNotNull(String value, StringPath target) {
        return StringUtil.isEmpty(value) ? null : Expressions.asString(value).like(target);
    }

    public static BooleanExpression startWithIfNotNull(StringPath target, String value) {
        return StringUtil.isEmpty(value) ? null : target.like(value + "%");
    }

    public static BooleanExpression startWithIfNotNull(StringPath target, String value, char escape) {
        return StringUtil.isEmpty(value) ? null : target.like(value + "%", escape);
    }

    public static BooleanExpression betweenIfNotNull(NumberPath<Long> target, Long startDate, Long endDate) {
        if (startDate == null && endDate == null) {
            return null;
        } else {
            if (startDate == null) {
                startDate = 0L;
            }

            if (endDate == null) {
                endDate = Long.MAX_VALUE;
            }

            return target.between(startDate, endDate);
        }
    }

    public static BooleanExpression betweenIfNotNull(NumberPath<Long> target, Range<Long> range) {
        return range == null ? null : target.between(range.getMinimum(), range.getMaximum());
    }

    /** @deprecated */
    @Deprecated
    public static BooleanBuilder betweenAnyOfIfNotNull(NumberPath<Long> target, Range<Long>... ranges) {
        if (ranges != null && ranges.length >= 1) {
            BooleanBuilder anyOfBooleanBuilder = new BooleanBuilder();
            anyOfBooleanBuilder.andAnyOf((Predicate[])Arrays.asList(ranges).stream().map((range) -> {
                return betweenIfNotNull(target, range);
            }).filter(Objects::nonNull).toArray((x$0) -> {
                return new BooleanExpression[x$0];
            }));
            return anyOfBooleanBuilder;
        } else {
            return null;
        }
    }

    public static BooleanBuilder betweenAnyOfIfNotNull(NumberPath<Long> target, List<Range<Long>> ranges) {
        if (CollectionUtil.isEmpty(ranges)) {
            return null;
        } else {
            BooleanBuilder anyOfBooleanBuilder = new BooleanBuilder();
            anyOfBooleanBuilder.andAnyOf((Predicate[])ranges.stream().map((range) -> {
                return betweenIfNotNull(target, range);
            }).filter(Objects::nonNull).toArray((x$0) -> {
                return new BooleanExpression[x$0];
            }));
            return anyOfBooleanBuilder;
        }
    }

    public static BooleanExpression inIfNotNull(StringPath target, String... values) {
        return values != null && values.length >= 1 ? target.in(Arrays.asList(values)) : null;
    }

    public static BooleanExpression notInIfNotNull(StringPath target, List<String> values) {
        return CollectionUtil.isEmpty(values) ? null : target.notIn(values);
    }

    public static BooleanExpression inIfNotNull(StringPath target, List<String> values) {
        return CollectionUtil.isEmpty(values) ? null : target.in(values);
    }

    public static BooleanExpression inAnyIfNotNull(StringPath target, StringPath target2, List<String> values) {
        return CollectionUtil.isEmpty(values) ? null : target.in(values).or(target2.in(values));
    }

    public static BooleanExpression inIfNotNull(EnumPath target, Enum... values) {
        return values != null && values.length >= 1 ? target.in(Arrays.asList(values)) : null;
    }

    public static BooleanExpression gtIfNotNull(NumberPath target, Integer value) {
        return value == null ? null : target.gt(value);
    }

    public static BooleanExpression goeIfNotNull(NumberPath target, Long value) {
        return value == null ? null : target.goe(value);
    }

    public static BooleanExpression loeIfNotNull(NumberPath target, Long value) {
        return value == null ? null : target.loe(value);
    }

    public static BooleanExpression goeIfNotNull(StringPath target, String value) {
        return StringUtil.isEmpty(value) ? null : target.goe(value);
    }

    public static BooleanExpression loeIfNotNull(StringPath target, String value) {
        return StringUtil.isEmpty(value) ? null : target.loe(value);
    }

    public static BooleanExpression containsIfNotNull(ListPath target, Object value) {
        return value == null ? null : target.contains(value);
    }

    public static BooleanExpression existsIfNotNull(NumberPath target, Boolean value) {
        if (value == null) {
            return null;
        } else {
            return value ? target.goe(1) : target.loe(0);
        }
    }

    public static BooleanExpression existsIfNotNull(ListPath target, Boolean value) {
        if (value == null) {
            return null;
        } else {
            return value ? target.size().goe(1) : target.size().loe(0);
        }
    }

    public static BooleanExpression notEqIfNotNull(StringPath target, String value) {
        return StringUtil.isEmpty(value) ? null : target.ne(value);
    }

    public static String addAsteriskBeforeAndAfterIfNotNull(String value) {
        return StringUtil.isEmpty(value) ? null : "%" + value + "%";
    }
}
