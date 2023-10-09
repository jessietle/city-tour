<template>
  <div>
    <select v-model="selectedItinerary" @change="updateItinerary(selectedItinerary)">
      <option
        v-for="itinerary in itineraries"
        :key="itinerary.id"
        :value="itinerary.id"
      >
        {{ itinerary.name }}
      </option>
    </select>
  </div>
</template>

<script>
import service from "../services/ServerService";
export default {
  name: "select",
  props: {
      updateItineraryId: Function,
  },
  data() {
    return {
      selectedItinerary: "",
      itineraries: {},
    };
  },
  created() {
    service.getAllItineraries().then((response) => {
      this.itineraries = response.data;
    });
  },
  methods: {
      updateItinerary(id) {
          this.updateItineraryId(id);
      }
  }
};
</script>

<style>
</style>
