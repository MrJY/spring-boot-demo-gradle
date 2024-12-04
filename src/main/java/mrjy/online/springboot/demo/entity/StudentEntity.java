package mrjy.online.springboot.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedEntityGraphs(value = {
    @NamedEntityGraph(name = StudentEntity.GRAPH_ALL,
        attributeNodes = {
            @NamedAttributeNode(value = "user")
        }
    )
})
@Getter
@Setter
@Entity
@Table(name = "student", schema = "jpa-demo")
public class StudentEntity extends BaseEntity {
    public static final String GRAPH_ALL = "StudentEntity.all";

    @Column(name = "student_no", length = 64, insertable = false, updatable = false)
    private String studentNo;

    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "age")
    private Integer age;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_no",referencedColumnName = "username")
    private UserEntity user;

}