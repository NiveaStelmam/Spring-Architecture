package io.github.niveastelmam.springarchitecture.assembler.api;


import io.github.niveastelmam.springarchitecture.assembler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired
    @Turbo
    //@Qualifier("motorTurbo")
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){

        var carro = new HondaHRV(motor);
        return carro.ignicao(chave);
    }
}
