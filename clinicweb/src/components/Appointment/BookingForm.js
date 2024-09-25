import { useEffect, useState } from "react";
import { Button, Card, Form, Toast, ToastContainer } from "react-bootstrap";
import APIs, { endpoints } from "../../configs/APIs";
import MySpinner from "../Commons/MySpinner";
import moment from "moment";

const BookingForm = () => {
  const [specialities, setSpecialities] = useState(null);
  const [doctors, setDoctors] = useState([]);
  const [showToast, setShowToast] = useState(false);
  const [speciality, setSpeciality] = useState(null);
  const [loading, setLoading] = useState(false);

  const [appointmentForm, setAppointmentForm] = useState({
    patientId: "1",
    doctorId: "",
    appointmentDate: "",
    shift: "",
    reason: "",
  });

  const loadSpecs = async () => {
    try {
      let res = await APIs.get(endpoints["specialities"]);
      setSpecialities(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  const loadDoctors = async () => {
    try {
      let res = await APIs.get(endpoints["doctors-in-speciality"](speciality));
      setDoctors(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadSpecs();
  }, []);

  useEffect(() => {
    loadDoctors();
  }, [speciality]);

  const booking = async (e) => {
    e.preventDefault();

    appointmentForm.appointmentDate = moment(
      appointmentForm.appointmentDate
    ).format("DD/MM/YYYY");

    setLoading(true);

    try {
      let res = await APIs.post(endpoints["appointments"], appointmentForm);

      if (res.status === 201) {
        setShowToast(true);
      }
    } catch (ex) {
      console.error(ex);
      alert("Đặt lịch thất bại! Vui lòng kiểm tra lại thông tin!");
    } finally {
      setLoading(false);
    }
  };

  const change = (e, field) => {
    setAppointmentForm((current) => {
      return { ...current, [field]: e.target.value };
    });
  };

  return (
    <>
      <Form onSubmit={booking}>
        <Card>
          <Card.Header as="h5" className="bg-primary text-light text-center">
            Đặt lịch khám
          </Card.Header>
          <Card.Body className="bg-info shadow border-0">
            <Form.Group className="mb-2" controlId="speciality">
              <Form.Label>Chọn chuyên khoa</Form.Label>
              <Form.Select
                value={speciality}
                onChange={(e) => setSpeciality(e.target.value)}
              >
                <option>Chọn chuyên khoa</option>
                {specialities === null ? (
                  <MySpinner />
                ) : (
                  <>
                    {specialities.map((s) => (
                      <option key={s.id} value={s.id}>
                        {s.name}
                      </option>
                    ))}
                  </>
                )}
              </Form.Select>
            </Form.Group>

            <Form.Group className="mb-2" controlId="doctorId">
              <Form.Label>Chọn bác sĩ</Form.Label>
              <Form.Select
                value={appointmentForm.doctorId}
                onChange={(e) => change(e, "doctorId")}
              >
                {speciality === null ? (
                  <option>Vui lòng chọn chuyên khoa trước</option>
                ) : doctors.length === 0 ? (
                  <option className="text-danger">
                    Không có bác sĩ trong khoa này
                  </option>
                ) : (
                  <>
                    <option>Chọn bác sĩ</option>
                    {doctors.map((d) => (
                      <option key={d.id} value={d.id}>
                        {d.name}
                      </option>
                    ))}
                  </>
                )}
              </Form.Select>
            </Form.Group>

            <Form.Group className="mb-2" controlId="appointmentDate">
              <Form.Label>Chọn ngày khám</Form.Label>
              <Form.Control
                type="date"
                value={appointmentForm.appointmentDate}
                onChange={(e) => change(e, "appointmentDate")}
              />
            </Form.Group>

            <Form.Group className="mb-2" controlId="shift">
              <Form.Label>Chọn ca khám</Form.Label>
              <Form.Select
                value={appointmentForm.shift}
                onChange={(e) => change(e, "shift")}
              >
                <option>Chọn ca khám</option>
                <option value="Sáng">Sáng</option>
                <option value="Chiều">Chiều</option>
                <option value="Tối">Tối</option>
              </Form.Select>
            </Form.Group>

            <Form.Group className="mb-3" controlId="reason">
              <Form.Label>Lý do khám</Form.Label>
              <Form.Control
                as="textarea"
                rows={3}
                placeholder="Tôi cảm thấy..."
                value={appointmentForm.reason}
                onChange={(e) => change(e, "reason")}
              />
            </Form.Group>

            <Button
              type="submit"
              variant="primary"
              className="d-block mx-auto"
              disabled={loading}
            >
              {loading ? <MySpinner /> : "Đặt ngay"}
            </Button>
          </Card.Body>
        </Card>
      </Form>

      <ToastContainer
        className="my-3 position-fixed"
        position="top-center"
        style={{ zIndex: 1 }}
      >
        <Toast
          onClose={() => setShowToast(false)}
          show={showToast}
          delay={4000}
          autohide
        >
          <Toast.Header>
            <strong className="me-auto">Thông báo</strong>
          </Toast.Header>
          <Toast.Body>
            Đặt lịch thành công! Vui lòng chờ xác nhận lịch hẹn!
          </Toast.Body>
        </Toast>
      </ToastContainer>
    </>
  );
};

export default BookingForm;
