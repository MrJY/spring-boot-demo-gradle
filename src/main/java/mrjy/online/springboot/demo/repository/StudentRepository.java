package mrjy.online.springboot.demo.repository;

import graphql.com.google.common.collect.Lists;
import mrjy.online.springboot.demo.entity.QStudentEntity;
import mrjy.online.springboot.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<StudentEntity, Long> ,
        QuerydslPredicateExecutor<StudentEntity>,
        QueryByExampleExecutor<StudentEntity> {

    @Override
    @EntityGraph(value = StudentEntity.GRAPH_ALL)
    Iterable<StudentEntity> findAll();

    default List<StudentEntity> findByName(String name){
        QStudentEntity qStudentEntity = QStudentEntity.studentEntity;
        Iterable<StudentEntity> studentEntities = findAll(qStudentEntity.name.eq(name));
        return Lists.newArrayList(studentEntities);
    }

    Iterable<StudentEntity> findByStudentNo(String studentNo);
}
