package com.zetta.fuxt.service.product.management.clients.impl;

import com.zetta.fuxt.service.product.management.clients.DbClient;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.Result;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * <p> Implementaci&oacute;n de la interfaz DbClient para la base de datos Postgres.</p>
 * <p><b>Class</b>: PostGresDbImpl</p>
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
 *   <li>Pablo Sergio Loyola Tantaruna</li>
 *   </ul>
 * </div>
 * <div>
 *   <u>Reviewed by</u>:
 *   <ul>
 *   <li>Pablo Sergio Loyola Tantaruna</li>
 *   </ul>
 * </div>
 * <p><b>Version</b>: 1.0.0</p>
 */
@RequiredArgsConstructor
@Service
public class PostGresDbImpl implements DbClient<Result, String> {

  private final ConnectionFactory connectionFactory;

  /**
   * M&eacute;todo que permite la ejecuci&oacute;n de 
   * una consulta en la base de datos Postgres.
   *
   * @param query Consulta a ejecutar.
   * @return Result
   */

  @Override
  public Single<Result> execute(String query) {
    return Single.fromPublisher(connectionFactory.create())
        .flatMap(connection -> Single.fromPublisher(
            connection.createStatement(query).execute()));
  }

}
