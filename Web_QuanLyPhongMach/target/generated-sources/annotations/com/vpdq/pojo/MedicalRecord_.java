package com.vpdq.pojo;

import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Employee;
import com.vpdq.pojo.Prescription;
import com.vpdq.pojo.Service;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-29T09:39:33")
@StaticMetamodel(MedicalRecord.class)
public class MedicalRecord_ { 

    public static volatile SingularAttribute<MedicalRecord, String> conclusion;
    public static volatile SingularAttribute<MedicalRecord, Date> billingDate;
    public static volatile SingularAttribute<MedicalRecord, String> note;
    public static volatile SingularAttribute<MedicalRecord, String> symptom;
    public static volatile SingularAttribute<MedicalRecord, Employee> doctorId;
    public static volatile SingularAttribute<MedicalRecord, Customer> customerId;
    public static volatile SingularAttribute<MedicalRecord, Employee> nurseId;
    public static volatile SingularAttribute<MedicalRecord, Integer> id;
    public static volatile SingularAttribute<MedicalRecord, Service> serviceId;
    public static volatile CollectionAttribute<MedicalRecord, Prescription> prescriptionCollection;

}