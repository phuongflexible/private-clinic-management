import { useEffect, useState } from "react";
import { Button, Container, Form, Nav, NavDropdown, Navbar } from "react-bootstrap";
import APIs, { endpoints } from "../../configs/APIs";
import { Link, useNavigate } from "react-router-dom";
import MySpinner from "./MySpinner";

const Header = () => {
    const [specialities, setSpecialities] = useState(null);
    const [kw, setKw] = useState("");
    const nav = useNavigate();

    const loadSpecs = async () => {
        try {
            let res = await APIs.get(endpoints['specialities']);
            setSpecialities(res.data);
        } catch (ex) {
            console.error(ex);
        }
    }

    useEffect(() => {
        loadSpecs();
    }, [])

    const submit = (event) => {
        event.prevenDefault();
        nav(`/?kw=${kw}`);
    }

    return (
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container fluid>
                <Navbar.Brand as={Link} to="/">Phòng mạch tư</Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        <Nav.Link as={Link} to="/">Trang chủ</Nav.Link>

                        <NavDropdown title="Chuyên khoa" id="navbarScrollingDropdown">
                            {specialities === null ? <MySpinner /> : <>
                                {specialities.map(s =>
                                    <Link key={s.id} className="nav-link" to={`/specialities/${s.id}`}>{s.name}</Link>)}
                            </>}
                        </NavDropdown>

                        <Nav.Link as={Link} to="/doctors">
                            Đội ngũ bác sĩ
                        </Nav.Link>

                        <Nav.Link as={Link} to="/appointments">
                            &#128197; Lịch khám
                        </Nav.Link>
                    </Nav>

                    <Form className="d-flex me-auto" onSubmit={submit}>
                        <Form.Control value={kw} onChange={e => setKw(e.target.value)}
                            type="search"
                            placeholder="Tìm kiếm"
                            className="me-2"
                        />
                        <Button type="submit" variant="info">Tìm</Button>
                    </Form>

                    <Button onClick={() => { nav("/register") }} className="me-2" variant="outline-success">Đăng ký</Button>
                    <Button onClick={() => { nav("/login") }} className="me-2" variant="outline-primary">Đăng nhập</Button>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default Header;