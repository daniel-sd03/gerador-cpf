package br.com.sodresoftwares.geradorcpf.service;

import org.springframework.stereotype.Service;

import br.com.sodresoftwares.geradorcpf.model.Usuario;
import br.com.sodresoftwares.geradorcpf.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
private UsuarioRepository usuarioRepository;
	
	public UsuarioService( UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	
	public boolean usuarioExistente(Usuario usuario) {
		if(usuarioRepository.existByLogin(usuario.getLogin())) {
			return false;
		}
		return true;
	}
	
	public void salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
