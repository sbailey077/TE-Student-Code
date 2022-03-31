import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    products: []
  },
  mutations: {
    SET_PRODUCTS(state, products) {
      state.products = products;
    }
 
  },
  actions: {
    getProducts({ commit }) {
      axios.get('products.json').then(response => {
        commit('SET_PRODUCTS', response.data);
      })
    } 
  },
  modules: {
  },
  strict: true
})
