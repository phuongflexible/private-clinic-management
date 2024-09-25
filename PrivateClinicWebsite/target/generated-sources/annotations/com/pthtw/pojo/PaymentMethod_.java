package com.pthtw.pojo;

import com.pthtw.pojo.Receipt;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-19T00:29:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(PaymentMethod.class)
public class PaymentMethod_ { 

    public static volatile SetAttribute<PaymentMethod, Receipt> receiptSet;
    public static volatile SingularAttribute<PaymentMethod, String> name;
    public static volatile SingularAttribute<PaymentMethod, Integer> id;

}