package mrjy.online.springboot.demo;

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
public class JpaJqlTests {

    @Resource(type = UserRepository.class)
    private UserRepository userRepository;

	@Test
	public void findByUsernameTest() {
		UserEntity userEntity = userRepository.findByUsernameJql("user01");
		log.info("userEntity:{}", JSONObject.toJSONString(userEntity));
	}

	@Test
	@Transactional
	@Commit
	public void updateTest(){
		int i = userRepository.updateByUsernameJql("user01", "123456aaa");
		log.info("修改影响条数:{}", i);
	}


}
