package com.twlghtzn.week00project.services;

import com.twlghtzn.week00project.APIConfiguration;
import com.twlghtzn.week00project.models.dtos.TokenResponse;
import java.io.IOException;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class TMDBService implements APIConfiguration {
  private String accessToken;
  private RetrofitService retrofitService;

  public TMDBService() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(JacksonConverterFactory.create())
        .build();
    retrofitService = retrofit.create(RetrofitService.class);
    accessToken = System.getenv("TMDB_API_KEY");
  }

  public TokenResponse getNewToken() throws IOException {
    Call<TokenResponse> tokenResponseCall = retrofitService.getToken(accessToken);
    Response<TokenResponse> response = tokenResponseCall.execute();
    return response.body();
  }
}
