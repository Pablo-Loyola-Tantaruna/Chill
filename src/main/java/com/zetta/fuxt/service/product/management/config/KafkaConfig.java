package com.zetta.fuxt.service.product.management.config;

import com.zetta.fuxt.service.product.management.model.api.createproduct.CreateProductRequest;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;


/**
 * <p> Configuración de Kafka para enviar y recibir mensajes.</p>
 * <p><b>Class</b>: KafkaConfig</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.config</p>
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
@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

  private final ApplicationProperties applicationProperties;

  /**
   * Configuración de Kafka para enviar mensajes.
   *
   * @return KafkaTemplate
   */
  @Bean
  public KafkaTemplate<String, CreateProductRequest> kafkaTemplate() {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
            applicationProperties.getProducersBootstrapServers());
    configProps.put(ProducerConfig.CLIENT_ID_CONFIG,
            applicationProperties.getProducersClientId());
    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    ProducerFactory<String, CreateProductRequest> producerFactory =
            new DefaultKafkaProducerFactory<>(configProps);
    return new KafkaTemplate<>(producerFactory);
  }

  /**
   * Configuración de Kafka para consumir mensajes.
   *
   * @return ConcurrentKafkaListenerContainerFactory
   */
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, CreateProductRequest>
      kafkaListenerContainerFactory() {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
            applicationProperties.getConsumersBootstrapServers());
    configProps.put(ConsumerConfig.GROUP_ID_CONFIG,
            applicationProperties.getConsumersGroupId());
    configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
            StringDeserializer.class);
    configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
            JsonDeserializer.class);
    ConcurrentKafkaListenerContainerFactory<String, CreateProductRequest> factory =
            new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(configProps));
    return factory;
  }

}
