package com.zetta.fuxt.service.product.management.business;

import com.zetta.fuxt.service.product.management.model.api.createproduct.CreateProductRequest;
import com.zetta.fuxt.service.product.management.model.header.ApiHeader;
import io.reactivex.rxjava3.core.Single;

/**
 * <p> Interface que permite la creaci&oacute;n de productos.</p>
 * <p> Esta interfaz es implementada por la clase que se encarga
 * de la creación de productos.</p>
 * <p><b>Class</b>: ProductManagementService</p>
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
public interface ProductManagementService {

  /**
   * M&eacute;todo que permite la creaci&oacute;n de
   * un producto.
   *
   * @param request Informaci&oacute;n del producto a crear.
   * @return String
   */
  Single<String> createProductSql(CreateProductRequest request);


  /**
   * M&eacute;todo que permite la creaci&oacuten de
   * un producto.
   *
   * @param request Informaci&oacuten del producto a crear.
   * @return String
   */
  Single<String> createProductNoSql(CreateProductRequest request);
}
