package mrjy.online.springboot.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "jpa-demo")
public class UserEntity  extends BaseEntity {

    @Column(name = "username", length = 64)
    private String username;

    @Column(name = "password")
    private String password;

}