package com.onfleet.interceptors;

import com.google.common.util.concurrent.RateLimiter;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class RateLimitInterceptor implements Interceptor {
	private final RateLimiter rateLimiter;

	public RateLimitInterceptor(double permitsPerSecond) {
		this.rateLimiter = RateLimiter.create(permitsPerSecond);
	}

	@NotNull
	@Override
	public Response intercept(@NotNull Chain chain) throws IOException {
		rateLimiter.acquire();
		Request request = chain.request();
		return chain.proceed(request);
	}
}
