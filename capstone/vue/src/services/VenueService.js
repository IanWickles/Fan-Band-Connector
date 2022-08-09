import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    list() {
        return http.get('/venues');
    },

    get(id) {
        return http.get(`/venues/${id}`);
    },
    addVenue(venue) {
        return http.post('/venues', venue);
    },
    updateVenue(venue) {
        return http.put(`/venues/${venue.id}`, venue);
    },
    deleteVenue(venueId) {
        return http.delete(`/venues/${venueId}`);
    },
}
