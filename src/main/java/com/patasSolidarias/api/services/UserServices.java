package com.patasSolidarias.api.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.patasSolidarias.api.data.Resposta;
import com.patasSolidarias.api.data.UserResposta;
import com.patasSolidarias.api.data.UserRespostaError;
import com.patasSolidarias.api.data.DTO.UserDTO;
import com.patasSolidarias.api.models.User;
import com.patasSolidarias.api.repositories.UserRepository;

@Service
public class UserServices implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public List<UserDTO> listarUsuarios() {
		var users = repository.findAll();
		var userDtos = users.stream()
				.map(user -> {
					UserDTO userdto = new UserDTO(user);
					return userdto;
		}).collect(Collectors.toList());
		return userDtos;
        
    }

	public ResponseEntity<Resposta> criarUsuario(User usuario) {
	    Optional<User> user = repository.findByEmail(usuario.getEmail());

	    if (user.isPresent()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserRespostaError( "Email já cadastrado"));
	    } else {
	    	usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
	        User savedUser = repository.save(usuario);
	        return ResponseEntity.ok(new UserResposta("Ok usuario cadastrado com sucesso", savedUser));
	    }
	}
	 
	 public User buscarUsuario( String id) {
	        return repository.findById(id).orElse(null);
	    }

	public void deletarUsuario(String id) {
		 repository.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		  Optional<User> user = repository.findByEmail(email);

	        if (user.isEmpty()) {
	            throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
	        }

	        return new org.springframework.security.core.userdetails.User(
	                user.get().getEmail(),
	                user.get().getSenha(),
	                getAuthorities(user.get())
	        );

	}
	
	 private Collection<? extends GrantedAuthority> getAuthorities(User user) {
	        return user.getRoles().stream()
	                .map(SimpleGrantedAuthority::new)
	                .collect(Collectors.toList());
	    }

	public ResponseEntity<Resposta> editarUsuario(User usuario) {
		  Optional<User> user = repository.findById(usuario.getId());
		 if (user.isPresent()) {
			 var userEdit = user.get();
			 userEdit.setNome(usuario.getNome());
			 userEdit.setSobre(usuario.getSobre());
			 userEdit.setTelefone(usuario.getTelefone());
			 userEdit.setCidade(usuario.getCidade());
			 userEdit.setFoto(usuario.getFoto());
		     User savedUser = repository.save(userEdit);
		       return ResponseEntity.ok(new UserResposta("Ok editado cadastrado com sucesso", savedUser));
		 }
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new UserRespostaError( "Ocorreu um erro ao salvar perfil"));
	}
}
