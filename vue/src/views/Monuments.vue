<template>
  <div class="background">
    <container class="container">
      <h1>Monuments Page</h1>
      <p v-bind:style="{ color: '#f2f2f2' }">Select Itinerary to Update</p>

      <itinerary-select   v-bind:updateItineraryId = "updateItineraryId"></itinerary-select>
    </container>
    <form v-on:submit.prevent="addAttractionToList">
      <div class="monuments">
        <div>
          <div
            class="monumentCard"
            v-for="monument in monumentsList"
            v-bind:key="monument.id"
          >
            <h3>{{ monument.name }}</h3>
            <p>{{ monument.description }}</p>
            <p>{{ monument.address }}</p>
            <img v-bind:src="monument.image" />
            <p>Rating: {{ monument.rate }}</p>

            <div>
              <button
                type="button"
                id="monumentName"
                @click="addAttractionToList(monument.id)"
              >
                Add to Itinerary
              </button>
            </div>
          </div>
          <button type="submit" v-if="$store.state.token != ''">
            View Itinerary!
          </button>
          {{ filteredList }}
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import ItinerarySelect from "../components/ItinerarySelect.vue";
import service from "../services/ServerService";

export default {
  name: "monuments",
  components: {
    ItinerarySelect,
  },
  data() {
    return {
      monumentsList: [],
      filteredList: [],
      itineraryId: "",
    };
  },
  created() {
    service.getAllMonuments().then((response) => {
      this.monumentsList = response.data;
    });
  },
  methods: {
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
    filterMonuments(monumentName, monumentAddress) {
      this.filteredList.push(monumentName, monumentAddress);
    },
  },
};
</script>

<style scoped>
div.monumentCard {
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
  background-color: #b31942;
  z-index: -1;
}
</style>
