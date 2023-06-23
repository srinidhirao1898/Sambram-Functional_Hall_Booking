package com.webapp.sambram.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.webapp.sambram.Entities.HallPrice;

public interface HallPriceRepository extends CrudRepository<HallPrice, Integer> {
	
	@Query(value = "SELECT price_per_day from hall_price where hall_id = ?1 AND ac_nonac = ?2",nativeQuery = true)
	int getAmount(int hall_id,String AcNonac);

}
