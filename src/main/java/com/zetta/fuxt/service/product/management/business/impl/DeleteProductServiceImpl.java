package com.zetta.fuxt.service.product.management.business.impl;

import com.zetta.fuxt.service.product.management.business.DeleteProductService;
import com.zetta.fuxt.service.product.management.model.api.deleteproduct.DeleteProductRequest;
import com.zetta.fuxt.service.product.management.model.header.ApiHeader;
import io.reactivex.rxjava3.core.Completable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteProductServiceImpl implements DeleteProductService {
  
  /**
   * M&eacute;todo que permite la eliminaci&oacute;n l&oacute;gica de un producto.
   *
   * @param header Informaci&oacute;n del header.
   * @param request Informaci&oacute;n del producto a eliminar.
   * @return Completable
   */
  @Override
  public Completable process(ApiHeader header, DeleteProductRequest request) {
    return null;
  }
}
