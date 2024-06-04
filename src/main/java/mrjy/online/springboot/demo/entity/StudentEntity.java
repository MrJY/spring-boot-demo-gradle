package mrjy.online.springboot.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "student", schema = "jpa-demo")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "student_no", length = 64)
    private String studentNo;

    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "age")
    private Integer age;

}