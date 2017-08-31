package com.yk.cbat.service.RedisServiceImpl;

import com.yk.cbat.service.RedisService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

/**
 * Created by JohenTeng on 2017/8/29.
 */
@Service("redisServiceImpl")
public class RedisServiceImpl extends RedisService{


    public String getData(final String keyId) {
        Object result = redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(keyId);
                byte[] value = connection.get(key);
                if(value == null){
                    return null;
                }
                return  serializer.deserialize(value);
            }
        });
        return String.valueOf(result);
    }


    public boolean saveDate(final String key,final String data) {
        Object result = super.redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) {
                try {
                    RedisSerializer<String> serializer = getRedisSerializer();
                    byte[] jkey = serializer.serialize(key);
                    byte[] jvalue = serializer.serialize(data);
                    if(connection.exists(jkey)){
                        connection.del(jkey);
                        connection.setNX(jkey,jvalue);
                        return true;
                    }else {
                        connection.setNX(jkey,jvalue);
                        return true;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    return false;
                }
            }
        });
        return (Boolean) result;
    }

}
