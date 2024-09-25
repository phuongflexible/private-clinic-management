import { useState } from "react";
import { Button, Form, Container, Row, Col, Card } from "react-bootstrap";
import MySpinner from "../Commons/MySpinner";
import APIs, { endpoints } from "../../configs/APIs";
import { useNavigate } from "react-router-dom";

const Register = () => {
    const [form, setForm] = useState({
        user: {
            username: "",
            password: "",
            confirm: ""
        },
        patient: {
            name: "",
            gender: "",
            phoneNumber: "",
            email: "",
            file: null
        }
    });
    const [loading, setLoading] = useState(false);
    const nav = useNavigate();
    const accountFields = [
        {
            field: "username",
            label: "Tên đăng nhập",
            type: "text",
            placeholder: "VD: thanhan123"
        },
        {
            field: "password",
            label: "Mật khẩu",
            type: "password",
            placeholder: "Mật khẩu"
        },
        {
            field: "confirm",
            label: "Xác nhận mật khẩu",
            type: "password",
            placeholder: "Xác nhận mật khẩu"
        }
    ];

    const profileFields = [
        {
            field: "file",
            label: "Ảnh đại diện",
            type: "file",
            placeholder: null
        },
        {
            field: "name",
            label: "Tên người dùng",
            type: "text",
            placeholder: "VD: Nguyễn Thanh An"
        },
        {
            field: "gender",
            label: "Giới tính",
            type: "select",
            placeholder: null
        },
        {
            field: "phoneNumber",
            label: "Số điện thoại",
            type: "phone",
            placeholder: "VD: 0987654321"
        },
        {
            field: "email",
            label: "Email",
            type: "email",
            placeholder: "VD: thanhan@gmail.com"
        }
    ];

    const change = (e, field, category) => {
        if (category === 'patient' && field === 'file') {
            setForm(current => ({
                ...current,
                patient: {
                    ...current.patient,
                    file: e.target.files[0]
                }
            }));
        } else {
            setForm(current => ({
                ...current,
                [category]: {
                    ...current[category],
                    [field]: e.target.value
                }
            }));
        }
    };

    const register = async (e) => {
        e.preventDefault();

        setLoading(true);

        try {
            const formData = new FormData();
            formData.append('username', form.user.username);
            formData.append('password', form.user.password);
            formData.append('name', form.patient.name);
            formData.append('gender', form.patient.gender);
            formData.append('phoneNumber', form.patient.phoneNumber);
            formData.append('email', form.patient.email);
            if (form.patient.file) {
                formData.append('file', form.patient.file);
            }

            await APIs.post(endpoints['register'], formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            });
            nav('/login');
        } catch (ex) {
            console.error(ex);
            alert("Đã xảy ra lỗi khi đăng ký!");
        } finally {
            setLoading(false);
        }
    };

    return (
        <Container>
            <Row className="justify-content-md-center">
                <Col md={6} xs={12}>
                    <h2 className="my-4 text-center text-primary">ĐĂNG KÝ TÀI KHOẢN</h2>

                    <Form onSubmit={register}>
                        <Card className="mb-4 shadow border-0">
                            <Card.Header as="h5" className="bg-dark text-light text-center">Tạo tài khoản</Card.Header>
                            <Card.Body>
                                {accountFields.map(f => (
                                    <Form.Group key={f.field} className="mb-2" controlId={f.field}>
                                        <Form.Label>{f.label}</Form.Label>
                                        <Form.Control
                                            type={f.type}
                                            placeholder={f.placeholder}
                                            value={form.user[f.field]}
                                            onChange={e => change(e, f.field, 'user')} />
                                    </Form.Group>
                                ))}
                            </Card.Body>
                        </Card>

                        <Card className="mb-4 shadow border-0">
                            <Card.Header as="h5" className="bg-dark text-light text-center">Thông tin tài khoản</Card.Header>
                            <Card.Body>
                                {profileFields.map(f => (
                                    <Form.Group key={f.field} className="mb-2" controlId={f.field}>
                                        <Form.Label>{f.label}</Form.Label>
                                        {f.type === "select" ? (
                                            <Form.Select
                                                value={form.patient[f.field]}
                                                onChange={e => change(e, f.field, 'patient')}>
                                                <option>Chọn giới tính</option>
                                                <option value="male">Nam</option>
                                                <option value="female">Nữ</option>
                                                <option value="other">Khác</option>
                                            </Form.Select>
                                        ) : (
                                            f.type === "file" ? (
                                                <Form.Control
                                                    type={f.type}
                                                    onChange={e => change(e, f.field, 'patient')} />
                                            ) : (
                                                <Form.Control
                                                    type={f.type}
                                                    placeholder={f.placeholder}
                                                    value={form.patient[f.field]}
                                                    onChange={e => change(e, f.field, 'patient')} />
                                            )
                                        )}
                                    </Form.Group>
                                ))}
                            </Card.Body>
                        </Card>

                        <Button variant="primary" type="submit" className="mb-3 d-block mx-auto">
                            {loading ? <MySpinner /> : "Đăng ký"}
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );
}

export default Register;
