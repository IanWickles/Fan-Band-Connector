import axios from 'axios';

export default {
    get(userId) {
        return axios.get(`/user/${userId}`);
    },
    updateUser(user) {
        return axios.put(`/user/${user.id}`, user);
    },

}
