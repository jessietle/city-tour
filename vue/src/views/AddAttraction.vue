<template>
<div>
  <h1>Test Page </h1>
  <p>testing</p>
</div>
</template>

<script>
import service from "../services/ServerService";
export default {
  methods: {
    addAttractionToList(){
      service.addAttractionToList(this.itineraryId, this.monumentId)
        .then((response) => {
          if (response.status === 200) {
            window.alert('Monument Added!');
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

    deleteAttractionFromList(){
      service.removeAttractionFromList(this.itinerary, this.monumentId)
        .then((response) => {
          if (response === 200) {
            window.alert('Monument Removed!');
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
}
}
</script>

<style>
</style>