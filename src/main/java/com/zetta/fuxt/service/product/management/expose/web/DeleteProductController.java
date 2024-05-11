package com.zetta.fuxt.service.product.management.expose.web;

import com.zetta.fuxt.service.product.management.business.DeleteProductService;
import com.zetta.fuxt.service.product.management.config.ErrorProperties;
import com.zetta.fuxt.service.product.management.model.api.deleteproduct.DeleteProductRequest;
import com.zetta.fuxt.service.product.management.model.header.ApiHeader;
import com.zetta.fuxt.service.product.management.util.header.manager.RequestHeaderObject;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;

/**
 * <p>Controlador principal que expone la funcionalidad de eliminación lógica de productos
 * a través de Http/rest para las aplicaciones clientes.</p>
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
@Tag(name = "DeleteProduct")
@RequestMapping("/delete-products")
@Slf4j
@RequiredArgsConstructor
public class DeleteProductController {

  private final DeleteProductService deleteProductService;
  private final Environment env;
  private final ErrorProperties errorProperties;

  @InitBinder
  public void initBinder(DataBinder dataBinder) {
    dataBinder.setDisallowedFields();
  }

  @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public Completable deleteProduct(
          @ParameterObject
    @RequestHeaderObject ApiHeader apiHeader,
          @RequestBody DeleteProductRequest deleteProductRequest,
          ServerWebExchange serverWebExchange) {
    return deleteProductService.process(apiHeader, deleteProductRequest)
            .doOnTerminate(() -> log.info("DeleteController.deleteProduct - Terminated"))
            .doOnError(error -> log.error("DeleteController.deleteProduct - Error: " + error))
            .subscribeOn(Schedulers.io());
  }
}
