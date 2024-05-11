package com.zetta.fuxt.service.product.management.business.impl;

import com.zetta.fuxt.service.product.management.business.CreateProductService;
import com.zetta.fuxt.service.product.management.business.ProductManagementService;
import com.zetta.fuxt.service.product.management.model.api.createproduct.CreateProductRequest;
import com.zetta.fuxt.service.product.management.model.header.ApiHeader;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p> Clase que implementa la interfaz CreateProductService.</p>
 * <p> Esta clase se encarga de gestionar la creación de productos.</p>
 * <p><b>Class</b>: CreateProductServiceImpl</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.business.impl</p>
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
@Service
@Slf4j
@RequiredArgsConstructor
public class CreateProductServiceImpl implements CreateProductService {

  private final ProductManagementService productManagementService;

  /**
   * M&eacute;todo que permite la creaci&oacute;n de un producto.
   *
   * @param header Informaci&oacute;n del header.
   * @param request Informaci&oacute;n del producto a crear.
   * @return Completable
   */
  @Override
  public Completable process(ApiHeader header, CreateProductRequest request) {
    log.info("CreateProductServiceImpl.process");
    return productManagementService.createProductSql(request)
        .flatMapCompletable(response -> Completable.complete());
  }

}
