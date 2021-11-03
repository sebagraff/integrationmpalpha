package com.tiendaecommerce.tienda.repositories;

import com.tiendaecommerce.tienda.models.WebHook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WebHookRepository extends JpaRepository<WebHook, Long> {
}
