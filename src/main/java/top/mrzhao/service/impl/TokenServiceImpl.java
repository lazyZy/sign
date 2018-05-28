package top.mrzhao.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mrzhao.entity.User;
import top.mrzhao.jedis.JedisClientPool;
import top.mrzhao.service.TokenService;
import top.mrzhao.util.BaseResult;

import java.util.UUID;

/**
 * Created by ZY on 2018/5/27.
 */
@Service
public class TokenServiceImpl implements TokenService{
    @Autowired
    JedisClientPool jedisClientPool;

    @Override
    public String SetUserLoginInfo(User user) {
        String token = getUUID();
        jedisClientPool.set(token, JSON.toJSONString(user));
        jedisClientPool.expire(token, 60 * 60);
        return token;
    }

    @Override
    public String SetUserLoginInfo(String token, User user) {
        jedisClientPool.set(token, JSON.toJSONString(user));
        jedisClientPool.expire(token, 60 * 60);
        return token;
    }

    @Override
    public BaseResult GetUserLoginInfo(String token) {
        if (checkToken(token)) {
            jedisClientPool.expire(token, 60 * 60);
            User user = JSON.parseObject(jedisClientPool.get(token),User.class);
            BaseResult.createOk(user);
        }
        return BaseResult.createDataNotFound();
    }

    public boolean checkToken(String token) {
        boolean flag = false;
        if (null != token && jedisClientPool.exists(token)) {
            flag = true;
        }
        return flag;
    }

    public String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
