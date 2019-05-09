package com.maquinadebusca.app.model.repository;

import com.maquinadebusca.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lucas Silva
 */
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
