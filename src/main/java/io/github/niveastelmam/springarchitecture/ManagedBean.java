package io.github.niveastelmam.springarchitecture;

import io.github.niveastelmam.springarchitecture.todolist.TodoEntity;
import io.github.niveastelmam.springarchitecture.todolist.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagedBean {

    // injection by constructor
    private TodoValidator todoValidator;

    public ManagedBean(TodoValidator todoValidator) {
        this.validator = todoValidator;
    }

    // Injection by property
    @Autowired
    private TodoValidator validator;


    // Injection by set

    @Autowired
    public void setValidator(TodoValidator validator){
        this.validator = validator;
    }


    public void utilizar(){
        var todo = new TodoEntity();
        validator.validate(todo);
    }
}
