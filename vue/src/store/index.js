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
    user: currentUser || {},

    // filter: 0,
    // nextItineraryId: 1004,
    // itineraries: [
    //   {
    //     id: 1000,
    //     itinerary: 'Itinerary 1',
    //     attractions: 'National Gallery of Art || Smithsonian National Museum of Natural History || National Air and Space Museum',
    //     addresses:
    //       "Constitution Ave. NW, Washington, DC 20565 || 10th St. & Constitution Ave. NW, Washington, DC 20560 || 600 Independence Ave SW, Washington, DC 20560",

    //   },
    //   {
    //     id: 1001,
    //     itinerary: 'Itinerary 2',
    //     attractions: 'World War II Memorial || Washington Monument || Vietnam Veterans Memoral',
    //     addresses:
    //       "1750 Independence Ave SW, Washington, DC 20024 || 1750 Independence Ave SW, Washington, DC 20024 || 5 Henry Bacon Dr NW, Washington, DC 20002",

    //   },
    //   {
    //     id: 1002,
    //     itinerary: 'Itinerary 3',
    //     attractions: 'Lincoln Memorial || Korean War Memorial',
    //     addresses:
    //       " 2 Lincoln Memorial Circle, NW, Washington, D.C. || 900 Ohio Dr SW, Washington, DC 20024",
    //   },
    //   {
    //     id: 1003,
    //     itinerary: 'Itinerary 4',
    //     attractions: 'Martin Luther King Jr. Memorial || Titanic Memorial',
    //     addresses:
    //       "1964 Independence Ave SW, Washington, DC 20004 || 41 1st Ave, Southwest Washington, DC 20319",
    //   },
    // ],
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
      ADD_ITINERARY(state, itinerary) {
        itinerary.id = state.nextItineraryId++;
        state.itineraries.unshift(itinerary);
      },
      // ADD_ITINERARY(state, itinerary) {
      //   itinerary.id = state.nextItineraryId++;
      //   state.itineraries.unshift(itinerary);
      // }
    },
   

 
  

})
