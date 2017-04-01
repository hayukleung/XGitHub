package com.hayukleung.xgithub.di.module;

import com.hayukleung.xgithub.api.GitHubApi;
import com.hayukleung.xgithub.common.Constants;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * XGitHub
 * com.hayukleung.xgithub
 * GitHubApiModule.java
 *
 * by hayukleung
 * at 2017-03-31 10:28
 */

@Module public class GitHubApiModule {

  @Inject public GitHubApiModule() {
  }

  @Provides public OkHttpClient providesOkHttpClient() {
    return new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
        .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
        .build();
  }

  @Provides public Retrofit providesRetrofit(OkHttpClient okHttpClient) {
    return new Retrofit.Builder().baseUrl(Constants.HOST_API_GITHUB)
        // 添加Rx适配器
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        // 添加Gson转换器
        .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
  }

  @Provides public GitHubApi providesGitHubApi(Retrofit retrofit) {
    return retrofit.create(GitHubApi.class);
  }
}
