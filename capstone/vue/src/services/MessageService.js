import axios from 'axios';

export default {

    list() {
        return axios.get('/messages');
    },

    get(id) {
        return axios.get(`/messages/${id}`);
    },
    addBand(band) {
        return axios.post('/messages', band);
    },
    updateBand(band) {
        return axios.put(`/messages/${band.id}`, band);
    },
    deleteBand(bandId) {
        return axios.delete(`/messages/${bandId}`);
    },
}
