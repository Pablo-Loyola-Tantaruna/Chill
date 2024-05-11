package com.zetta.fuxt.service.product.management.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <p> Application properties configuration.</p>
 * <p><b>Class</b>: ApplicationProperties</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.config.ApplicationProperties</p>
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
@Configuration
@ConfigurationProperties
public class ApplicationProperties {

  @Value("${spring.application.databases.mongo.authentication-database}")
  private String mongoAuthenticationDatabase;

  @Value("${spring.application.databases.mongo.password}")
  private String mongoPassword;

  @Value("${spring.application.databases.mongo.database}")
  private String mongoDatabase;

  @Value("${spring.application.databases.mongo.user}")
  private String mongoUser;

  @Value("${spring.application.databases.mongo.host}")
  private String mongoHost;

  @Value("${spring.application.databases.mongo.port}")
  private int mongoPort;

  @Value("${spring.application.databases.mongo.collection}")
  private String mongoCollection;

  @Value("${spring.application.databases.postgres.host}")
  private String hostPostgres;

  @Value("${spring.application.databases.postgres.port}")
  private int portPostgres;

  @Value("${spring.application.databases.postgres.database}")
  private String databasePostgres;

  @Value("${spring.application.databases.postgres.username}")
  private String usernamePostgres;

  @Value("${spring.application.databases.postgres.password}")
  private String passwordPostgres;

  @Value("${event.kafka.producers.bootstrap.servers}")
  private String producersBootstrapServers;

  @Value("${event.kafka.consumers.bootstrap.servers}")
  private String consumersBootstrapServers;

  @Value("${event.kafka.producers.client-id}")
  private String producersClientId;

  @Value("${event.kafka.consumers.group-id}")
  private String consumersGroupId;
}
