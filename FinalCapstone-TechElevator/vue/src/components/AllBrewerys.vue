<template>
    <div>
      <button class="brew-btn" v-on:click="retrieveAllBreweries">
          <router-link v-bind:to="{ name: 'all-brew-info' }"
            ><div class="add-brewer">All Breweries</div></router-link>
        </button>
      <button class="homepage">
        <router-link v-bind:to="{ name: 'homepage' }">
          <div class="goHome">Home</div></router-link>
      </button>
    <div
      id="appoint_grid"
      class="cards"
      v-for="item in allBreweries"
      v-bind:key="item.breweryID"
    >
      <div id="cssEdits" class="card">
        <h1 id="breweryName" class="breweryName">{{ item.breweryName }}</h1>
        <div class="detail" id="breweryDescription"><span class="infos">Description:</span><br><span class="info-detail">{{ item.breweryDescription }}</span></div>
        <div class="detail" id="streetName"><span class="infos">Address:</span><br><span class="info-detail">{{ item.streetName }},{{ item.zipCode }}</span></div>
        <div class="detail" id="phoneNumber"><span class="infos">Phone Number:</span><br><span class="info-detail">{{ item.phoneNumber }}</span></div>
        <div class="detail" id="websiteUrl"><span class="infos">Website:</span><br><a href="#" class="info-detail">{{ item.websiteUrl }}</a></div>
      </div>
       </div>
    </div>
</template>
<script>
import boardsService from "../services/AuthService";
export default {
  name: "all-breweries",
  components: {
    //BoardColumn TODO
  },
  props: {
    boardId: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      allBreweries : [],
      isLoading: true,
      errorMsg: ""
    };
  },
  methods: {
    retrieveAllBreweries() {
      boardsService
        .getAllBreweries()
        .then(response => {
          this.allBreweries = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Board cards not available. This board may have been deleted or you have entered an invalid board ID."
            );
            this.$router.push({ name: 'Home' });
          }
        });
    },
  },
};
</script>
<style scoped>
.card{
    padding:100px;
    margin: 10px;
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    grid-template-rows: repeat(4, 1fr);
    grid-column-gap: 10px;
    grid-row-gap: 25px;
    border: 2px solid rgb(48, 47, 47);
    border-radius: 15px;
    background-color: rgb(222, 222, 226);
}
.detail .infos{
  font-size: 40px;
  color: rgb(73, 73, 73);
  font-family: cursive;
}
.info-detail{
font-size: 25px;
font-style: italic;
color: rgb(43, 189, 233);
  font-family: cursive;
}
#breweryName { grid-area: 1 / 1 / 2 / 6;
text-align: center;
font-size: 50px;
  font-family: cursive;
}
#address { grid-area: 2 / 4 / 4 / 6;
font-size: 30px;  
  font-family: cursive;
}
#breweryDescription { grid-area: 2 / 1 / 4 / 4; font-size: 30px;
  font-family: cursive;
}
#phoneNumber { grid-area:  4 / 1 / 5 / 3; font-size: 30px;   font-family: cursive;
}
#websiteUrl { grid-area: 4 / 4 / 5 / 6; font-size: 30px;   font-family: cursive;
}
.brew-btn{
  width: 200px;
  font-size: 18px;
  border-radius: 5px;
  border: 1px solid white;
  background-color: rgb(23, 107, 218);
  padding: 11px 20px 11px 20px;
    font-family: cursive;

}
.add-brewer {
  color: yellow;
    font-family: cursive;

}
.homepage {
  width: 200px;
  font-size: 18px;
  border-radius: 5px;
  border: 1px solid white;
  background-color: rgb(23, 107, 218);
  padding: 11px 20px 11px 20px;
  margin-left: 30px;
    font-family: cursive;
}
.goHome {
  color: yellow;
    font-family: cursive;

}
</style>