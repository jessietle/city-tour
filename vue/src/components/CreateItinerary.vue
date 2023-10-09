<template>
  <div>
    <h3>Create New Itinerary</h3>
    <div class="text-center">
      <b-spinner variant="info" ></b-spinner>
      <b-spinner variant="info" ></b-spinner>
      <b-spinner variant="info" ></b-spinner>
      <b-spinner variant="info" ></b-spinner>
      <b-spinner variant="info" ></b-spinner>
    </div>
    <b-form @submit="onSubmit" @reset="onReset">
      <b-form-group
        id="input-group-1"
        label="Choose the Date for Your Itinerary:"
        label-for="input-1"
      >
        <b-form-datepicker id="input-1" v-model="newItinerary.date" class="mb-2"></b-form-datepicker>
      </b-form-group>

      <b-form-group id="input-group-2" label="Name Your Itinerary:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newItinerary.name"
          placeholder="Enter name"
          required
        ></b-form-input>
      </b-form-group>

      <b-button class="form-button" type="submit" variant="primary">Submit</b-button>
      <b-button class="form-button" type="reset" variant="danger">Reset</b-button>
    </b-form>
  </div>
</template>

<script>
import service from "../services/ServerService.js";

export default {
  data() {
    return {
      newItinerary: {},
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      service
        .createItinerary(this.newItinerary)
        .then((response) => {
          if (response.status === 200) {
            window.location.reload();
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
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.newItinerary = {};
    },
  },
};
</script>
<style scoped>
  .form-button {
    margin: 20px;
  }
</style>
