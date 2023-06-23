package com.webapp.sambram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.webapp.sambram.Entities.Bookings;
import com.webapp.sambram.Entities.BookingsId;

public interface BookingsRepository extends CrudRepository<Bookings, BookingsId>{
	
	@Query(value = "SELECT hall_name from function_hall where hall_id = ?1", nativeQuery = true)
	String getHallName(int hall_id);
	
	@Query(value = "SELECT _fh.hall_name, _bk.user_mail, _bk.ac_nonac, _bk.from_date, _bk.to_date,"
			+ "_bk.advance_paid, _bk.amount_to_be_paid from bookings as _bk left outer join function_hall as _fh "
			+ "ON _fh.hall_id = _bk.hall_id WHERE _bk.user_mail = ?;", nativeQuery = true)
	List<Object[]> getBookinsUser(String userMail);
}
