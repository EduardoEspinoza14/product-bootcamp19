package com.nttdata.product.bussiness;

import com.nttdata.product.model.mongo.ProductMongo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interface ProductService.
 */
public interface ProductService {

  //OBTENER TODOS LOS PRODUCTOS REGISTRADOS
  Flux<ProductMongo> getProducts();

  //OBTENER TODOS LOS PRODUCTOS QUE TIENE UN CLIENTE EN ESPECIFICO, POR SU ID CLIENTE
  Flux<ProductMongo> getProductsByCustomer(String customerId);

  //OBTENER UN PRODUCTO POR SU ID
  Mono<ProductMongo> getProduct(String id);

  //OBTENER UN PRODUCTO POR SU ID Y ID DEL CLIENTE, VALIDA LA PERTENENCIA
  Mono<ProductMongo> getProductByCustomer(String customerId, String id);

  //PERMITE INSERTAR UN PRODUCTO
  Mono<ProductMongo> insertProduct(ProductMongo product);

  //PERMITE ACTUALIZAR UN PRODUCTO POR SU ID
  Mono<ProductMongo> updateProduct(ProductMongo product, String id);

  //PERMITE ELIMINAR UN PRODUCTO POR SU ID
  Mono<Void> deleteProduct(String id);

}
