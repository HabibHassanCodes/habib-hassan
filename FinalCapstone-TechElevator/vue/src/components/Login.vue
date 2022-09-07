<template>
<div class="box">
      <form class="info-form" @submit.prevent="login">
        <fieldset>
          <legend>Please Login Here</legend>
          <p class="form-para">Please Provide Login Information Below</p>
            <br>
            <div
              class="alert alert-danger"
              role="alert"
              v-if="invalidCredentials"
            >Invalid username and password!</div>
            <div
              class="alert alert-success"
              role="alert"
              v-if="this.$route.query.registration"
            >Thank you for registering, please sign in.</div>
            <br>
          <label for="username">Username:</label>
          <input
            type="text"
            id="username"
            name="username"
            placeholder=" Please type username"
            v-model="user.username"
            required
            autofocus
          /><br />
          <label for="password">Password:</label>
          <input
            type="password"
            id="password"
            name="password"
            placeholder="Please provide password"
            v-model="user.password"
            required
          /><br />
            <div class="submit-area">
              <button class="submit" type="submit">Sign in</button>
              <router-link class="need-account" :to="{ name: 'register' }">Need an account?</router-link> 
            </div>
        </fieldset>
      </form>
</div>
    <!-- <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal heading">Sign In</h1>
      <br>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <br>
      <div class="form-field">
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Enter thou brewname"
        v-model="user.username"
        required
        autofocus
      />
      </div>
      <br>
      <div class="form-field">
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Shh. Don't Tell Anyone!"
        v-model="user.password"
        required
      />
      </div>
      <br>
      <div class="form-field">
      <router-link class="need-account" :to="{ name: 'register' }">Need an account?</router-link> 
      <button class="submit" type="submit">Sign in</button>
      </div>
    </form>
  </div> -->
</template>

<script>
import authService from "../services/AuthService";

export default {
    data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
    
}
</script>

<style scoped>
.box{
  width: 35%;
  margin: 0 auto;
  
}

.info-form{
  width: 90%;
  margin: 0 auto;


}
fieldset{
  border-radius: 15px;
  height: 500px;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: rgb(229, 226, 226);
}
legend{
  text-align: center;
  font-size: 35px;
  font-family: sans-serif;
  color: rgb(110, 65, 65);
}
.form-para{
  font-size: 20px;
    margin: 35px 0px 35px 0px;
}

label{
  width: 80%;
  font-size: 20px;
  margin-bottom: 10px;
}
input{
  width: 75%;
  padding: 15px;
  border-radius: 10px;
  border-color: rgb(85, 80, 133);
}
.submit-area{
  display: flex;
  flex-direction: column;
   width: 150px;
   align-items: center;
}
.submit{
  width: 100%;
  height: 50px;
  font-size: 20px;
  background-color: rgb(9, 179, 247);
  border-radius: 10px;
  border: 1px solid white;
  margin-bottom: 10PX;
}
.submit:hover {
  background-color: #86cbf3;
  color: white;
}
* {
  padding: 0;
  margin: 0;
}

#login {
  height: 87vh;
 
}

form.form-signin {
  position: absolute;
  right: 0;
  margin: 5vh;
  max-width: 300px;
  padding: 16px;
  border-radius: 5px;
  padding-left: 30px;
} 

h1 {
  margin: -5px 0px -20px 0px;
  font-size: 2rem;
}

.form-signin {
  background-color: #f2f2f2;
  background-position: center;
  background-size: 100vh;
  backdrop-filter: blur(5px);
  box-shadow: inset 0px 0px 10px #000;
}

#username.form-control {
    font-size: 50;
    margin-left: .5rem;
    margin-top: 1rem;
}

#password.form-control {
  font-size: 50;
  margin-left: .7rem;
  margin-top: 1rem;
}

a.need-account {
  text-decoration: none;
  color: #FF3C00;

}

.need-account:hover {
  color: #311D00;
  text-decoration: underline;
}


.alert {
  margin-top: 1rem;
}
</style>