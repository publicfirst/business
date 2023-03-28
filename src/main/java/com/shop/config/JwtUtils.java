package com.shop.config;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtils {


    //设置token过期时间
    public static final long EXPIRE = 1000 * 60 * 30;    //半个小时
    //签名加密密钥
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    /**
     * 生成token
     * @param userInfoVo 用户实体类
     * @return
     */
    public static String getJwtToken(String strJson){

        String JwtToken = Jwts.builder()
                //设置头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //设置token过期时间
                .setSubject("user")   //随便写
                .setIssuedAt(new Date())
                //当前时间加上设置的过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                //设置token主体,可存储用户信息
                .claim("userInfo", strJson)
                //签名哈希
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if(StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取会员id
     * @param request
     * @return
     */
    public static UserInfoVo getMemberIdByJwtToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if(StringUtils.isEmpty(jwtToken)) return null;
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
            Claims claims = claimsJws.getBody();
            String strJson = (String)claims.get("userInfo");
            UserInfoVo userInfoVo = JSONObject.parseObject(strJson, UserInfoVo.class);
            return userInfoVo;
        } catch (ExpiredJwtException e) {
            return null;
        }
    }
}
