package mrjy.online.springboot.demo.jpa;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import mrjy.online.springboot.demo.entity.CourseEntity;
import mrjy.online.springboot.demo.repository.CourseQuerydslRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class JpaCourseQuerydslTests {

    @Resource(type = CourseQuerydslRepository.class)
    private CourseQuerydslRepository courseQuerydslRepository;

	@Test
	@Transactional(readOnly = true)
	public void findByCourseName() {
		CourseEntity courseEntity = courseQuerydslRepository.findByCourseName("1-1");
		System.out.println(JSONObject.toJSONString(courseEntity.getCourseTeacher()));
	}

	@Test
	@Transactional(readOnly = true)
	public void findAll() {
		Iterable<CourseEntity> all = courseQuerydslRepository.findAll();
		System.out.println(CollectionUtil.newArrayList(all));
	}






}
