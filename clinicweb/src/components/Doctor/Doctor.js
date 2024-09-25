import { useEffect, useState } from "react";
import APIs, { endpoints } from "../../configs/APIs";
import { Button, Card, Col, Modal, Row } from "react-bootstrap";
import MySpinner from "../Commons/MySpinner";
import BookingForm from "../Appointment/BookingForm";
import './DoctorStyle.css'

const Doctor = () => {
    const [doctors, setDoctors] = useState(null);
    const [showBookingModal, setShowBookingModal] = useState(false);

    const loadDoctors = async () => {
        try {
            let res = await APIs.get(endpoints['doctors']);
            setDoctors(res.data);
        } catch (ex) {
            console.error(ex);
        }
    }

    useEffect(() => {
        loadDoctors();
    }, [])
    return (
        <>
            <h1 className="my-3 text-primary text-center">ĐỘI NGŨ BÁC SĨ</h1>
            {doctors === null ? <MySpinner /> :
                <Row>
                    {doctors.map(d =>
                        <Col md={3} sx={12} >
                            <Card className="mb-3 transparent-card">
                                <Card.Img variant="top" src={d.avatar} className="rounded-circle" />
                                <Card.Body className="text-center">
                                    <Card.Title>Bác sĩ {d.name}</Card.Title>
                                    <Card.Text>
                                        Chuyên khoa {d.specialityId.name}
                                    </Card.Text>
                                    <Button variant="primary"
                                        onClick={() => {
                                            // setSelectedDoctor(doctor.id);
                                            setShowBookingModal(true);
                                        }}>
                                        Đặt lịch khám
                                    </Button>
                                </Card.Body>
                            </Card>
                        </Col>
                    )}
                </Row>
            }
            <Modal show={showBookingModal} onHide={() => setShowBookingModal(false)}>
                <Modal.Header closeButton>
                </Modal.Header>
                <Modal.Body>
                    <BookingForm />
                </Modal.Body>
            </Modal>
        </>
    )
}

export default Doctor;