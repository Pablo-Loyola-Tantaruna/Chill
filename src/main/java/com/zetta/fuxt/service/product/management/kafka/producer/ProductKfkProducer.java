package com.zetta.fuxt.service.product.management.kafka.producer;

import com.zetta.fuxt.service.product.management.model.api.createproduct.CreateProductRequest;
import io.reactivex.rxjava3.core.Completable;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * <p> Clase que implementa la interfaz ProductKfkProducer.</p>
 * <p> Esta clase se encarga de gestionar la creación de productos.</p>
 * <p> Esta clase se encarga de enviar la información del producto a un tópico de Kafka.</p>
 * <p><b>Class</b>: ProductKfkProducer</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.kafka.producer</p>
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
@RequiredArgsConstructor
public class ProductKfkProducer {
  private final KafkaTemplate<String, CreateProductRequest> kafkaProducer;

  /**
   * M&eacute;todo que permite el env&iacute;o de un producto.
   *
   * @param request Informaci&oacute;n del producto a enviar.
   * @return Completable
   */
  public Completable sendProduct(CreateProductRequest request) {
    return Completable.fromAction(() -> kafkaProducer.send("product", request));
  }
}
