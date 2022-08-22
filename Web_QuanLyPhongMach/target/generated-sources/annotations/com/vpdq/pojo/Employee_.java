package com.vpdq.pojo;

import com.vpdq.pojo.Degree;
import com.vpdq.pojo.MedicalRecord;
import com.vpdq.pojo.OnCall;
import com.vpdq.pojo.Position;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-22T08:25:31")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> lastName;
    public static volatile SingularAttribute<Employee, String> image;
    public static volatile SingularAttribute<Employee, String> note;
    public static volatile SingularAttribute<Employee, String> address;
    public static volatile SingularAttribute<Employee, String> sex;
    public static volatile SingularAttribute<Employee, Date> dateOfBirth;
    public static volatile CollectionAttribute<Employee, MedicalRecord> medicalRecordCollection;
    public static volatile SingularAttribute<Employee, String> firstName;
    public static volatile SingularAttribute<Employee, String> password;
    public static volatile CollectionAttribute<Employee, Degree> degreeCollection;
    public static volatile SingularAttribute<Employee, Position> positionId;
    public static volatile SingularAttribute<Employee, String> phone;
    public static volatile CollectionAttribute<Employee, MedicalRecord> medicalRecordCollection1;
    public static volatile CollectionAttribute<Employee, OnCall> onCallCollection;
    public static volatile SingularAttribute<Employee, Integer> id;
    public static volatile SingularAttribute<Employee, String> email;
    public static volatile SingularAttribute<Employee, String> specialize;
    public static volatile SingularAttribute<Employee, String> username;

}