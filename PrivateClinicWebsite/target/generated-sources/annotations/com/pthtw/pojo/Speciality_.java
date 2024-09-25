package com.pthtw.pojo;

import com.pthtw.pojo.Doctor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-19T00:29:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Speciality.class)
public class Speciality_ { 

    public static volatile SingularAttribute<Speciality, String> image;
    public static volatile SingularAttribute<Speciality, String> name;
    public static volatile SingularAttribute<Speciality, String> description;
    public static volatile SetAttribute<Speciality, Doctor> doctorSet;
    public static volatile SingularAttribute<Speciality, Integer> id;

}