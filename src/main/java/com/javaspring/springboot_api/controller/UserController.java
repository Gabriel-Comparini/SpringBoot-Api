package com.javaspring.springboot_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// Não usa put pra esse crud (acho)
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.javaspring.springboot_api.model.User;
import com.javaspring.springboot_api.repository.UserRepository;

@RestController
@RequestMapping("/usuario")
public class UserController {
    private final UserRepository repository;
    public UserController(UserRepository repository) {
        this.repository = repository;
    }
    
    //Criação
    @PostMapping
    public User criar(@RequestBody User user) {
        return repository.save(user);
    }

    //Listagem todos os users
    @GetMapping
    public List<User> listar() {
        return repository.findAll();
    }

    //Listagem user pelo id
    @GetMapping("/{id}")
    public User buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    //Atualização do user
    @PatchMapping("/{id}")
    public User atualizar(@PathVariable Long id, @RequestBody User novoUser) {
        return repository.findById(id).map(user -> {
            user.setNome(novoUser.getNome());
            user.setEmail(novoUser.getEmail());
            user.setSenha(novoUser.getSenha());
            user.setDataNasc(novoUser.getDataNasc());
            user.setPontuacao(novoUser.getPontuacao());
            return repository.save(user);
        }).orElse(null);
    }

    //Deletando o user
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}