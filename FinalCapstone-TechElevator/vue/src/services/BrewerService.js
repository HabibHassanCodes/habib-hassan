import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

    getBrewery(breweryName) {
        return http.get(`brewery/name/${breweryName}`);
    },
    getAllBrewery() {
        return http.get(`/allBrewery`)
    },
    create() {
        return http.post(`/brewery`);
    },
    updateBrewery(breweryId) {
        return http.put(`brewery${breweryId}`)
    }
//   getCards(boardID) {
//     return http.get(`/boards/${boardID}`)
//   }

}
