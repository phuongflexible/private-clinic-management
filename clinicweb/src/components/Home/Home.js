import { useEffect, useState } from "react";
import { Button, Card, Col, Row } from "react-bootstrap";
import APIs, { endpoints } from "../../configs/APIs";
import MySpinner from "../Commons/MySpinner";
import "./HomeStyle.css"
import { useNavigate } from "react-router-dom";
import BookingForm from "../Appointment/BookingForm";

const Home = () => {
    const [selectedDate, setSelectedDate] = useState(null);
    const [specialities, setSpecialities] = useState(null);
    const [doctors, setDoctors] = useState(null);
    const nav = useNavigate();

    const loadSpecs = async () => {
        try {
            let res = await APIs.get(endpoints['specialities']);
            setSpecialities(res.data);
        } catch (ex) {
            console.error(ex);
        }
    }

    const loadDoctors = async () => {
        try {
            let res = await APIs.get(endpoints['doctors']);
            setDoctors(res.data);
        } catch (ex) {
            console.error(ex);
        }
    }

    useEffect(() => {
        loadSpecs();
        loadDoctors();
    }, [])

    const booking = async (e) => {
        e.preventDefault();
        try {
            let res = await APIs.post(endpoints['appointments'])
        } catch (ex) {
            console.error(ex);
        }
    }

    return (
        <>
            <Row>
                <Col>
                    <Row>
                        {specialities === null ? <MySpinner /> : <>
                            {specialities.map(s => <Col key={s.id} md={4} xs={12}>
                                <Card className="my-3 card-spec">
                                    <Card.Img className="card-image" variant="top" src={s.image} />
                                    <Card.Body>
                                        <Card.Title className="text-center">Chuyên khoa<br/>{s.name}</Card.Title>
                                        <Button onClick={() => { nav(`/specialities/${s.id}`) }} variant="primary" className="d-block mx-auto">Xem chi tiết</Button>
                                    </Card.Body>
                                </Card>
                            </Col>
                            )}
                        </>}
                    </Row>
                </Col>
                <Col md={4} xs={12} className="my-3">
                    <BookingForm />
                </Col>
            </Row>
        </>
    );
}

export default Home;