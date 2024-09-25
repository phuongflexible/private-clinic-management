package com.pthtw.pojo;

import com.pthtw.pojo.Appointment;
import com.pthtw.pojo.Nurse;
import com.pthtw.pojo.PaymentMethod;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-19T00:29:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Receipt.class)
public class Receipt_ { 

    public static volatile SingularAttribute<Receipt, Double> medicineCost;
    public static volatile SingularAttribute<Receipt, Appointment> appointmentId;
    public static volatile SingularAttribute<Receipt, PaymentMethod> paymentMethodId;
    public static volatile SingularAttribute<Receipt, Nurse> nurseId;
    public static volatile SingularAttribute<Receipt, Integer> id;
    public static volatile SingularAttribute<Receipt, Date> paymentTime;
    public static volatile SingularAttribute<Receipt, Double> medicalCost;

}