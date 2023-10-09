<template>
  <div>
      <h3>Add Museum</h3>
      <form v-on:submit.prevent="addMuseum">
          <!-- Add museum details here -->
          
          <button>Save</button>
      </form>
  </div>
</template>

<script>
import service from '../services/ServerService.js';

export default {
    data() {
        return {
            newMuseum: {}
        }
    },
    methods: {
        addMuseum() {
            // call the service function
            service.addMuseum(this.newMuseum).then(
                (response) => {
                    if(response.status == 200) {
                        window.alert('Museum Added!');
                        this.newMuseum = {};
                        this.$router.push({name: 'home'});
                    }
                }
            );
        }
    }
}
</script>

<style>

</style>