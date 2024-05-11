package com.zetta.fuxt.service.product.management.repository;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import org.bson.json.JsonObject;

/**
 * <p> Interface que permite la implementaci&oacute;n de un servicio de cach&eacute;.</p>
 * <p> Esta interfaz es implementada por la clase que se encarga
 * de la gesti&oacute;n de la cach&eacute;.</p>
 * <p><b>Class</b>: CacheService</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.repository</p>
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
public interface CacheService {

  /**
   * M&eacute;todo que permite guardar un objeto en la cach&eacute;.
   *
   * @param jsonObject Objeto a guardar.
   */
  void save(JsonObject jsonObject);

  /**
   * M&eacute;todo que permite cargar un objeto de la cach&eacute;.
   *
   * @param sessionId Identificador de la sesi&oacute;n.
   * @return JsonObject
   */
  Single<JsonObject> load(String sessionId);

  /**
   * M&eacute;todo que permite guardar un dispositivo.
   *
   * @param deviceCode C&oacute;digo del dispositivo.
   */
  void saveDevice(String deviceCode);

  /**
   * M&eacute;todo que permite cargar un dispositivo.
   *
   * @param deviceCode C&oacute;digo del dispositivo.
   * @return Object
   */
  Maybe<Object> loadDevice(String deviceCode);

  /**
   * M&eacute;todo que permite guardar un objeto en la cach&eacute;.
   *
   * @param deviceReference Objeto a guardar.
   * @return Object
   */
  Maybe<Object> loadDataPartner(String deviceReference);

  /**
   * M&eacute;todo que permite guardar un objeto en la cach&eacute;.
   *
   * @param dataJson Informaci&oacute;n del producto.
   * @param createProduct Informaci&oacute;n del producto a crear.
   */
  void saveDataPartner(String dataJson, JsonObject createProduct);
}
