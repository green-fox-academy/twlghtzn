package com.twlghtzn.workshop.repositories;

import com.twlghtzn.workshop.models.Year;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends CrudRepository<Year, Long> {

  List<Year> findAll();

  Year findYearByYear(int year);
}
