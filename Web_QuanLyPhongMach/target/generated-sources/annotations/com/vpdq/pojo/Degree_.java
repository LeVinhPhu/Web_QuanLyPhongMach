package com.vpdq.pojo;

import com.vpdq.pojo.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-21T13:36:36")
@StaticMetamodel(Degree.class)
public class Degree_ { 

    public static volatile SingularAttribute<Degree, String> date;
    public static volatile SingularAttribute<Degree, String> note;
    public static volatile SingularAttribute<Degree, String> name;
    public static volatile SingularAttribute<Degree, Employee> employeeId;
    public static volatile SingularAttribute<Degree, Integer> id;

}