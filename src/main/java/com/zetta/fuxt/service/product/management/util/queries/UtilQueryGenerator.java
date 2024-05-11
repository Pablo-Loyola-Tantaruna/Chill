package com.zetta.fuxt.service.product.management.util.queries;

import static com.zetta.fuxt.service.product.management.util.constants.Constants.COMMA_SPACE;
import static com.zetta.fuxt.service.product.management.util.constants.Constants.QUESTION_MARK;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.lang.reflect.Field;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;


/**
 * <p> Esta clase es una clase utilitaria que contiene el generador de consultas.</p>
 * <p> Esta clase es utilizada para generar consultas.</p>
 * <p> Esta clase contiene los métodos para generar consultas.</p>
 * <p><b>Class</b>: UtilQueryGenerator</p>
 * <p><b>Package</b>: com.zetta.fuxt.service.product.management.util.queries</p>
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
@Slf4j
public class UtilQueryGenerator {

  /**
   * Method to generate an SQL query from an object.
   *
   * @param object Object to generate the query
   * @return SQL query
   */
  public String insertQueryGenerator(Object object) {

    String tableName = object.getClass().getSimpleName();

    StringBuilder columns = new StringBuilder();
    StringBuilder values = new StringBuilder();
    Field[] fields = object.getClass().getDeclaredFields();
    for (int i = 0; i < fields.length; i++) {
      fields[i].setAccessible(true);
      try {
        Object value = fields[i].get(object);
        if (value != null) {
          if (i > 0) {
            columns.append(COMMA_SPACE);
            values.append(COMMA_SPACE);
          }
          columns.append(fields[i].getName());
          values.append(QUESTION_MARK);
        }
      } catch (IllegalAccessException e) {
        log.error("Error al obtener el valor del campo", e);
      }
    }
    return "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
  }

  /**
   * Method to convert an SQL query to a BSON document for MongoDB.
   *
   * @param sql SQL query
   * @return BSON document
   */
  public Document convertSqlToBson(String sql) {
    String[] components = sql.split(SPACE);

    if (components.length == 11 && components[0].equalsIgnoreCase("select")
        && components[1].equals("*")
        && components[2].equalsIgnoreCase("from")
        && components[4].equalsIgnoreCase("where")
        && components[6].equalsIgnoreCase("and")
        && components[10].endsWith(";")) {
      String value1 = components[5];
      String value2 = components[9].substring(0, components[9].length() - 1);

      Document query = new Document(components[3], value1).append(components[7], value2);

      return query;
    } else {
      throw new UnsupportedOperationException("Complex SQL to BSON conversion is not supported");
    }
  }
}
