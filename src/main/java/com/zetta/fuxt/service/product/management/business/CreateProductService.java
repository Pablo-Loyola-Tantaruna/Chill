package com.zetta.fuxt.service.product.management.business;

import com.zetta.fuxt.service.product.management.model.api.createproduct.CreateProductRequest;
import com.zetta.fuxt.service.product.management.model.header.ApiHeader;
import io.reactivex.rxjava3.core.Completable;

/**
 * <p> Interface que permite la creaci&oacute;n de productos.</p>
 * <p> Esta interfaz es implementada por la clase que se encarga
 * de la creación de productos.</p>
 * <p><b>Class</b>: CreateProductService</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.business</p>
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
public interface CreateProductService {

  /**
   * M&eacute;todo que permite la creaci&oacute;n de un producto.
   *
   * @param header Informaci&oacute;n del header.
   * @param request Informaci&oacute;n del producto a crear.
   * @return Completable
   */

  Completable process(ApiHeader header, CreateProductRequest request);
}
