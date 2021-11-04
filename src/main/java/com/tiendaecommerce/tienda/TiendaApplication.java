package com.tiendaecommerce.tienda;

import com.tiendaecommerce.tienda.models.Product;
import com.tiendaecommerce.tienda.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductRepository productRepository){
		return(args) -> {
			Product samsungs20 = productRepository.save(
					new Product(
							"Samsung S20","Dispositivo móvil de Tienda e-commerce","https://images.samsung.com/is/image/samsung/assets/ar/s20-buy/S20-FE_Navy_SKUimage_MO-img.jpg",1,100000
					)
			);

			Product iphone12 = productRepository.save(
					new Product(
							"Iphone 12","Dispositivo móvil de Tienda e-commerce","https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-12-family-select-2021?wid=940&hei=1112&fmt=jpeg&qlt=80&.v=1617135051000",1,150000
					)
			);

			Product redminote10pro = productRepository.save(
					new Product(
							"Xiaomi Redmi Note 10","Dispositivo móvil de Tienda e-commerce","https://buytek.net/wp-content/uploads/2021/07/NOTE-10-PRO.2.jpg",1,90000
					)
			);
		};
	}
}
