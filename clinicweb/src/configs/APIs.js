import axios from "axios";
import cookie from "react-cookies";

const BASE_URL = 'http://localhost:8080/PrivateClinicWebsite/';

export const endpoints = {
    'specialities': '/api/specialities/',
    'speciality-details': (specialityId) => `/api/specialities/${specialityId}/`,
    'doctors-in-speciality': (specialityId) => `/api/specialities/${specialityId}/doctors/`,
    'doctors': '/api/doctors/',
    'appointments': '/api/appointments/',
    'register': '/api/users/',
    'login': '/api/login/',
    'current-user': '/api/current-user/'
}

export const authApi = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            'Authorization': `${cookie.load('token')}`
        }
    });
}

export default axios.create({
    baseURL: BASE_URL
});