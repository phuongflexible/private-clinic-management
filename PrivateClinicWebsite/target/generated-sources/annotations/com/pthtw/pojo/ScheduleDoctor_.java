package com.pthtw.pojo;

import com.pthtw.pojo.Doctor;
import com.pthtw.pojo.Schedule;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-19T00:29:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ScheduleDoctor.class)
public class ScheduleDoctor_ { 

    public static volatile SingularAttribute<ScheduleDoctor, Doctor> doctorId;
    public static volatile SingularAttribute<ScheduleDoctor, Integer> id;
    public static volatile SingularAttribute<ScheduleDoctor, Schedule> scheduleId;

}