package io.github.niveastelmam.springarchitecture.todolist;


import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validate(TodoEntity todo){
        if(thisDescriptionExists(todo.getDescription())){
            throw new IllegalArgumentException("Já existe um ToDo com essa descrição");
        }
    }

    private boolean thisDescriptionExists(String description){
        return repository.existsByDescription(description);
    }
}
