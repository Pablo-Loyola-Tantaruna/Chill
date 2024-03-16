package com.zetta.fuxt.service.product.management.util.header;

import com.zetta.fuxt.service.product.management.util.header.manager.RequestHeaderObject;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class RequestHeaderObjectResolve implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestHeaderObject.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        RequestHeaderObject headerObject = parameter.getParameterAnnotation(RequestHeaderObject.class);
        String headerName = headerObject.value();
        if (headerName.isEmpty() || headerName.isBlank()) {
            headerName = headerObject.name();
        }

        String headerValue = webRequest.getHeader(headerName);

        if (headerValue == null && headerObject.required()) {
                throw new ServletRequestBindingException("Required header " + headerName + " not present");
        }

        return headerValue;
    }

}
