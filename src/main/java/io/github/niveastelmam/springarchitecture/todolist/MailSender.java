package io.github.niveastelmam.springarchitecture.todolist;

import org.springframework.stereotype.Component;

@Component
public class MailSender {
    public void send(String msg){
        System.out.println("Enviado email " + msg);
    }
}
