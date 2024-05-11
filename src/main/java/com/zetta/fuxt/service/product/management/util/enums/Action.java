package com.zetta.fuxt.service.product.management.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p> Esta clase es una clase enumerada que representa las acciones
 * que se pueden realizar en el sistema.</p>
 * <p> Esta clase es utilizada para almacenar las acciones que se pueden
 * realizar en el sistema.</p>
 * <p><b>Class</b>: Action</p>
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
public enum Action {
  CREATE_PRODUCT("1", "create-product", "CreateProduct"),
  UPDATE_PRODUCT("2", "update-product", "UpdateProduct"),
  DELETE_PRODUCT("3", "delete-product", "DeleteProduct"),
  UPDATE_PARTIAL_PRODUCT("4", "update-partial-product", "UpdatePartialProduct"),
  END_SESSION("5", "end-session", "EndSession");

  private String code;
  private String value;
  private String eventType;
}
