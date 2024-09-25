package com.pthtw.pojo;

import com.pthtw.pojo.Doctor;
import com.pthtw.pojo.Nurse;
import com.pthtw.pojo.Patient;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-19T00:29:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Doctor> doctor;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Patient> patient;
    public static volatile SingularAttribute<User, Nurse> nurse;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> username;

}