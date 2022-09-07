import axios from 'axios';
export default {
  login(user) {
    return axios.post('/login', user)
  },
  register(user) {
    return axios.post('/register', user)
  },
  getAllBeers(){
    return axios.get('/allBeer')
  },
  getAllBreweries(){
    return axios.get('/allBrewery')
  }
}