import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {}
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
     ADD_REVIEW(state,review) {
      const product = this.state.products.find(p => p.id == review.productID);

      

      let maxID = product.id * 1000;
      maxID = product.reviews.reduce( (maxID, review) => {
        return Math.max(maxID, review.id);
      }, maxID);
      review.id = maxID + 1;
      product.reviews.unshift(review);
    },
    UPDATE_FILTER(state, filter) {
      state.filter = filter;
    },
    FLIP_FAVORITED(state, reviewToChange) {
      reviewToChange.favorited = ! reviewToChange.favorited;
    },
    SET_ACTIVE_PRODUCT(state, productID) {
      state.activeProduct = productID;
    }
  },
  actions: {
  },
  modules: {
  },
  strict: true
})
