package com.vpdq.pojo;

import com.vpdq.pojo.MedicalRecord;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-21T19:06:19")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, String> note;
    public static volatile SingularAttribute<Service, BigDecimal> price;
    public static volatile SingularAttribute<Service, String> name;
    public static volatile SingularAttribute<Service, Integer> id;
    public static volatile CollectionAttribute<Service, MedicalRecord> medicalRecordCollection;

}