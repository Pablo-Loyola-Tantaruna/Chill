package com.zetta.fuxt.service.product.management.model.api.createproduct;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> Esta clase es una clase modelo que representa el request de creación de un producto.</p>
 * <p> Esta clase es utilizada para la creación de productos.</p>
 * <p><b>Class</b>: CreateProductRequest</p>
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
public class CreateProductRequest {

  private String id_product;

  private String name_product;

  private String description_product;

  private String price_product;

  private List<CreatePrCategory> category_product;

  private List<CreatePrDetail> detail_product;

  private String sku_product;

  private String upc_product;


  private boolean available_product;

  private int stock_product;


  @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$")
  private String date_create;

  @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$")
  private String date_update;

  private boolean offer_active;

  private String offer_percentage;

  private boolean send_abroad;

  private boolean warranty;

  private String warranty_duration;

  private String warranty_type;

  private String warranty_description;

  private String compatibility_product;


}
