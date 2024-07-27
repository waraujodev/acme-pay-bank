package br.com.acmepay.adapters.output.repository;

import br.com.acmepay.adapters.output.entity.CustommerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustommerEntity, Long> {
    CustommerEntity findByDocument(String document);
}
