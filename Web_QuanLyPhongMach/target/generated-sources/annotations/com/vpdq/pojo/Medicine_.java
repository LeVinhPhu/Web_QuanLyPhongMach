package com.vpdq.pojo;

import com.vpdq.pojo.Prescription;
import com.vpdq.pojo.Supplier;
import com.vpdq.pojo.Unit;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-21T13:36:36")
@StaticMetamodel(Medicine.class)
public class Medicine_ { 

    public static volatile SingularAttribute<Medicine, BigDecimal> unitPrice;
    public static volatile SingularAttribute<Medicine, Date> expiryDate;
    public static volatile SingularAttribute<Medicine, String> image;
    public static volatile SingularAttribute<Medicine, String> note;
    public static volatile SetAttribute<Medicine, Prescription> prescriptionSet;
    public static volatile SingularAttribute<Medicine, Integer> quantity;
    public static volatile SingularAttribute<Medicine, Supplier> supplierId;
    public static volatile SingularAttribute<Medicine, String> name;
    public static volatile SingularAttribute<Medicine, Date> manufacturingDate;
    public static volatile SingularAttribute<Medicine, Unit> unitId;
    public static volatile SingularAttribute<Medicine, Integer> id;

}