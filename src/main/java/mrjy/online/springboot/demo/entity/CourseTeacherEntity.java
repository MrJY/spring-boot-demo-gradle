package mrjy.online.springboot.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "course_teacher", schema = "jpa-demo")
public class CourseTeacherEntity extends BaseEntity{
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "teacher_code")
    private String teacherCode;

}