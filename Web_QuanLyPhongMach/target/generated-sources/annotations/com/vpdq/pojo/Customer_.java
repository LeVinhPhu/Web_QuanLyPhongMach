package com.vpdq.pojo;

import com.vpdq.pojo.Appointment;
import com.vpdq.pojo.MedicalRecord;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-21T13:36:36")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile SingularAttribute<Customer, String> image;
    public static volatile SingularAttribute<Customer, String> note;
    public static volatile SingularAttribute<Customer, String> address;
    public static volatile SingularAttribute<Customer, String> sex;
    public static volatile SingularAttribute<Customer, Date> dateOfBirth;
    public static volatile SetAttribute<Customer, MedicalRecord> medicalRecordSet;
    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile SetAttribute<Customer, Appointment> appointmentSet;
    public static volatile SingularAttribute<Customer, String> password;
    public static volatile SingularAttribute<Customer, String> phoneNumber;
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, String> email;

}