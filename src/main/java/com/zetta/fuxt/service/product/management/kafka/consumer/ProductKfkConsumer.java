package com.zetta.fuxt.service.product.management.kafka.consumer;

import com.zetta.fuxt.service.product.management.business.ProductManagementService;
import com.zetta.fuxt.service.product.management.model.api.createproduct.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * <p> Kafka consumer para el topic de productos.</p>
 * <p> Este consumer consume un mensaje del topic de productos y
 * crea un producto en la base de datos no-sql.</p>
 * <p><b>Class</b>: ProductKfkConsumer</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.kafka.consumer</p>
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
public class ProductKfkConsumer {

  private final ProductManagementService productManagementService;

  /**
   * Consume a message from the product topic and create a product in the no-sql database.
   *
   * @param request the request to create a product
   */
  @KafkaListener(topics = "product", groupId = "product")
  public void consume(CreateProductRequest request) {
    productManagementService.createProductNoSql(request)
        .doOnSuccess(result -> log.info("Product created successfully - NOSQL"))
        .doOnError(error -> log.error("Error while creating product no-sql: " + error))
        .map(result -> "Product created successfully - NOSQL")
        .subscribe();
    log.info("Consumed message: ");
  }
}
