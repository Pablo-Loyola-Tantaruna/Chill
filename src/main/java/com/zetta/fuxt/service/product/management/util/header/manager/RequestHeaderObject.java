package com.zetta.fuxt.service.product.management.util.header.manager;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

/**
 * <p> Esta clase es una clase utilitaria que contiene la anotación RequestHeaderObject.</p>
 * <p> Esta clase es utilizada para manejar los headers de las peticiones.</p>
 * <p><b>Class</b>: RequestHeaderObject</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.util.header.manager</p>
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
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RequestHeaderObject {

  /**
   * Este método es utilizado para obtener el nombre del header.
   *
   * @return name
   */
  //@AliasFor(annotation = Component.class)
  String name() default "";

  /**
   * Este método es utilizado para obtener el valor del header.
   *
   * @return value
   */
  //@AliasFor(annotation = Component.class)
  String value() default "";

  /**
   * Este método es utilizado para obtener si es requerido.
   *
   * @return required
   */
  boolean required() default true;

  /**
   * Este método es utilizado para obtener el valor por defecto.
   *
   * @return defaultValue
   */
  String defaultValue() default "";
}
