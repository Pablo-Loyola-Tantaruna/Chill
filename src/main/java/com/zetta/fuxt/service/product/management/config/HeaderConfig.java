package com.zetta.fuxt.service.product.management.config;

import com.zetta.fuxt.service.product.management.util.header.RequestHeaderObjectResolve;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * <p> Configuración de los headers de las peticiones HTTP.</p>
 * <p><b>Class</b>: HeaderConfig</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.config</p>
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
@Configuration
public class HeaderConfig implements WebMvcConfigurer {

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(new RequestHeaderObjectResolve());
  }
}
