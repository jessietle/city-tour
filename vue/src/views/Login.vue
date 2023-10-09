<template class = "background">
<body class = "background center ">
  <div id="login" >
    <!-- <div class="  container  "> -->
      <!-- <div class="background">
        <div class="container">
          <div class="content"> -->
            <form class="form-size" @submit.prevent="login">
              <h1>Welcome to City Tours </h1>
              <h1>Washington DC</h1>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <h1>Please Sign In</h1>
              <div role="alert" v-if="invalidCredentials">
                Invalid username and password!
              </div>
              <div role="alert" v-if="this.$route.query.registration">
                Thank you for registering, please sign in.
              </div>
              <div class="form-input-group">
                <label for="username">Username</label>
                <input
                  type="text"
                  id="username"
                  v-model="user.username"
                  required
                  autofocus
                />
              </div>
              <div class="form-input-group">
                <label for="password">Password</label>
                <input
                  type="password"
                  id="password"
                  v-model="user.password"
                  required
                />
              </div>
              <button type="submit">Sign in</button>
              <p>
                <router-link :to="{ name: 'register' }"
                  >Need an account? Sign up.</router-link
                >
              </p>
            </form>
          <!-- </div>
        </div> -->
       <!-- </div> -->
    <!-- </div> -->
  </div>
  </body>
</template>
<script scoped>
import authService from "../services/AuthService";
export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
<style scoped>
form {
  background-image: url('/src/images/capital2.jpg');
  /* height: 500px;  */
   /* padding: 100px; */
   padding-top: 50px;
   padding-left: 80px;
  background-position: center;
  background-repeat: no-repeat;
  margin: auto;
  /* box-shadow: 10px 5px 5px red; */
}
#login {
  /* display: flex; */
  justify-content: center;
  margin: auto;
  color: white;
}
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
.form-size {
  width: 700px;
  height: 700px;
}
.center {
  display: flex;
  justify-content: center;
}
.centered-text {
  text-align: center;
}
h1 {
  color: white;
}
.container {
  height: 100vh; /* Make the container take up the full height of the viewport */
  display: flex;
  justify-content: center; /* Center the content horizontally */
  align-items: flex-end; /* Align the content to the bottom */
}
.content {
  text-align: center; /* Center the text within the content div */
}
</style>
<style scoped>
#login {
  display: flex;
  justify-content: center;
  height: 1000px;
  width: 564px;
}
  #login {
    display: flex;
    justify-content: center;
    height: 500px;
    width: 564px;
  }
  .content {
  position: relative;
  z-index: 1; /* Place it above the background */
}
.background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  background-color: #0A3161;
  z-index: -1;
  }
/*
  #router-link {
    color: white;
  } */
/* #app {
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin: 2rem 0 4rem 0;
    position: relative;
    box-shadow:
      0 2px 4px 0 rgba(0, 0, 0, 0.2),
      0 2.5rem 5rem 0 rgba(0, 0, 0, 0.1);
  } */
</style>