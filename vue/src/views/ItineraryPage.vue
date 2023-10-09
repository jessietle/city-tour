<template>
<div>
  <p>Select Itinerary to Create a Route</p>
  <itinerary-select></itinerary-select>
  <itinerary-map></itinerary-map>

  

    <!-- <itinerary-table-row
    v-for="itinerary in filteredItinerary"
    v-bind:key="itinerary.id"
    v-bind:itinerary="itinerary"/>

    <div v-show="filteredItinerary.length ==0"></div> -->

 
  
  </div>

</template>

<script>

import ItineraryMap from '../components/ItineraryMap.vue'
import ItinerarySelect from '../components/ItinerarySelect.vue'
import service from '../services/ServerService'
// import ItineraryTableRow from '../components/ItineraryTableRow.vue'
export default {
  name: 'Map',
  props: "",
  components: {
    ItineraryMap,
    ItinerarySelect,
    // ItineraryTableRow
  },
  computed: {
    filteredItinerary() {
      const itineraryFilter = this.$store.state.filter;
      return this.$store.state.itineraries.filter(
        (itinerary) => {
          return itineraryFilter ==0? true : itinerary.id == itineraryFilter;
        }
      )
    }
  },
  data() {
    return {
 
      itineraryList : []
    }
  },
  created() {
    service.getAllItineraries().then(
      (response) => {
        this.itineraryList = response.data;
      }
    )
  }
}
</script>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: white;
  margin-top: 60px;
}


.background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  background-color: white; 
  z-index: -1; 
  }
</style>
