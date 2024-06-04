package mrjy.online.springboot.demo.repository;
import mrjy.online.springboot.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends PagingAndSortingRepository<UserEntity, Long> ,
        QueryByExampleExecutor<UserEntity> {


    UserEntity findByUsername(String username);

    /**
     * 参数两种写法
     * ?1
     * :username + @Param("username")
     */
    @Query("select u from UserEntity u where u.username = ?1")
    UserEntity findByUsernameJqlSimple(String username);

    @Query("select u from UserEntity u where u.username = :username ")
    UserEntity findByUsernameJql(@Param("username") String username);

    /**
     * 增删改必须加事务注解和@Modifying
     */
    @Modifying
    @Query("update UserEntity u set u.password = :password where u.username = :username")
    int updateByUsernameJql(@Param("username") String username, @Param("password") String password);

}
