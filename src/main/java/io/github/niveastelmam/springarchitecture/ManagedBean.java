package io.github.niveastelmam.springarchitecture;

import io.github.niveastelmam.springarchitecture.todolist.TodoEntity;
import io.github.niveastelmam.springarchitecture.todolist.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
// Bean scope types
@Scope(BeanDefinition.SCOPE_SINGLETON) // (default) - does not keep the state
//@Scope("request") // não guarda estado ----> @Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope("session") // single user session - keep the state ----> @Scope(WebApplicationContext.SCOPE_SESSION)
//@Scope("application") // (specific for web) - all users session - keep the state ----> @Scope(WebApplicationContext.SCOPE_APPLICATION)
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
