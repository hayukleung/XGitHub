package com.hayukleung.xgithub;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * XGitHub
 * com.hayukleung.xgithub
 * GitHubApiModule.java
 *
 * by hayukleung
 * at 2017-03-31 10:28
 */

@Module public class GitHubApiModule {

  @Provides public OkHttpClient provideOkHttpClient() {
    OkHttpClient okHttpClient = new OkHttpClient();
    // okHttpClient.setConnectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
    // okHttpClient.setReadTimeout(60 * 1000, TimeUnit.MILLISECONDS);
    return okHttpClient;
  }

  @Provides public Retrofit providesRetrofit(OkHttpClient okHttpClient) {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("")
        // .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
        // .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
        .client(okHttpClient).build();
    return retrofit;
  }

  @Provides protected GitHubApiService providesGitHubApiService(Retrofit retrofit) {
    return retrofit.create(GitHubApiService.class);
  }
}
