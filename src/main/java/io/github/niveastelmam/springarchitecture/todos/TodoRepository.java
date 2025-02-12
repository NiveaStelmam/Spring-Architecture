package io.github.niveastelmam.springarchitecture.todos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <TodoEntity, Integer>{
}
