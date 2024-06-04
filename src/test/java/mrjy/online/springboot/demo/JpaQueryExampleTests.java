package mrjy.online.springboot.demo;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import mrjy.online.springboot.demo.entity.UserEntity;
import mrjy.online.springboot.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
