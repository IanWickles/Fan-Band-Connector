import axios from 'axios';

export default {

    messageList() {
        return axios.get('/inbox');
    },

    get(messageId) {
        return axios.get(`/messages/${messageId}`);
    },
    addBand(message) {
        return axios.post('/messages', message);
    },
    updateBand(message) {
        return axios.put(`/messages/${message.id}`, message);
    },
    deleteBand(messageId) {
        return axios.delete(`/messages/${messageId}`);
    },
}
