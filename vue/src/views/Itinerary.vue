<template>
  <div id="itinerary_page">
    <create-itinerary id="create-form"/>

    <b-container>
      <b-row>
        <b-col cols="4" v-for="itinerary in itineraries" v-bind:key="itinerary.id">
          <itinerary-card v-bind:itinerary="itinerary"/>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import CreateItinerary from '../components/CreateItinerary.vue';
import ItineraryCard from '../components/ItineraryCard.vue';
import service from '../services/ServerService';

export default {
  components: { CreateItinerary, ItineraryCard },
  name: 'itinerary',
  data() {
    return {
      itineraries: {}
    }
  },
  created() {
    service.getAllItineraries().then(res => this.itineraries = res.data);
  },
};
</script>

<style scoped>
  #create-form {
    width: 40vw;
    margin: auto;
  }
  #itinerary_page {
    background: rgb(2,0,36);
    background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(234,169,237,1) 0%, rgba(113,218,240,1) 100%);
  }
</style>
