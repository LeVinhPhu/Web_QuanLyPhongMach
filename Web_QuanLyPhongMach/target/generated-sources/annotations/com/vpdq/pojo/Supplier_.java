package com.vpdq.pojo;

import com.vpdq.pojo.Medicine;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-21T13:36:36")
@StaticMetamodel(Supplier.class)
public class Supplier_ { 

    public static volatile SingularAttribute<Supplier, String> companyName;
    public static volatile SingularAttribute<Supplier, Integer> id;
    public static volatile SetAttribute<Supplier, Medicine> medicineSet;

}