package com.pthtw.pojo;

import com.pthtw.pojo.Nurse;
import com.pthtw.pojo.Schedule;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-19T00:29:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ScheduleNurse.class)
public class ScheduleNurse_ { 

    public static volatile SingularAttribute<ScheduleNurse, Nurse> nurseId;
    public static volatile SingularAttribute<ScheduleNurse, Integer> id;
    public static volatile SingularAttribute<ScheduleNurse, Schedule> scheduleId;

}