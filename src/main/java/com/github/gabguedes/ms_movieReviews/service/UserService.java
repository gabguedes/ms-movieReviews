package com.github.gabguedes.ms_movieReviews.service;

import com.github.gabguedes.ms_movieReviews.DTO.UserDTO;
import com.github.gabguedes.ms_movieReviews.model.User;
import com.github.gabguedes.ms_movieReviews.repository.UserRepository;
import com.github.gabguedes.ms_movieReviews.service.exception.DatabaseException;
import com.github.gabguedes.ms_movieReviews.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User user = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado: " + id)
        );
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO insert(UserDTO dto){
        User user = new User();
        copyDtoToEntity(dto, user);
        user = repository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto){
        try {
            User user = repository.getReferenceById(id);
            copyDtoToEntity(dto, user);
            user = repository.save(user);
            return new UserDTO(user);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado: " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encotrado: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new DatabaseException("Falha na integridade referencial.");
        }
    }

    private void copyDtoToEntity(UserDTO dto, User user) {
       user.setName(dto.getName());
       user.setEmail(dto.getEmail());
       user.setPassword(dto.getPassword());
    }
}
