package com.zetta.fuxt.service.product.management.config.connection.clients;

import static java.util.Collections.singletonList;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import com.zetta.fuxt.service.product.management.config.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <p> Configuración de la conexión a la base de datos MongoDb.</p>
 * <p><b>Class</b>: MongoDbClient</p>
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
public class MongoDbClient {

  private final ApplicationProperties applicationProperties;

  /**
   * M&eacute;todo que permite la configuraci&oacute;n
   * de la conexi&oacute;n a la base de datos MongoDb.
   *
   * @return MongoCollection Document
   */
  @Bean
  public MongoCollection<Document> mongoClient() {
    MongoCredential credential = MongoCredential.createCredential(
        applicationProperties.getMongoUser(),
        applicationProperties.getMongoAuthenticationDatabase(),
        applicationProperties.getMongoPassword().toCharArray()
    );
    MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
            .applyToClusterSettings(builder -> builder.hosts(singletonList(
                    new ServerAddress(
                            applicationProperties.getMongoHost(),
                            applicationProperties.getMongoPort()))))
            .credential(credential)
            .build());
    MongoDatabase database = mongoClient.getDatabase(applicationProperties.getMongoDatabase());
    return database.getCollection(applicationProperties.getMongoCollection());
  }
}
