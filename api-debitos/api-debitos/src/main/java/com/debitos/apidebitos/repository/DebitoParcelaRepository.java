package com.debitos.apidebitos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debitos.apidebitos.models.Debito;
import com.debitos.apidebitos.models.DebitoParcela;

public interface DebitoParcelaRepository extends JpaRepository<DebitoParcela, Long>{
	
}
