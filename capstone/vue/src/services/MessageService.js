import axios from 'axios';

export default {

    messageList() {
        return axios.get('/inbox');
    },
    get(messageId) {
        return axios.get(`/messages/${messageId}`);
    },
    sendMessage(bandId, message) {
        return axios.post(`/bands/${bandId}/newmessage`, message); //how do I get bandId into this? Should we change the path?
    }
}
