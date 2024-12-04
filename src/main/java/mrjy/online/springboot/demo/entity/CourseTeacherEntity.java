package mrjy.online.springboot.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "course_teacher", schema = "jpa-demo")
public class CourseTeacherEntity extends BaseEntity{

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "teacher_code")
    private String teacherCode;

}