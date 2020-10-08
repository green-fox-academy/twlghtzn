package com.twlghtzn.week00project.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JWTService {

  @Autowired
  public JWTService() {
  }

  @SuppressWarnings("unchecked")
  public String createJWT(String userName) {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(System.getenv("TMDB_API_KEY"));
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
    JSONObject payload = new JSONObject();
    payload.put("userName", userName);
    JwtBuilder builder = Jwts.builder()
        .setPayload(payload.toJSONString())
        .signWith(signatureAlgorithm, signingKey);
    return builder.compact();
  }

  public Claims decodeJWT(String jwt) {
    return Jwts.parser()
        .setSigningKey(DatatypeConverter.parseBase64Binary(System.getenv("TMDB_API_KEY")))
        .parseClaimsJws(jwt).getBody();
  }

  public String readUserNameFromJWT(String jwt) {
    Claims claims = decodeJWT(jwt);
    Map<String, Object> data = new HashMap<>();
    for (Map.Entry<String, Object> entry : claims.entrySet()) {
      data.put(entry.getKey(), entry.getValue());
    }
    return data.get("userName").toString();
  }


}
