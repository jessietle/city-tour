<template>
  <div>
    <h3>Delete Museum</h3>
    <button v-on:click="deleteMuseum">Delete?</button>
  </div>
</template>

<script>
import service from '../services/ServerService.js';
export default {
    data() {
        return {
            museumId: -1
        }
    }, 
    created() {
        this.museumId = this.$route.params.id;
    }, 
    methods: {
        deleteMuseum() {
            service.deleteMuseum(this.museumId).then(
                (response) => {
                    if(response.status == 200) {
                        window.alert('Museum Deleted!');
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