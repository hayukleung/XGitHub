package com.hayukleung.xgithub;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * XGitHub
 * com.hayukleung.xgithub
 * GitHubApiService.java
 *
 * by hayukleung
 * at 2017-03-31 10:46
 */

public interface GitHubApiService {

  @GET("todo") Observable<Object> api(@Path("user") String user);
}
