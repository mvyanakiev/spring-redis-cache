package app.redis;

import app.dto.AuthUserDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class RedisUtility {

    private RedisTemplate<String, String> redisTemplate;

    private Gson gson;

    public void setValue(final String key, AuthUserDTO authUserDTO) {
        redisTemplate.opsForValue().set(key, gson.toJson(authUserDTO));
        redisTemplate.expire(key, 10, TimeUnit.MINUTES);
    }

    public AuthUserDTO getValue(final String key) {
        return gson.fromJson(redisTemplate.opsForValue().get(key), AuthUserDTO.class);
    }

    public void deleteKeyFromRedis(final String key) {
        redisTemplate.delete(key);
    }
}
