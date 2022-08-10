import axios from 'axios';

export default {

    list() {
        return axios.get('/bands');
    },

    get(id) {
        return axios.get(`/bands/${id}`);
    },
    addBand(band) {
        return axios.post('/bands', band);
    },
    updateBand(band) {
        return axios.put(`/bands/${band.id}`, band);
    },
    deleteBand(bandId) {
        return axios.delete(`/bands/${bandId}`);
    },
}
