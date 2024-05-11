package com.zetta.fuxt.service.product.management.util.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p> Esta clase es una clase enumerada que representa la energía
 * que consume un producto.</p>
 * <p> Esta clase es utilizada para almacenar la energía que consume un producto.</p>
 * <p><b>Class</b>: Energy</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.util.enums</p>
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
@AllArgsConstructor
public enum Energy {
  A_ENERGY("A", "< 55 %", "Low consumption energy product"),
  B_ENERGY("B", "55 - 75 %", "Low consumption energy product"),
  C_ENERGY("C", "75 - 90 %", "Low consumption energy product"),
  D_ENERGY("D", "95 - 100 %", "Consumption medium energy product"),
  E_ENERGY("E", "100 - 110 %", "Consumption medium energy product"),
  F_ENERGY("F", "110 - 125 %", "High consumption energy product"),
  G_ENERGY("G", "> 125 %", "High consumption energy product");

  private String code;
  private String consume_percentage;
  private String qualification;

}
