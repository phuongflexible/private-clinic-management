package com.pthtw.pojo;

import com.pthtw.pojo.Appointment;
import com.pthtw.pojo.ScheduleDoctor;
import com.pthtw.pojo.Speciality;
import com.pthtw.pojo.User;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-19T00:29:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Doctor.class)
public class Doctor_ { 

    public static volatile SingularAttribute<Doctor, Date> birthday;
    public static volatile SetAttribute<Doctor, Appointment> appointmentSet;
    public static volatile SingularAttribute<Doctor, String> phoneNumber;
    public static volatile SingularAttribute<Doctor, String> gender;
    public static volatile SetAttribute<Doctor, ScheduleDoctor> scheduleDoctorSet;
    public static volatile SingularAttribute<Doctor, String> name;
    public static volatile SingularAttribute<Doctor, String> avatar;
    public static volatile SingularAttribute<Doctor, Integer> id;
    public static volatile SingularAttribute<Doctor, User> userId;
    public static volatile SingularAttribute<Doctor, Speciality> specialityId;
    public static volatile SingularAttribute<Doctor, String> email;

}