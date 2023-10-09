<template>
  <div>
      <h3>Add Monument</h3>
      <form v-on:submit.prevent="addMonument">
         <!-- Add details of monuments here -->
        
          <button>Save</button>
      </form>
  </div>
</template>

<script>
import service from '../services/ServerService.js';

export default {
    data() {
        return {
            newMonument: {}
        }
    },
    methods: {
        addMonument() {
            // call the service function
            service.addMonument(this.newMonument).then(
                (response) => {
                    if(response.status == 200) {
                        window.alert('Monument Added!');
                        this.newMonument = {};
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