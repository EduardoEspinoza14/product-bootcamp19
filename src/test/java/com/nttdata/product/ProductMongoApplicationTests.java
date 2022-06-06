package com.nttdata.product;

import com.nttdata.product.entity.ProductMongo;
import com.nttdata.product.entity.SavingsAccount;
import com.nttdata.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.Date;

@SpringBootTest
class ProductMongoApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
		SavingsAccount product = new SavingsAccount();
		product.setMax_movement_limit(10);
		product.setId(1);
		product.setStart_date(new Date());
		productRepository.save(product).block();
		Flux<SavingsAccount> accountFlux = productRepository.findAllById(1);
		System.out.println(accountFlux);
//		productRepository.save(new ProductMongo())
	}

}
