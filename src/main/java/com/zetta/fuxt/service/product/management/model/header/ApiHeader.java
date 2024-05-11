package com.zetta.fuxt.service.product.management.model.header;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> Clase modelo que representa el header de la petición.</p>
 * <p> Esta clase es utilizada para la creación de productos.</p>
 * <p><b>Class</b>: ApiHeader</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.model.header</p>
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiHeader {

  @JsonIgnoreProperties("sessionId")
  @Pattern(regexp = "^([a-zA-Z0-9]{8}-[0-9a-xA-X]{6}-[20][0-5d-xD-X]"
          + "{3}-[14ab][0-2a-wA-W]{5}-[0-8a-mA-M]{8}$)",
      message = "Invalid session id")
  @Schema(description = "Session id",
      example = "12345678-1234-5678-1234-567812345678",
      required = true,
      type = "string",
      name = "sessionId")
  @NotNull
  @NotEmpty
  private String sessionId;

  @Pattern(regexp = "^[a-zA-Z\\.\\-0-9]+$")
  @Schema(description = "Device Name",
      example = "Laptop IUSACELL-1234",
      required = true,
      type = "string",
      name = "deviceName")
  private String deviceName;

  @Pattern(regexp = "^[a-zA-Z\\.\\-0-9]+$")
  @Schema(description = "Device IP",
      example = "192.168.555.52",
      required = true,
      type = "string",
      name = "deviceIp")

  private String deviceIp;

  @Pattern(regexp = "^[a-zA-Z\\.\\-0-9]+$")
  @Schema(description = "Number Trx",
      example = "1223133123",
      required = true,
      type = "string",
      name = "numberTrx")
  @NotNull
  @NotEmpty
  private String numberTrx;

  @Pattern(regexp = "^[a-zA-Z\\.\\-0-9]+$")
  @Schema(description = "Application Code",
      example = "ZGRG",
      required = true,
      type = "string",
      name = "appCode")
  @NotNull
  @NotEmpty
  private String appCode;

  @Pattern(regexp = "^[a-zA-Z\\.\\-0-9]+$")
  @Schema(description = "UserName",
      example = "Emilio12",
      required = false,
      type = "string",
      name = "userName")
  private String userName;

  @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}"
          + "[+-]\\d{4}([a-z]|[A-Z]|\\d)?$")
  @Schema(description = "request date",
      example = "2021-08-12T12:12:12.123+0000",
      required = true,
      type = "string",
      name = "requestDate")
  @NotNull
  @NotEmpty
  private String requestDate;

  @Pattern(regexp = "^([a-zA-Z0-9]{8}-[0-9a-xA-X]{6}-[20][0-5d-xD-X]{3}-[14ab]"
          + "[0-2a-wA-W]{5}-[0-8a-mA-M]{8}$)")
  @Schema(description = "Request id",
      example = "12345678-1234-5678-1234-567812345678",
      required = true,
      type = "string",
      name = "requestId")
  @NotNull
  @NotEmpty
  private String requestId;
}
