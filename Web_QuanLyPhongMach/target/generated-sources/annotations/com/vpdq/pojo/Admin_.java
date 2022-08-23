package com.vpdq.pojo;

import com.vpdq.pojo.Admin;
import com.vpdq.pojo.OnCall;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-24T01:59:02")
@StaticMetamodel(Admin.class)
public class Admin_ { 

    public static volatile SingularAttribute<Admin, String> lastName;
    public static volatile SingularAttribute<Admin, String> image;
    public static volatile SingularAttribute<Admin, String> note;
    public static volatile SingularAttribute<Admin, String> typeOfAdmin;
    public static volatile SingularAttribute<Admin, String> address;
    public static volatile SingularAttribute<Admin, String> sex;
    public static volatile SingularAttribute<Admin, Date> dateOfBirth;
    public static volatile SingularAttribute<Admin, String> firstName;
    public static volatile SingularAttribute<Admin, String> password;
    public static volatile SingularAttribute<Admin, String> phone;
    public static volatile CollectionAttribute<Admin, Admin> adminCollection;
    public static volatile CollectionAttribute<Admin, OnCall> onCallCollection;
    public static volatile SingularAttribute<Admin, Admin> adminId;
    public static volatile SingularAttribute<Admin, Integer> id;
    public static volatile SingularAttribute<Admin, String> email;
    public static volatile SingularAttribute<Admin, String> username;

}