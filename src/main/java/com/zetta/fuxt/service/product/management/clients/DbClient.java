package com.zetta.fuxt.service.product.management.clients;

import io.reactivex.rxjava3.core.Single;

/**
 * <p> Interfaz que permite la ejecución de consultas en la base de datos.</p>
 * <p> Esta interfaz es implementada por las clases que se encargan
 * de la conexión a la base de datos.</p>
 * <p><b>Class</b>: DbClient</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.clients</p>
 * <p><b>Project</b>: products-service</p>
 * <p><b>Version</b>: 1.0.0</p>
 * <p><b>Company</b>: Zetta Technology Studios</p>
 * <p><b>Creation Date</b>: 2024-03-16</p>
 * <p><b>Copyright</b>: Zetta Technology Studios (ZTS)</p>
 * <p>@author Zetta Technology Studios (ZTS)</p>
 * <div>
 *   <u>Developed by</u>:
 *   <ul>
 *   <li>Pablo Sergio Loyola Tantaruna</li>
 *   </ul>
 * </div>
 * <div>
 *   <u>Reviewed by</u>:
 *   <ul>
 *   <li>Pablo Sergio Loyola Tantaruna</li>
 *   </ul>
 * </div>
 * <p><b>Version</b>: 1.0.0</p>
 */
public interface DbClient<T, Q> {
  
  /**
   * M&eacute;todo que permite la ejecuci&oacute;n de 
   * una consulta en la base de datos.
   *
   * @param query Consulta a ejecutar.
   * @return T
   */
  Single<T> execute(Q query);
}