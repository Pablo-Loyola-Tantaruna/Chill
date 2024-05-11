package com.zetta.fuxt.service.product.management.business;

import com.zetta.fuxt.service.product.management.model.api.deleteproduct.DeleteProductRequest;
import com.zetta.fuxt.service.product.management.model.header.ApiHeader;
import io.reactivex.rxjava3.core.Completable;

/**
 * <p> Clase que implementa la interfaz DeleteProductService.</p>
 * <p> Esta clase se encarga de gestionar la eliminación lógica de productos.</p>
 * <p><b>Class</b>: DeleteProductService</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.business</p>
 * <p><b>Project</b>: products-service</p>
 * <p><b>Version</b>: 1.0.0</p>
 * <p><b>Company</b>: Zetta Technology Studios</p>
 * <p><b>Creation Date</b>: 2024-05-11</p>
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

public interface DeleteProductService {

    /**
     * M&eacute;todo que permite la eliminación lógica de un producto.
     *
     * @param header Informaci&oacute;n del header.
     * @param request Informaci&oacute;n del producto a eliminar.
     * @return Completable
     */
    Completable process(ApiHeader header, DeleteProductRequest request);
}
