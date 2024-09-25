import { useEffect, useState } from "react";
import APIs, { endpoints } from "../../configs/APIs";
import { Table } from "react-bootstrap";

const Appointment = () => {
    const [appointments, setAppointments] = useState([]);

    const loadAppointments = async () => {
        try {
            let res = await APIs.get(endpoints['appointments']);
            setAppointments(res.data);

        } catch (ex) {
            console.error(ex);
        }
    }

    useEffect(() => {
        loadAppointments();
    }, [])

    return (
        <>
            {appointments.length !== 0 || appointments !== null ?
                <>
                    <h2 className="my-3 text-center text-primary">Lịch khám</h2>
                    <Table striped bordered hover className="text-center">
                        <thead>
                            <tr>
                                <th>Mã lịch khám</th>
                                <th>Chuyên khoa</th>
                                <th>Bác sĩ</th>
                                <th>Ngày hẹn khám</th>
                                <th>Ca khám</th>
                                <th>Lý do khám</th>
                                <th>Thời gian đặt lịch</th>
                                <th>Trạng thái</th>
                                <th>Toa thuốc, hóa đơn</th>
                            </tr>
                        </thead>
                        <tbody>
                            {appointments.map(a =>
                                <tr>
                                    <td>{a.id}</td>
                                    <td>{a.doctorId.specialityId.name}</td>
                                    <td>{a.doctorId.name}</td>
                                    <td>{a.appointmentDate}</td>
                                    <td>{a.shift}</td>
                                    <td>{a.reason}</td>
                                    <td>{a.createdTime}</td>
                                    <td>{a.status}</td>
                                    <td></td>
                                </tr>

                            )}
                        </tbody>
                    </Table>
                </> : <h2 className="my-3 text-center text-primary">
                    Bạn chưa đặt lịch khám nào!
                </h2>
            }
        </>
    )
}

export default Appointment;