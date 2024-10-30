package com.patasSolidarias.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.patasSolidarias.api.data.Resposta;
import com.patasSolidarias.api.data.UserResposta;
import com.patasSolidarias.api.data.UserRespostaError;
import com.patasSolidarias.api.models.User;
import com.patasSolidarias.api.repositories.UserRepository;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public ResponseEntity<Resposta> login(User usuario) {
		try {
			Optional<User> userDetails = repository.findByEmail(usuario.getEmail());

			// Verifica se o usuário existe
			if (!userDetails.isPresent()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
						.body(new UserRespostaError("Email ou senha inválidos."));
			}

			// Verifica se a senha está correta
			if (passwordEncoder.matches(usuario.getSenha(), userDetails.get().getSenha())) {
				// Autentica o usuário
				authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha()));
				// Retorna a resposta com sucesso
				return ResponseEntity.ok(new UserResposta("Login bem-sucedido!", userDetails.get()));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
						.body(new UserRespostaError("Email ou senha inválidos."));
			}

		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new UserRespostaError("Email ou senha inválidos."));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new UserRespostaError("Ocorreu um erro inesperado: " + e.getMessage()));
		}
	}

}
