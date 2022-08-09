import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    get(id) {
        return http.get(`/users/${id}`);
    },
    updateUser(user) {
        return http.put(`/users/${user.id}`, user);
    },

}
