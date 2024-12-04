package mrjy.online.springboot.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "teacher")
public class TeacherEntity extends BaseEntity {

    @Column(name = "teacher_no", length = 64)
    private String teacherNo;

    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "age")
    private Integer age;

}