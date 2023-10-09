<template>
  <div>
    <h3>Delete Monument</h3>
    <button v-on:click="deleteMonument">Delete?</button>
  </div>
</template>

<script>
import service from '../services/ServerService.js';
export default {
    data() {
        return {
            monumentId: -1
        }
    }, 
    created() {
        this.monumentId = this.$route.params.id;
    }, 
    methods: {
        deleteMonument() {
            service.deleteMonument(this.monumentId).then(
                (response) => {
                    if(response.status == 200) {
                        window.alert('Monument Deleted!');
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