<template>
<div class="box">
      <form class="info-form" @submit.prevent="register">
        <fieldset>
          <legend>Create Account</legend>
          <p class="form-para">Please Provide Information Below To Create Account</p>
            <br>
            <div class="alert alert-danger" role="alert" v-if="registrationErrors">
              {{ registrationErrorMsg }}
            </div>
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
          <label for="confirmPassword"> Confirm Password:</label>
          <input
            type="password"
            id="confirmPassword"
            name="confirmPassword"
            placeholder="Please confirm password"
            v-model="user.confirmPassword"
            required
          /><br />
            <div class="brewer">
              <label class="brewer-label"> Are you a Brewer? </label>
              <div class="checkbox">
                <input 
                type="checkbox"
                id="brewer-checkbox"
                class="checkbox"
                v-on:change="(user.role == 'user' ? user.role = 'brewer' : user.role = 'user')"
                />
              </div>
              <label class="yes"> Yes</label>
            </div>
              <br>
            <div class="submit-area">
              <button class="submit" type="submit">Create Account</button>
              <router-link class="have-account" :to="{ name: 'login' }">Already Have an account?</router-link> 
            </div>
        </fieldset>
      </form>
</div>
<!-- <div id="background">
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal heading">Create Account</h1>
      <br>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <br>
      <label for="username" class="sr-only">Username</label>
      <br>
      <input
        type="text"
        id="username"
        class="username-input-box"
        placeholder="What shall we call you?"
        v-model="user.username"
        required
        autofocus
      />
      <br>
      <div class="password">
        <label for="password" class="sr-only">Password</label>
        <br>
        <input
          type="password"
          id="password"
          class="password-input-box"
          placeholder="Please...not password123"
          v-model="user.password"
          required
        />
        <input
        type="password"
        id="confirmPassword"
        class="confirm-password-input-box"
        placeholder="One more time please"
        v-model="user.confirmPassword"
        required
        />
      </div>
      <br>
      <br>
      <div class="brewer">
        <label class="brewer-label"> Are you a Brewer? </label>
        <div class="checkbox">
          <input 
          type="checkbox"
          id="brewer-checkbox"
          class="checkbox"
          v-on:change="(user.role == 'user' ? user.role = 'brewer' : user.role = 'user')"
          />
        </div>
        <label class="yes"> Yes</label>
      </div>
        <br>
      <router-link class="have-account" :to="{ name: 'login' }">Have an account?</router-link>
      <button class=" create-account btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</div> -->
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
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
  height: 620px;
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
    margin: 35px 0px 5px 0px;
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
   width: 250px;
   align-items: center;
}
.submit{
  width: 70%;
  height: 50px;
  font-size: 20px;
  background-color: rgb(9, 179, 247);
  border-radius: 10px;
  border: 1px solid white;
  margin-bottom: 10PX;
}
.submit:hover {
  background-color: #86cbf3;
  color: yellow;
}
.checkbox{
  width: 15px;
  height: 15px;
}
* {
  padding: 0px;
  margin: 0;
  box-sizing: border-box;
}

#background {
  height: 87vh;
}

.password {
  margin-top: 1rem;
}

h1 {
  margin: -5px 0px -20px -12px;
  font-size: 2rem;
}

.sr-only {
  margin-left: -.6rem;
}

form.form-register {
  position: absolute;
  right: 0;
  margin: 5vh;
  max-width: 300px;
  padding: 16px;
  background-color: #f2f2f2;
  border-radius: 5px;
  padding-left: 30px;
} 

.username-input-box, .password-input-box, .confirm-password-input-box  {
  margin-top: .5rem;
  margin-left: -10px;
}

.have-account {
  text-decoration: none;
  color: #FF3C00;
}

.brewer {
  display: inline;
}
.checkbox {
  display: inline-block;
}

.have-account:hover {
  color: #311D00;
  text-decoration: underline;
}

.create-account {
  background-color: #FF3C00;
  border: none;
  font-size: 15px;
  padding: 3px;
  margin: 10px 0px 0px 10px;
  border-radius: 3px;
}

.create-account:hover {
  background-color: #311D00;
  color: white;
}
</style>
