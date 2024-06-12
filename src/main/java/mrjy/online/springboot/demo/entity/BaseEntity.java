package mrjy.online.springboot.demo.entity;

import graphql.com.google.common.base.Throwables;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Cloneable, Serializable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            Throwables.throwIfUnchecked(e);
            throw new AssertionError(e);
        }
    }
}