package com.vpdq.pojo;

import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Status;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-21T19:06:19")
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SingularAttribute<Appointment, Date> date;
    public static volatile SingularAttribute<Appointment, String> note;
    public static volatile SingularAttribute<Appointment, Status> statusId;
    public static volatile SingularAttribute<Appointment, Customer> customerId;
    public static volatile SingularAttribute<Appointment, Integer> id;
    public static volatile SingularAttribute<Appointment, String> time;

}