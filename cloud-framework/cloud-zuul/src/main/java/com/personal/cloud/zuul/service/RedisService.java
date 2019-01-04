package com.personal.cloud.zuul.service;

//import com.personal.common.exception.AppException;
//import com.personal.common.utils.BeanUtility;
//import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hzhang on 2017/4/25.
 */
@Service
public class RedisService {
//
//    private RedisTemplate<String, ?> redisTemplate;
//
//    @Autowired(required = false)
//    public void setRedisTemplate(RedisTemplate redisTemplate) {
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(stringSerializer);
//        this.redisTemplate = redisTemplate;
//    }
//
//    public boolean set(final String key, final String value) {
//        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//                connection.set(serializer.serialize(key), serializer.serialize(value));
//                return true;
//            }
//        });
//        return result;
//    }
//
//    public String get(final String key) {
//        String result = redisTemplate.execute(new RedisCallback<String>() {
//            public String doInRedis(RedisConnection connection) throws DataAccessException {
//                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//                byte[] value = connection.get(serializer.serialize(key));
//                return serializer.deserialize(value);
//            }
//        });
//        return result;
//    }
//
//    public boolean hset(final String table_key, final String key, final String value) {
//        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//                connection.hSet(serializer.serialize(table_key), serializer.serialize(key), serializer.serialize(value));
//                return true;
//            }
//        });
//        return result;
//    }
//
//    public String hget(final String table_key, final String key_id) {
//        String result = redisTemplate.execute(new RedisCallback<String>() {
//            public String doInRedis(RedisConnection connection) throws DataAccessException {
//                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//                byte[] value = connection.hGet(serializer.serialize(table_key), serializer.serialize(key_id));
//                return serializer.deserialize(value);
//            }
//        });
//        return result;
//    }
//
//    public boolean hexists(final String table_key, final String key_id) {
//        return redisTemplate.execute((RedisCallback<Boolean>) connection -> {
//            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//            return connection.hExists(serializer.serialize(table_key), serializer.serialize(key_id));
//        });
//    }
//
//    public void hdel(final String table_key, final String key) {
//        if (StringUtils.isBlank(table_key) || StringUtils.isBlank(key)) {
//            return;
//        }
//        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//                Long ret = connection.hDel(serializer.serialize(table_key), serializer.serialize(key));
//                return true;
//            }
//        });
//    }
//
//    /**
//     * list：[2, 5, 1, 3]·设置List结构的行数据
//     *
//     * @param list_key
//     * @param value
//     * @return
//     */
//    public boolean lpushVal(final String list_key, final String value) {
//        if (StringUtils.isBlank(list_key) || StringUtils.isBlank(value)) {
//            return false;
//        }
//        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//                connection.lPushX(serializer.serialize(list_key), serializer.serialize(value));
//                return true;
//            }
//        });
//        return result;
//    }
//
//    public String lrangeVal(final String list_key) {
//        String result = redisTemplate.execute(new RedisCallback<String>() {
//            public String doInRedis(RedisConnection connection) throws DataAccessException {
//                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//                List<byte[]> list = connection.lRange(serializer.serialize(list_key), 0, -1);
//                try {
//                    return BeanUtility.objectToJsonStr(list, false);
//                } catch (AppException e) {
//                    return "";
//                }
//            }
//        });
//        return result;
//    }
//
//    public void delList(final String list_key) {
//        if (StringUtils.isBlank(list_key)) {
//            return;
//        }
//        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//                Long ret = connection.del(serializer.serialize(list_key));
//                return true;
//            }
//        });
//    }
//
//    public boolean expire(final String key, long expire) {
//        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
//    }


}
