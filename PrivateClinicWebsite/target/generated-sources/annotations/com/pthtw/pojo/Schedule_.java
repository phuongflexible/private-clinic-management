package com.pthtw.pojo;

import com.pthtw.pojo.ScheduleDoctor;
import com.pthtw.pojo.ScheduleNurse;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-19T00:29:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Schedule.class)
public class Schedule_ { 

    public static volatile SingularAttribute<Schedule, String> note;
    public static volatile SingularAttribute<Schedule, Date> workDate;
    public static volatile SingularAttribute<Schedule, String> shift;
    public static volatile SetAttribute<Schedule, ScheduleDoctor> scheduleDoctorSet;
    public static volatile SingularAttribute<Schedule, Integer> id;
    public static volatile SetAttribute<Schedule, ScheduleNurse> scheduleNurseSet;

}