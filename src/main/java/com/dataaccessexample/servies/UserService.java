package com.dataaccessexample.servies;

import com.dataaccessexample.entity.User;
import com.dataaccessexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional  //Transaction management is handled by the @Transactional annotation
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    
//    @Transactional
//    public Optional<User> getUserById(Long id) {
//        return UserRepository.findById(id);
//    }

    
  
 //Paging and Sorting
    public Page<User> getUsersWithPagingAndSorting(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return userRepository.findAll(pageable);
    }

}
