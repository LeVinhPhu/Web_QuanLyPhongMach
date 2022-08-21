package com.vpdq.pojo;

import com.vpdq.pojo.Degree;
import com.vpdq.pojo.MedicalRecord;
import com.vpdq.pojo.OnCall;
import com.vpdq.pojo.Position;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-21T13:36:36")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> lastName;
    public static volatile SingularAttribute<Employee, String> image;
    public static volatile SingularAttribute<Employee, String> note;
    public static volatile SingularAttribute<Employee, String> address;
    public static volatile SingularAttribute<Employee, String> sex;
    public static volatile SingularAttribute<Employee, Date> dateOfBirth;
    public static volatile SetAttribute<Employee, Degree> degreeSet;
    public static volatile SetAttribute<Employee, MedicalRecord> medicalRecordSet;
    public static volatile SingularAttribute<Employee, String> firstName;
    public static volatile SingularAttribute<Employee, String> password;
    public static volatile SetAttribute<Employee, MedicalRecord> medicalRecordSet1;
    public static volatile SingularAttribute<Employee, Position> positionId;
    public static volatile SingularAttribute<Employee, String> phone;
    public static volatile SingularAttribute<Employee, Integer> id;
    public static volatile SetAttribute<Employee, OnCall> onCallSet;
    public static volatile SingularAttribute<Employee, String> email;
    public static volatile SingularAttribute<Employee, String> specialize;
    public static volatile SingularAttribute<Employee, String> username;

}