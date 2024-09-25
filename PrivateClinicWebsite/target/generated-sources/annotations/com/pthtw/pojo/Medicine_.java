package com.pthtw.pojo;

import com.pthtw.pojo.Category;
import com.pthtw.pojo.MedicinesInPrescription;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-19T00:29:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Medicine.class)
public class Medicine_ { 

    public static volatile SingularAttribute<Medicine, String> unit;
    public static volatile SingularAttribute<Medicine, Integer> quantity;
    public static volatile SingularAttribute<Medicine, Double> price;
    public static volatile SingularAttribute<Medicine, String> name;
    public static volatile SingularAttribute<Medicine, String> description;
    public static volatile SingularAttribute<Medicine, Integer> id;
    public static volatile SingularAttribute<Medicine, Category> categoryId;
    public static volatile SetAttribute<Medicine, MedicinesInPrescription> medicinesInPrescriptionSet;

}