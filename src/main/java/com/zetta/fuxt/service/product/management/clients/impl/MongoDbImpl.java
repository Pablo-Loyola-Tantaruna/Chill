package com.zetta.fuxt.service.product.management.clients.impl;

import com.google.gson.Gson;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.zetta.fuxt.service.product.management.clients.DbClient;
import com.zetta.fuxt.service.product.management.util.queries.UtilQueryGenerator;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;

/**
 * <p> Implementaci&oacute;n de la interfaz DbClient para la base de datos MongoDb.</p>
 * <p><b>Class</b>: MongoDbImpl</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.clients.impl</p>
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
@RequiredArgsConstructor
@Service
public class MongoDbImpl implements DbClient<Document, Object> {

  private final MongoCollection<Document> mongoCollection;

  /**
   * M&eacute;todo que permite la ejecuci&oacute;n de
   * una consulta en la base de datos MongoDb.
   *
   * @param object Consulta a ejecutar.
   * @return Document
   */
  @Override
  public Single<Document> execute(Object object) {
    return Single.fromPublisher(mongoCollection.find(Document.parse(new Gson().toJson(object))));
  }

}
