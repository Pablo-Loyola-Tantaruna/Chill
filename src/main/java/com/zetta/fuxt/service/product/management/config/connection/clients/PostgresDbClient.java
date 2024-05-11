package com.zetta.fuxt.service.product.management.config.connection.clients;

import com.zetta.fuxt.service.product.management.config.ApplicationProperties;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <p> Configuración de la conexión a la base de datos Postgres.</p>
 * <p><b>Class</b>: PostgresDbClient</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.config.connection.clients</p>
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
public class PostgresDbClient {

  private final ApplicationProperties applicationProperties;

  /**
   * M&eacute;todo que permite la configuraci&oacute;n
   * de la conexi&oacute;n a la base de datos Postgres.
   *
   * @return ConnectionFactory
   */
  @Bean
  public ConnectionFactory postgresDb() {
    return new PostgresqlConnectionFactory(
        PostgresqlConnectionConfiguration.builder()
            .host(applicationProperties.getHostPostgres())
            .port(applicationProperties.getPortPostgres())
            .database(applicationProperties.getDatabasePostgres())
            .username(applicationProperties.getUsernamePostgres())
            .password(applicationProperties.getPasswordPostgres())
            .build()
    );
  }
}
