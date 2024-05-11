package com.zetta.fuxt.service.product.management.model.api.createproduct;

import com.zetta.fuxt.service.product.management.util.enums.Energy;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> Esta clase es una clase modelo que representa el detalle de un producto.</p>
 * <p> Esta clase es utilizada para la creación de productos.</p>
 * <p><b>Class</b>: CreatePrDetail</p>
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
public class CreatePrDetail {

  private String mark_product;

  private String model_product;

  private String color_product;

  private String size_product;

  private String weight_product;

  private String materials_product;

  private String origin_product;

  private String instructions_product;

  private Energy energy_product;

  private String compatibility_language_product;

  private List<byte[]> images_product;

  private String detail_product;
}
