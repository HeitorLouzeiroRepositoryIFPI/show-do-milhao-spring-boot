package br.com.heitorlouzeiro.show_do_milhao.repositorio;

import org.springframework.stereotype.Repository;

import br.com.heitorlouzeiro.show_do_milhao.models.Usuario;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface Repositorio extends CrudRepository<Usuario, Integer>{

    List<Usuario> findAll();
}