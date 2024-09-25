package com.pthtw.pojo;

import com.pthtw.pojo.Medicine;
import com.pthtw.pojo.Prescription;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-19T00:29:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(MedicinesInPrescription.class)
public class MedicinesInPrescription_ { 

    public static volatile SingularAttribute<MedicinesInPrescription, String> dosage;
    public static volatile SingularAttribute<MedicinesInPrescription, String> note;
    public static volatile SingularAttribute<MedicinesInPrescription, Prescription> prescriptionId;
    public static volatile SingularAttribute<MedicinesInPrescription, Integer> quantity;
    public static volatile SingularAttribute<MedicinesInPrescription, Medicine> medicineId;
    public static volatile SingularAttribute<MedicinesInPrescription, Integer> id;

}