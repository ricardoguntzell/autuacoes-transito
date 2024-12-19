package br.com.guntz.transito.api.domain.repository;

import br.com.guntz.transito.api.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByUsuario(String usuario);

    UserDetails findByUsuarioAndAtivo(String usuario, boolean ativo);

}
