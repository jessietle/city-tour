<template>
  <div>
    <h1>Add Review</h1>
    <add-review />
  </div>
</template>

<script>
import AddReview from "../components/AddReview.vue";

export default {
  components: {
    AddReview
  }
};
</script>

<style scoped>
h1 {
  display: flex;
  align-content: center;
  background-color: rgb(3, 3, 133);
  color: white;
}
  
</style>