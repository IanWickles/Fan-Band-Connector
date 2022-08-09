import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    list() {
        return http.get('/bands');
    },

    get(id) {
        return http.get(`/bands/${id}`);
    },
    addBand(band) {
        return http.post('/bands', band);
    },
    updateBand(band) {
        return http.put(`/bands/${band.id}`, band);
    },
    deleteBand(bandId) {
        return http.delete(`/bands/${bandId}`);
    },
}
