package br.com.guntz.transito.api.controller;

import br.com.guntz.transito.api.domain.model.Usuario;
import br.com.guntz.transito.api.domain.service.TokenService;
import br.com.guntz.transito.api.model.input.UsuarioInputModel;
import br.com.guntz.transito.api.model.output.TokenJWTModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Object> realizarLogin(@Valid @RequestBody UsuarioInputModel usuarioInputModel) {
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(usuarioInputModel.getUsuario(),
                usuarioInputModel.getSenha());

        var autenticacao = authenticationManager.authenticate(autenticacaoToken);
        var tokenJWT = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());

        return ResponseEntity.ok(new TokenJWTModel(tokenJWT));
    }

}
