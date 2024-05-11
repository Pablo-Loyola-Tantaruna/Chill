package com.zetta.fuxt.service.product.management.model.api.createproduct;

import lombok.Getter;
import lombok.Setter;

/**
 * <p> Esta clase es una clase modelo que representa la categoría de un producto.</p>
 * <p> Esta clase es utilizada para la creación de productos.</p>
 * <p><b>Class</b>: CreatePrCategory</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.model.api.createproduct</p>
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
public class CreatePrCategory {

  private String id_category;

  private String name_category;

  private String id_sub_category;

  private String name_sub_category;
}
