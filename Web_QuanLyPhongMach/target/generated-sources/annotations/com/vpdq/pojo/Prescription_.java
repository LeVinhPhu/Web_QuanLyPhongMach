package com.vpdq.pojo;

import com.vpdq.pojo.MedicalRecord;
import com.vpdq.pojo.Medicine;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-01T16:05:30")
@StaticMetamodel(Prescription.class)
public class Prescription_ { 

    public static volatile SingularAttribute<Prescription, String> note;
    public static volatile SingularAttribute<Prescription, Integer> quantity;
    public static volatile SingularAttribute<Prescription, BigDecimal> price;
    public static volatile SingularAttribute<Prescription, Medicine> medicineId;
    public static volatile SingularAttribute<Prescription, Integer> id;
    public static volatile SingularAttribute<Prescription, MedicalRecord> medicalRecordId;

}