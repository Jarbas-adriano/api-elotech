package com.debitos.apidebitos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.debitos.apidebitos.models.Debito;

public interface DebitoRepository extends JpaRepository<Debito, Long>{
	
	Debito findById(long id);
  
	@Query("select sum(valor) from DebitoParcela")
	Double sumValues();
	
}
