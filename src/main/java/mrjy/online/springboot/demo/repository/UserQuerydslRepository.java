package mrjy.online.springboot.demo.repository;
import mrjy.online.springboot.demo.entity.UserEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuerydslRepository
        extends PagingAndSortingRepository<UserEntity, Long>,
        QuerydslPredicateExecutor<UserEntity> {

}
