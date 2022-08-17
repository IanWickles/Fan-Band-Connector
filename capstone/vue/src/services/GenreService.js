import axios from 'axios';

export default {

    list() {
        return axios.get('/genres');
    },

    getById(genreId) {
        return axios.get(`/genres/${genreId}`);
    },

    getByBand(bandName) {
        return axios.get(`/genres/band/${bandName}`);
    },
}
