package com.personal.common.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.personal.common.exception.AppException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * <p>
 * 通用层的Bean处理工具类. 用于对 Bean的绑定, json字符串转对象, 对象转json字符串.
 * </p>
 *
 * @author wq
 */
public class BeanUtility {
    /**
     * <p>
     * <code>BeanUtility</code> instances should NOT be constructed in standard
     * programming. Instead, the class should be used as
     * <code>BeanUtility.objectToJsonStr(obj);</code>.
     * </p>
     * <p>
     * <p>
     * This constructor is public to permit tools that require a JavaBean
     * instance to operate.
     * </p>
     */
    private BeanUtility() {
        super();
    }

    /**
     * <p>
     * 对象转json文字串. 使用Jackson的{@link ObjectMapper#writeValueAsString(Object)}.
     * 封装了异常; 如果 obj is null 将返回空字符串; 如果obj中value is null 将以空字符串代替.
     * </p>
     *
     * @param obj 需要转换的对象
     * @return 转换成功的json字符串.
     * @throws AppException 通用层的异常
     */
    public static String objectToJsonStr(final Object obj, boolean nullToEmpty) throws AppException {
        String jsonStr = StringUtils.EMPTY;
        if (obj == null) {
            return jsonStr;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (nullToEmpty) {
                objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

                    @Override
                    public void serialize(Object value, JsonGenerator jg, SerializerProvider sp)
                        throws IOException {
                        jg.writeString(StringUtils.EMPTY);
                    }
                });
            }
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw new AppException(e.getMessage());
        }

        return jsonStr;
    }

    /**
     * <p>
     * 对象转json文字串. 使用Jackson的{@link ObjectMapper#writeValueAsString(Object)}.
     * 封装了异常.
     * </p>
     *
     * @param obj        需要转换的对象
     * @param defaultStr 如果转换后的json为空的默认值
     * @return 转换成功的json字符串.
     * @throws AppException 通用层的异常
     */
    public static String objectToJsonStr(final Object obj, boolean nullToEmpty, String defaultStr) throws AppException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr;
        try {
            if (nullToEmpty) {
                objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

                    @Override
                    public void serialize(Object value, JsonGenerator jg, SerializerProvider sp)
                        throws IOException {
                        jg.writeString(StringUtils.EMPTY);
                    }
                });
            }
            jsonStr = objectMapper.writeValueAsString(obj);
            if (StringUtils.isBlank(jsonStr)) {
                return defaultStr;
            }
            return jsonStr;
        } catch (IOException e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * <p>
     * json文字串转对象. 使用Jackson的{@link ObjectMapper#readValue(String, Class)}.
     * 封装了异常; 如果jsonstr is null or empty 将返回 null.
     * </P>
     *
     * @param <T>     转换对象的类
     * @param jsonStr json字符串
     * @param type    转换对象的类(如KKKK.class)
     * @return 转换的类(如KKKK)
     * @throws AppException 通用层的异常
     */
    public static <T> T jsonStrToObject(final String jsonStr, final Class<T> type, boolean nullToEmpty)
        throws AppException {
        ObjectMapper objectMapper = new ObjectMapper();
        T obj;
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            if (nullToEmpty) {
                objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

                    @Override
                    public void serialize(Object value, JsonGenerator jg, SerializerProvider sp)
                        throws IOException {
                        jg.writeString(StringUtils.EMPTY);
                    }
                });
            }
            objectMapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            obj = objectMapper.readValue(jsonStr, type);
        } catch (IOException e) {
            throw new AppException(e.getMessage());
        }

        return obj;
    }
}
