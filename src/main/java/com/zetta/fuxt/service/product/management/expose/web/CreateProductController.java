package com.zetta.fuxt.service.product.management.expose.web;

import com.zetta.fuxt.service.product.management.business.CreateProductService;
import com.zetta.fuxt.service.product.management.config.ErrorProperties;
import com.zetta.fuxt.service.product.management.model.api.createproduct.CreateProductRequest;
import com.zetta.fuxt.service.product.management.model.header.ApiHeader;
import com.zetta.fuxt.service.product.management.util.enums.Action;
import com.zetta.fuxt.service.product.management.util.header.manager.RequestHeaderObject;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

/**
 * <p>Controlador principal que expone la funcionalidad de creación de productos
 * a tra&eacute;s de Http/rest para las aplicaciones clientes.</p>
 * <p><b>Class</b>: UpdateProductController</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.expose.web</p>
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

@RefreshScope
@RestController
@Tag(name = "CreateProduct")
@RequestMapping("/add-products")
@Slf4j
@RequiredArgsConstructor
public class CreateProductController {

  private final CreateProductService createProductService;
  //private final AfterProcessFilter afterProcessFilter;
  private final Environment env;
  private final ErrorProperties errorProperties;

  @InitBinder
  public void initBinder(DataBinder dataBinder) {
    dataBinder.setDisallowedFields();
  }

  /**
   * Crea un nuevo producto.
   *
   * @param apiHeader the header of the request
   * @param createProductRequest the request to create a product
   * @param serverWebExchange the server web exchange
   * @return the completable
   */

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  /*@Operation(tags = "CreateProductResponse",
      summary = "Se cre&oacute; un nuevo producto correctamente",
      method = "POST",
      description = "classpath:swagger/notes/create-product.md",
      responses = {
          @ApiResponse(responseCode = "201",
              description = "El producto fue creado correctamente",
              content = @Content(schema = @Schema(implementation = CreateProductResponse.class))),
          @ApiResponse(responseCode = "400",
              description = "La solicitud es incorrecta",
              content = @Content(schema = @Schema(implementation = ApiException.class))),
          @ApiResponse(responseCode = "401",
              description = "No autorizado",
              content = @Content(schema = @Schema(implementation = ApiException.class))),
          @ApiResponse(responseCode = "403",
              description = "Prohibido",
              content = @Content(schema = @Schema(implementation = ApiException.class))),
          @ApiResponse(responseCode = "500",
              description = "Error interno del servidor",
              content = @Content(schema = @Schema(implementation = ApiException.class))),
          @ApiResponse(responseCode = "503",
              description = "Servicio no disponible",
              content = @Content(schema = @Schema(implementation = ApiException.class))) })*/
  @ResponseStatus(HttpStatus.CREATED)
  public Completable createProduct(
      @ParameterObject
      @RequestHeaderObject ApiHeader apiHeader,
      @RequestBody CreateProductRequest createProductRequest,
      ServerWebExchange serverWebExchange) {
    return createProductService.process(apiHeader, createProductRequest)
        .doOnTerminate(() -> log.info("CreateProductController.createProduct - Terminated"))
        .doOnError(error -> log.error("CreateProductController.createProduct - Error: " + error))
        .subscribeOn(Schedulers.io());
  }
}
