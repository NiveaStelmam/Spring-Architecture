package io.github.niveastelmam.springarchitecture.todolist;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
       try{
           return this.service.save(todo);
       }catch (IllegalArgumentException e){
           var mensagemErro = e.getMessage();
           throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
       }

    }

    @PutMapping("{id}")
    public void updateStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo ){

        todo.setId(id);
        service.updateStatus(todo);
    }

    @GetMapping("{id}")
    public TodoEntity search(@PathVariable("id") Integer id){
        return service.searchById(id);
    }
}
