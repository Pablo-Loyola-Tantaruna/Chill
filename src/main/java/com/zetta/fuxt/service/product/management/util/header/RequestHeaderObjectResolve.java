package com.zetta.fuxt.service.product.management.util.header;

import com.zetta.fuxt.service.product.management.util.header.manager.RequestHeaderObject;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * <p> Esta clase es una clase utilitaria que contiene la
 * resolución de los headers de las peticiones.</p>
 * <p> Esta clase es utilizada para resolver los headers de las peticiones.</p>
 * <p><b>Class</b>: RequestHeaderObjectResolve</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.util.header</p>
 * <p><b>Project</b>: products-service</p>
 * <p><b>Version</b>: 1.0.0</p>
 * <p><b>Company</b>: Zetta Technology Studios</p>
 * <p><b>Creation Date</b>: 2024-03-16</p>
 * <p><b>Copyright</b>: Zetta Technology Studios (ZTS)</p>
 * <p>@author Zetta Technology Studios (ZTS)</p>
 * <div>
 *   <u>Developed by</u>:
 *   <ul>
 *     <li>Pablo Sergio Loyola Tantaruna</li>
 *   </ul>
 * </div>
 * <div>
 *   <u>Reviewed by</u>:
 *   <ul>
 *     <li>Pablo Sergio Loyola Tantaruna</li>
 *   </ul>
 * </div>
 * <p><b>Version</b>: 1.0.0</p>
 */
public class RequestHeaderObjectResolve implements HandlerMethodArgumentResolver {

  /**
   * Este método es utilizado para saber si soporta el parámetro.
   *
   * @param parameter Parámetro.
   * @return boolean
   */
  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.hasParameterAnnotation(RequestHeaderObject.class);
  }

  /**
   * Este método es utilizado para resolver el argumento.
   *
   * @param parameter Parámetro.
   * @param mavContainer Contenedor de la vista.
   * @param webRequest Solicitud web.
   * @param binderFactory Fábrica de enlace web.
   * @return Object
   * @throws Exception Excepción.
   */
  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                               NativeWebRequest webRequest,
                               WebDataBinderFactory binderFactory) throws Exception {
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
