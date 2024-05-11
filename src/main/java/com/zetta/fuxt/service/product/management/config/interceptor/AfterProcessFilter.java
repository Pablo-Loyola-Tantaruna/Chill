package com.zetta.fuxt.service.product.management.config.interceptor;


import com.zetta.fuxt.service.product.management.config.ErrorProperties;
import com.zetta.fuxt.service.product.management.model.header.ApiHeader;
import com.zetta.fuxt.service.product.management.util.enums.Action;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * <p> Clase que se encarga de procesar los resultados de las peticiones HTTP
 *  y almacenarlos en cache. </p>
 * <p><b>Class</b>: AfterProcessFilter</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.config.interceptor</p>
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
@Slf4j
@Component
@RequiredArgsConstructor
public class AfterProcessFilter {

  //private final CacheService cacheService;

  /*
  private ErrorProperties errorProperties;
  public void processResult(Throwable throwable, Action action, ApiHeader apiHeader,
                            ServerWebExchange serverWebExchange, Environment env) {
    serverWebExchange.getResponse().getHeaders()
    .set(Constants.SESSION_ID, apiHeader.getSessionId());
    cacheService.load
  }*/
}
