package edu.miu.blogpost.controller;

import edu.miu.blogpost.domain.User;
import edu.miu.blogpost.dto.UserDTO;
import edu.miu.blogpost.services.UserService;
import edu.miu.blogpost.util.UserAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping( produces = "application/json")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<UserDTO> userDTOList = userService.getAll().stream().map(user -> {
          return UserAdapter.userToUserDto(user);
        }).collect(Collectors.toList());

        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @GetMapping(value="/{id}", produces = "application/json")
    public ResponseEntity<?> get(@PathVariable Long id){
        Optional<User> userFound = userService.get(id);
        if(userFound.isPresent()){
            return new ResponseEntity<UserDTO>(UserAdapter.userToUserDto(userFound.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found with the provided ID: " + id, HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<?> add(@RequestBody UserDTO userDTO){
        User newUser = UserAdapter.userDtoToUser(userDTO);
        UserDTO createdUserDTO = UserAdapter.userToUserDto(userService.add(newUser));

        return new ResponseEntity<>(createdUserDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO, @PathVariable Long id){
        User newUser = UserAdapter.userDtoToUser(userDTO);
        userService.update(newUser, id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}
