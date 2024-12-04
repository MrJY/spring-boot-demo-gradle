package mrjy.online.springboot.demo.jpa;

import lombok.extern.slf4j.Slf4j;
import mrjy.online.springboot.demo.entity.StudentEntity;
import mrjy.online.springboot.demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
public class MainTests {

    @Resource
    private StudentRepository studentRepository;

    @Test
    public void test() {
        List<StudentEntity> list = studentRepository.findByName("张三");
        System.out.println("");
    }

}
