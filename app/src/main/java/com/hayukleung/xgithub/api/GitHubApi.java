package com.hayukleung.xgithub.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * XGitHub
 * com.hayukleung.xgithub
 * GitHubApi.java
 *
 * by hayukleung
 * at 2017-03-31 10:46
 */

public interface GitHubApi {

  // 获取用户基本信息
  @GET("/users/{username}") Observable<Object> api(@Path("username") String user);
}
