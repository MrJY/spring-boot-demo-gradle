package mrjy.online.springboot.demo.controller;

import mrjy.online.springboot.demo.entity.UserEntity;
import mrjy.online.springboot.demo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UsersController {

    @Resource
    private UserRepository userRepository;

    /**
     * 分页获取用户数据
     */
    @GetMapping("/api/user/page")
    public ResponseEntity<Page<UserEntity>> findUsers() {
        return ResponseEntity.ok(userRepository.findAll(PageRequest.of(0, 2)));
    }

    @GetMapping("/api/user/get")
    @Transactional
    public ResponseEntity<UserEntity> getUser(@RequestParam String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        userEntity.setPassword("123");
        userEntity = userRepository.findByUsername(username);
        return ResponseEntity.ok(userEntity);
    }

}
