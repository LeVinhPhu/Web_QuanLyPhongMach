package com.vpdq.pojo;

import com.vpdq.pojo.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-30T17:19:36")
@StaticMetamodel(Position.class)
public class Position_ { 

    public static volatile SingularAttribute<Position, String> name;
    public static volatile CollectionAttribute<Position, Employee> employeeCollection;
    public static volatile SingularAttribute<Position, Integer> id;

}