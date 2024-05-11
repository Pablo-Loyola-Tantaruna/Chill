package com.zetta.fuxt.service.product.management.business.impl;


import com.zetta.fuxt.service.product.management.business.ProductManagementService;
import com.zetta.fuxt.service.product.management.clients.DbClient;
import com.zetta.fuxt.service.product.management.kafka.producer.ProductKfkProducer;
import com.zetta.fuxt.service.product.management.model.api.createproduct.CreateProductRequest;
import com.zetta.fuxt.service.product.management.util.queries.UtilQueryGenerator;
import io.r2dbc.spi.Result;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Service;

/**
 * <p> Clase que implementa la interfaz ProductManagementService.</p>
 * <p> Esta clase se encarga de gestionar la creación de productos.</p>
 * <p><b>Class</b>: ProductManagementServiceImpl</p>
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
public class ProductManagementServiceImpl implements ProductManagementService {

  private final DbClient<Result, String> dbClientSql;
  private final DbClient<Document, Object> dbClientNoSql;

  private UtilQueryGenerator queryGenerator;

  private final ProductKfkProducer productKfkProducer;

  /**
   * M&eacute;todo que permite la creaci&oacute;n de un producto.
   *
   * @param request Informaci&oacute;n del producto a crear.
   * @return String
   */
  @Override
  public Single<String> createProductSql(CreateProductRequest request) {
    log.info("ProductManagementServiceImpl.createProduct - SQL");
    return dbClientSql.execute(queryGenerator.insertQueryGenerator(request))
        .doOnSuccess(result -> productKfkProducer.sendProduct(request)
            .doOnError(error -> log.error("Error saving data to no-sql: " + error))
            .doOnComplete(() -> log.info("Data saved to"))
            .subscribe())
        .doOnError(error -> log.error("Error while creating product sql: " + error))
        .map(result -> "Product created successfully - SQL");
  }

  /**
   * M&eacute;todo que permite la creaci&oacute;n de un producto.
   *
   * @param request Informaci&oacute;n del producto a crear.
   * @return String
   */
  @Override
  public Single<String> createProductNoSql(CreateProductRequest request) {
    log.info("ProductManagementServiceImpl.createProduct - NOSQL");
    return dbClientNoSql.execute(request)
        .doOnSuccess(result -> log.info("Product created successfully - NOSQL"))
        .doOnError(error -> log.error("Error while creating product no-sql: " + error))
        .map(result -> "Product created successfully - NOSQL");
  }

  @Override
  public Completable deleteProductNoSql(String idProduct) {
    return null;
//    return dbClientNoSql.execute(idProduct)
//        .doOnSuccess(result -> log.info("Product deleted successfully"))
//        .doOnComplete();
//        .doOnError(error -> log.error("Error while deleting product: " + error));
  }

  @Override
  public Completable deleteProductSql(String idProduct) {
    //TODO: Implementar la eliminación de un producto en la base de datos SQL.
    return null;
//    log.info("ProductManagementServiceImpl.deleteProduct");
//    return dbClientSql.execute(queryGenerator.deleteQueryGenerator(idProduct))
//        .doOnComplete(() -> log.info("Product deleted successfully"))
//        .doOnError(error -> log.error("Error while deleting product: " + error));
  }
}
