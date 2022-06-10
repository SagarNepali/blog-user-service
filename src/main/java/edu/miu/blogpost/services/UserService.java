package edu.miu.blogpost.services;

import edu.miu.blogpost.dao.IUserDao;
import edu.miu.blogpost.domain.User;
import edu.miu.blogpost.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserDao iUserDao;

    public List<User> getAll(){
        return iUserDao.findAll();
    }

    public Optional<User> get(Long id){
        return iUserDao.findById(id);
    }

    public User add(User user){
        return iUserDao.save(user);
    }

    public void delete(Long id){
        iUserDao.deleteById(id);
    }

    public User update(User user, Long id){
        User userFound = iUserDao.findById(id).get();
        if(userFound != null){
            userFound = user;
            userFound.setId(id);
            iUserDao.save(userFound);
        }
        return iUserDao.save(user);
    }
}
