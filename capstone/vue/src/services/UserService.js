import axios from 'axios';

export default {
    get(id) {
        return axios.get(`/user/${id}`);
    },
    updateUser(user) {
        return axios.put(`/user/${user.id}`, user);
    },

}
