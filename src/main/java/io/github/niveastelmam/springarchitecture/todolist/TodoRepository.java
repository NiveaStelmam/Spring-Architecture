package io.github.niveastelmam.springarchitecture.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository <TodoEntity, Integer>{

    // TodoEntity findByDescricao(String descricao); // traz os dados

    boolean existsByDescription(String description);
}
