<template>
<main id="main-grid">
  <div class="home">
  <div class="background">
    <h1>Welcome to Washington DC</h1>

    
        
    <h3> Washington, DC, the capital of the United States, is steeped in history and politics. Iconic landmarks like the White House, Capitol, and Washington Monument define its skyline. The city is a cultural hub, boasting world-renowned museums and galleries, particularly the Smithsonian Institution. Whether you're here for business or pleasure, please enjoy your stay in Washington, DC! </h3>
    <div class="image-container">
      <img src="https://media4.giphy.com/media/3oKIPCUrWnuSA3QAg0/giphy.gif?cid=6c09b9527zc629bhcgjhu0mf2t29urwpyztk2nsz12vinh8j&ep=v1_internal_gif_by_id&rid=giphy.gif&ct=g" alt="My Image" />
    </div> 
    
    <h2>Check out Washington DC's famous attractions</h2>
    <b-container class =  "image-container">
      <b-col cols="3">
        <a href="http://localhost:8080/allMuseums">
          <b-row>
            <img src="https://64.media.tumblr.com/86c04eba0c1ffff8b228c08d0e35e562/tumblr_ok1e3sqm9M1r5j9hco1_1280.gif" alt="Link Image">
          </b-row>
          <b-row>
            <b-col lg="4" class="pb-2"><b-button size="sm" variant="outline-info">Museums</b-button></b-col>
          </b-row>
        </a>
      </b-col>
      <b-col cols="3">
        <a href="http://localhost:8080/allMonuments">
          <b-row align-v="center">
            <img src="https://media3.giphy.com/media/d9H8UyYkH32CmNS9fw/200w.gif?cid=82a1493bp6mncximilhtoyh774e718bja96ugf8lenzkvnmo&ep=v1_gifs_related&rid=200w.gif&ct=g" alt="Link Image">
          </b-row>
           <b-row align-v="center">
              <b-col lg="4" class="pb-2"><b-button size="sm" variant="outline-info">Monuments</b-button></b-col>
           </b-row>
        </a>
      </b-col>
    </b-container>
  </div>
  </div>
  </main>
</template>

<script>
import service from '../services/ServerService'

export default {
  name: "home",
  data() {
    return {
      monumentsList : []
    }
  },
  created() {
    service.getAllMonuments().then(
      (response) => {
        this.monumentsList = response.data;
      }
    );
  }
};
</script>

<style scoped>

h1 {
  text-align: center;
  color: white;
  padding-top: 150px;
  flex-direction: column;
  justify-content: space-between;
  grid-area:"welcome";
}

h2 {
  text-align: center;
  color: white;
  padding-top: 100px;
  flex-direction: column;
  justify-content: space-between;
  grid-area:"welcome";
}

.image-container img {
  width: 350px;
  height: 250px;
  /* top: 50%; */
  /* left: 50%; */
  /* transform: translate(-50%, -50%); */
}

.image-container{
  display: flex;
  justify-content: center;
  align-items: center;
  /* height: 100vh; Adjust the height as needed */
}

#main-grid{
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
  "welcome welcome"
  "row2 row2"
  "row3 row3"
  "row4-1 row4-2"
  "row5-1 row5-2";
  align-items: center;

}

h3{
  text-align: center;
  color: white;
  padding-left: 150px;
  padding-right: 150px;
}

.background {
position: absolute;
top: 0;
left: 0;
width: 100%;
height: 100%;
background-color:rgb(202, 63, 63);  
z-index: -1;  
}


</style>
