package io.github.niveastelmam.springarchitecture.todolist;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidator validator, MailSender mailSender ){
        this.repository = todoRepository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity save(TodoEntity newTodo){ // Obs: if you have ID, update it
        validator.validate(newTodo);
        return repository.save(newTodo);
    }

    public void updateStatus(TodoEntity todo){ // Obs: if you DON´T have ID, save

        repository.save(todo);
        String status = todo.getCompleted() == Boolean.TRUE ? "Concluído" : "Não concluído";
        mailSender.send("ToDo " + todo.getDescription() + " foi atualizado para " + status);
    }

    public TodoEntity searchById(Integer id){
        return repository.findById(id).orElse(null);
    }
}
