<template>
  <div class="main">
    <div id="container">
      <div class="navigation">
        <h1 class="logo-box"><img class="logo-pic" src="https://breweryfinder.org/wp-content/uploads/2020/07/craftybearicon-200x200.jpg" /><span class="logo-info">Brewster</span></h1>
        <div class="info-brew-box">
          <router-link v-bind:to="{ name: 'add-brewery' }"
            ><div class="add-brewer">Add brewery</div></router-link
          >
          <div><all-breweries /></div>
          <router-link v-bind:to="{ name: 'login' }"
            ><div class="login">Login</div></router-link
          >
          <router-link v-bind:to="{ name: 'register' }"
            ><div class="login">Register</div></router-link
          >
        </div>
      </div>

      <p class="information">
        Check out our site to find breweries near you! Login to see what's going on.
      </p>
    </div>
  </div>
</template>

<script>
// import AddBrewery from "@/components/AddBrewery";
import AllBreweries from "@/components/AllBrewerys.vue";
export default {
  name: "homepage",
  components: {
    AllBreweries, //TODO
  },
};
</script>

<style scoped>
.main {
  background-image: url("https://breweryfinder.org/wp-content/uploads/2016/10/BreweryFinder.org_Splash_Header_web.jpg");
  width: 100%;
  height: 100vh;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}

.navigation {
  display: flex;
  padding: 0px;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid white;
}
.logo-box{
  display: flex;
  align-items: center;
  font-family: cursive;

}
.logo-info {
  font-size: 60px;
  color: yellow;
  margin: 10px 0px 10px 0px;
}
.logo-pic{
  width: 80px;
  height: 80px;
  border-radius: 50%;
  margin-right: 10px;
  margin-left: 20px;
}

.info-brew-box {
  display: flex;
  justify-content: flex-end;
  margin-right: 30px;
}

.info-brew-box .login,
 .info-brew-box .add-brewer{
  font-size: 20px;
  color: yellow;
  border: 1px solid white;
  border-radius: 5px;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
  margin-left: 40px;
  background-color: rgb(23, 107, 218);
    font-family: cursive;

}
.add-brewer{
  margin-right: 40px;
    font-family: cursive;

}

.boxes {
  border: 10px solid rgb(238, 235, 235);
  width: 500px;
  height: 350px;
  margin: 0 auto;
  margin-top: 100px;
  border-radius: 20px;
  text-align: center;
}
.boxes li {
  font-size: 30px;
  list-style: none;
  margin: 15px 0px 30px 0px;
  color: rgb(35, 15, 216);
}

.information {
  font-size: 40px;
  color: yellow;
  width: 60%;
  margin: 0 auto;
  text-align: center;
  margin-top: 200px;
  border: 1px solid white;
  background-color: rgb(35, 15, 216);
  opacity: 0.8;
  border-radius: 15px;
    font-family: cursive;

}
</style>
