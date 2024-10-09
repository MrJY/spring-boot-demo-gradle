package mrjy.online.springboot.demo.jpa;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import mrjy.online.springboot.demo.entity.UserEntity;
import mrjy.online.springboot.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
public class JpaQueryExampleTests {

    @Resource(type = UserRepository.class)
    private UserRepository userRepository;

	@Test
	public void findByUsernameOrPasswordTest() {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("user01");
		userEntity.setPassword("123456");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withIgnoreCase()
				.withIgnorePaths("username")
				.withMatcher("password", ExampleMatcher.GenericPropertyMatchers.endsWith())
				//.withMatcher("username", m -> m.endsWith())
				;
		Example<UserEntity> userEntityExample = Example.of(userEntity, exampleMatcher);
		List<UserEntity> userEntities = CollectionUtil.newArrayList(userRepository.findAll(userEntityExample));
		log.info("userEntities:{}", JSONObject.toJSONString(userEntities));
	}

}
