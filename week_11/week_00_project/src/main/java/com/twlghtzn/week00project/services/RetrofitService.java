package com.twlghtzn.week00project.services;

import com.twlghtzn.week00project.models.dtos.TokenResponse;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Service
public interface RetrofitService {

  @GET("/3/authentication/token/new")
  Call<TokenResponse> getToken(@Query("api_key") String accessToken);
}
