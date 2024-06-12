package mrjy.online.springboot.demo;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson2.JSONObject;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import mrjy.online.springboot.demo.entity.QUserEntity;
import mrjy.online.springboot.demo.entity.UserEntity;
import mrjy.online.springboot.demo.repository.UserQuerydslRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class JpaQuerydslTests {

    @Resource(type = UserQuerydslRepository.class)
    private UserQuerydslRepository userQuerydslRepository;


	//todo 待测试PersistenceContext和autowired的区别
	@PersistenceContext(unitName = "default")
	private EntityManager entityManager;

    public JPAQueryFactory getQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }


	@Test
	public void findByUsernameTest() {
		QUserEntity qUserEntity = QUserEntity.userEntity;
		BooleanExpression expression = qUserEntity.username.eq("user01");
		Iterable<UserEntity> iterable = userQuerydslRepository.findAll(expression);
		ArrayList<UserEntity> userEntitiesList = CollectionUtil.newArrayList(iterable);
		log.info("userEntitiesList:{}", JSONObject.toJSONString(userEntitiesList));
	}

	@Test
	public void findByUsernameAndPasswordTest() {
		QUserEntity qUserEntity = QUserEntity.userEntity;
		BooleanExpression expression = qUserEntity.username.eq("user01");
		expression = qUserEntity.password.like("%a%").and(expression);

		Iterable<UserEntity> iterable = userQuerydslRepository.findAll(expression);
		ArrayList<UserEntity> userEntitiesList = CollectionUtil.newArrayList(iterable);
		log.info("userEntitiesList:{}", JSONObject.toJSONString(userEntitiesList));
	}

	@Test
	public void getCount() {
		JPAQueryFactory queryFactory = this.getQueryFactory();
		QUserEntity qUserEntity = QUserEntity.userEntity;
		JPAQuery<Tuple> query = queryFactory.select(qUserEntity.id, qUserEntity.username)
				.from(qUserEntity)
				.where(qUserEntity.password.like("%a%"));
		List<Tuple> fetch = query.fetch();

		fetch.forEach(tuple -> {
			String s = tuple.get(qUserEntity.password);
			log.info(s);
		});
	}




}
