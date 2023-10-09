<template>
  <div class="background">
    <container class="container">
      <h1>Museums Page</h1>
      <p v-bind:style="{ color: '#f2f2f2' }" >Select Itinerary to Update</p>
      <itinerary-select v-bind:updateItineraryId = "updateItineraryId"></itinerary-select>
    </container>
    <form v-on:submit.prevent="addAttractionToList">
      <div class="monuments">
        <div>
          <div
            class="museumCard"
            v-for="museum in museumsList"
            v-bind:key="museum.id"
          >
            <h3>{{ museum.name }}</h3>
            <p>{{ museum.description }}</p>
            <img v-bind:src="museum.image" />
            <p>Rating: {{ museum.rate }}</p>
            <div>
              <button
                type="button"
                id="monumentName"
                @click="addAttractionToList(museum.id)"
              >
                Add to Itinerary
              </button>
            </div>
          </div>
          <button type="submit" v-if="$store.state.token != ''">
            Update Itinerary!
          </button>
          {{ filteredList }}
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import service from "../services/ServerService";
import ItinerarySelect from "../components/ItinerarySelect.vue";
export default {
  name: "museums",
  components: {
    ItinerarySelect,
  },
  data() {
    return {
      museumsList: [],
      filteredList: [],
      itineraryId: "",
      addIfChecked: false,
    };
  },
  created() {
    service.getAllMuseums().then((response) => {
      this.museumsList = response.data;
    });
  },
  methods: {
    submitMuseums(filteredList) {
      service
        .updateItinerary(filteredList)
        .then((response) => {
          if (response.status === 200) {
            window.alert("Itinerary Updated!");
          }
        })
        .catch((error) => {
          if (error.response) {
            window.alert("Bad Request");
          } else if (error.request) {
            window.alert("Could not reach service");
          }
        });
    },

    // for adding attraction to itinerary
    updateItineraryId(id) {
      this.itineraryId = id;
    },

    addAttractionToList(id) {
      service
        .addAttractionToList(this.itineraryId, id)
        .then((response) => {
          if (response.status === 200) {
            window.alert("Monument Added!");
          }
        })
        .catch((error) => {
          if (error.response) {
            window.alert("Bad Request");
          } else if (error.request) {
            window.alert("Could not reach service");
          }
        });
    },
  },
};
</script>

<style scoped>
div.museumCard {
  border: 1px 0A3161;
  background-color: white;
  border-radius: 6px;
  padding: 1rem;
  margin: 20px;
  font: 12pt sans-serif;
}

img {
  height: 100px;
}

h1 {
  text-align: center;
  color: white;
  padding-top: 50px;
}

.background {
  position: absolute;
  top: 0;
  left: 0;
  background-color: #0a3161;
  z-index: -1;
}
</style>
