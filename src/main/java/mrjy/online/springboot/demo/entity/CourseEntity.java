package mrjy.online.springboot.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@NamedEntityGraphs(value = {
    @NamedEntityGraph(name = CourseEntity.COURSE_GRAPH_ALL,
        attributeNodes = {
            @NamedAttributeNode(value = "courseTeacher")
        }
    )
})
@Getter
@Setter
@Entity
@Table(name = "course", schema = "jpa-demo")
public class CourseEntity extends BaseEntity{
    public static final String COURSE_GRAPH_ALL = "CourseEntity.all";

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_code")
    private String courseCode;

    @OneToMany
    @JoinColumn(name = "course_code", referencedColumnName = "course_code")
    private List<CourseTeacherEntity> courseTeacher;
}