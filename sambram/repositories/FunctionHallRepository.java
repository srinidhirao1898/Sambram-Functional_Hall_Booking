package com.webapp.sambram.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.webapp.sambram.Entities.FunctionHall;

public interface FunctionHallRepository extends CrudRepository<FunctionHall, Integer>{
	
	@Query(value = "SELECT max(hall_id) FROM function_hall", nativeQuery = true)
	int findMaxId();
	
	@Query(value = "SELECT _hall.hall_id,_hall.hall_name, concat(concat(concat(concat(_hall.address1,' '), "
			+ "_hall.address2),' '),_hall.area1) as address, _hall.city, _hall.phone1, _hall.phone2,_price.ac_nonac, "
			+ "_price.price_per_day FROM function_hall as _hall LEFT OUTER JOIN bookings as _book on _hall.hall_id = _book.hall_id "
			+ "LEFT OUTER JOIN hall_price as _price on _hall.hall_id = _price.hall_id WHERE _hall.hall_id not in "
			+ "(SELECT hall_id from bookings where (bookings.from_date <= ?1 AND bookings.to_date >= ?2) or"
			+ "(bookings.from_date <= ?1 AND bookings.to_date >= ?1) or (bookings.from_date <= ?2 AND bookings.to_date >= ?2))"
			+ "group by _hall.hall_id,_hall.hall_name,_hall.city, _hall.phone1, _hall.phone2,_price.ac_nonac, _price.price_per_day;",nativeQuery = true)
	List<Object[]> findHallId( Date fromDate, Date toDate);
	

}