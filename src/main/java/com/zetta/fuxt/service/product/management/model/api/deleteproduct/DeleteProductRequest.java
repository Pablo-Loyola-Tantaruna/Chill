package com.zetta.fuxt.service.product.management.model.api.deleteproduct;

import lombok.Getter;
import lombok.Setter;

/**
 * <p> Clase que representa la petici&oacute;n de eliminaci&oacute;n de un producto.</p>
 * <p><b>Class</b>: DeleteProductRequest</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.model.api.deleteproduct</p>
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
@Getter
@Setter
public class DeleteProductRequest {

    private String id_product;

    private String sku_product;

    private String upc_product;
}
