package com.twlghtzn.todo.repositories;

import com.twlghtzn.todo.models.Assignee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeRepository
    extends CrudRepository<Assignee, Long> {

}
