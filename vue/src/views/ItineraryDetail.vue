<template>
  <div>
    <itinerary-map v-bind:itinerary="itinerary"/>
  </div>
</template>

<script>
import service from '../services/ServerService';
import ItineraryMap from '../components/ItineraryMap.vue'

export default {
  props: ['itineraryId'],
  name: 'itineraryDetail',
  components: {
    ItineraryMap,
  },
  data() {
    return {
      itinerary: {}
    }
  },
  created() {
    service.getItinerary(this.itineraryId).then(res => this.itinerary = res.data);
  }
};
</script>

<style scoped>
</style>
