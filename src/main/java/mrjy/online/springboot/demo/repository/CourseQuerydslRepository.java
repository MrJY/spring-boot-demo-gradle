package mrjy.online.springboot.demo.repository;
import mrjy.online.springboot.demo.entity.CourseEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseQuerydslRepository
        extends PagingAndSortingRepository<CourseEntity, Long>,
        QuerydslPredicateExecutor<CourseEntity> {

    CourseEntity findByCourseName(String courseName);

}
