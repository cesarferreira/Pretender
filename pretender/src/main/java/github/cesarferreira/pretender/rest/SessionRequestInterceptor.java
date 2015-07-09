package github.cesarferreira.pretender.rest;

import retrofit.RequestInterceptor;

public class SessionRequestInterceptor implements RequestInterceptor {
    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("Accept", "application/json");
    }
}
