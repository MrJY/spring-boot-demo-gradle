package mrjy.online.springboot.demo.jpa;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import mrjy.online.springboot.demo.entity.UserEntity;
import mrjy.online.springboot.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
public class JpaCrudTests {

    @Resource(type = UserRepository.class)
    private UserRepository userRepository;

	@Test
	public void saveTest() {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("user01");
		userEntity.setPassword("123456");
		userRepository.save(userEntity);
	}

	@Test
	@Transactional
	@Commit
	public void findByUsernameTest() {
		UserEntity userEntity = userRepository.findByUsername("user01");
		log.info("userEntity:{}", JSONObject.toJSONString(userEntity));
		// 在开启事务后，修改实体类（持久状态）会关联到数据库，修改数据库会关联到实体类？
		// 禁止关联的方法：@Transactional(readOnly = true)
		// 在测试类中，修改实体类（持久状态）不会关联到数据库，添加@Commit/@Rollback会关联到数据库
		userEntity.setPassword("123456");
	}

	@Test
	public void pageTest() {
		Page<UserEntity> page = userRepository.findAll(PageRequest.of(0, 2));
		log.info("page：【{}】", JSONObject.toJSONString(page.get().collect(Collectors.toList())));
		log.info("totalPages：【{}】", page.getTotalPages());
		log.info("totalElements：【{}】", page.getTotalElements());
	}

}
