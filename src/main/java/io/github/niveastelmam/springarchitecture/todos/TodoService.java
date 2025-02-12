package io.github.niveastelmam.springarchitecture.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;

    public TodoService(TodoRepository todoRepository){
        this.repository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity newTodo){ // Obs: if you have ID, update it
        return repository.save(newTodo);
    }

    public void atualizarStatus(TodoEntity todo){ // Obs: if you DON´T have ID, save
        repository.save(todo);
    }

    public TodoEntity buscarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }
}
