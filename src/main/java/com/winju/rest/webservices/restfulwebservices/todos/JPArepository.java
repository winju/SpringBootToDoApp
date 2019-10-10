package com.winju.rest.webservices.restfulwebservices.todos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPArepository extends JpaRepository<TodosBean, Long>{
	
	List<TodosBean> findByUsername(String username);
}
