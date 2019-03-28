package com.ppsweet.base;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class ParseJwtTest {
    public static void main(String[] args){
      Claims claims= Jwts.parser().setSigningKey("itcast")
                     .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjY2Iiwic3ViIjoi5bCP6amsIiwiaWF0IjoxNTUyNzkxNDMwLCJleHAiOjE1NTI3OTE0OTAsInJvbGUiOiJhZG1pbiJ9.4AR2r4e9c8nFtGn6FJ2V3dSx2GhGMVSmLkmYON8w0LI")
                     .getBody();

      System.out.println("用户id"+claims.getId());
      System.out.println("用户名"+claims.getSubject());
      System.out.println("登录时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
      System.out.println("过期时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
      System.out.println("用户角色"+claims.get("role"));

    }
}
