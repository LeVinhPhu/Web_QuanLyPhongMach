package com.vpdq.pojo;

import com.vpdq.pojo.Admin;
import com.vpdq.pojo.Department;
import com.vpdq.pojo.Employee;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-30T14:31:05")
@StaticMetamodel(OnCall.class)
public class OnCall_ { 

    public static volatile SingularAttribute<OnCall, Date> date;
    public static volatile SingularAttribute<OnCall, String> note;
    public static volatile SingularAttribute<OnCall, Department> departmentId;
    public static volatile SingularAttribute<OnCall, Admin> adminId;
    public static volatile SingularAttribute<OnCall, Employee> employeeId;
    public static volatile SingularAttribute<OnCall, Integer> id;

}