package com.pthtw.pojo;

import com.pthtw.pojo.Appointment;
import com.pthtw.pojo.MedicinesInPrescription;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-19T00:29:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Prescription.class)
public class Prescription_ { 

    public static volatile SingularAttribute<Prescription, String> symptoms;
    public static volatile SingularAttribute<Prescription, String> note;
    public static volatile SingularAttribute<Prescription, Date> createdDate;
    public static volatile SingularAttribute<Prescription, Appointment> appointmentId;
    public static volatile SingularAttribute<Prescription, String> diagnosis;
    public static volatile SingularAttribute<Prescription, Integer> id;
    public static volatile SetAttribute<Prescription, MedicinesInPrescription> medicinesInPrescriptionSet;

}